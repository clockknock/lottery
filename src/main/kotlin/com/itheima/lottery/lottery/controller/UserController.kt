package com.itheima.lottery.lottery.controller

import com.itheima.lottery.lottery.bean.User
import com.itheima.lottery.lottery.service.UserService
import com.itheima.lottery.lottery.utils.BallUtil
import com.itheima.lottery.lottery.utils.MD5Util
import com.itheima.lottery.lottery.utils.SmsUtil
import com.itheima.lottery.lottery.utils.UUIDUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import sun.security.provider.MD5
import javax.servlet.http.HttpSession

/**
 * @author 钟未鸣
 * @date 2018/6/24
 */
@Controller
@RequestMapping("/user")
class UserController {
    @Value("\${salt}")
    lateinit var salt: String


    @RequestMapping("/myUI")
    fun myUI(session: HttpSession,model: Model): String {
        val user: User? = session.getAttribute("user") as User?
        return if (user == null) {
            "login"
        } else {
            model.addAttribute("reds",BallUtil.randomRed())
            model.addAttribute("blue",BallUtil.randomBlue())
            "my"
        }
    }

    @PostMapping("/")
    fun save(user: User): String {
        user.uid = UUIDUtil.getId()
        user.password = MD5Util.encodeSalt(user.password!!, salt)

        userService.save(user)
        return "redirect:loginUI"
    }

    @RequestMapping("/login")
    fun login(user: User, model: Model, session: HttpSession): String {
        val password = MD5Util.encodeSalt(user.password!!, salt)
        val find = userService.findByUsernameAndPassword(user.username!!, password)
        return if (find != null) {
            println("登录成功")
            session.setAttribute("user", find)
            "redirect:myUI"
        } else {
            println("登录失败")
            model.addAttribute("username", user.username)
            "redirect:loginUI"
        }

    }

    @RequestMapping("/sendSms")
    @ResponseBody
    fun sendSms(mobile:String): String {
        try {
            smsUtil.sendSms(mobile)
        } catch (e: Exception) {
            e.printStackTrace()
            return "验证码发送失败"
        }

        return "验证码发送成功"
    }

    @RequestMapping("/loginUI")
    fun loginUI(): String {
        return "login"
    }

    @RequestMapping("/registerUI")
    fun registerUI(): String {
        return "register"
    }

    @Autowired
    lateinit var userService: UserService
    @Autowired
    lateinit var smsUtil: SmsUtil
}