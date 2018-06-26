package com.itheima.lottery.lottery.controller

import com.itheima.lottery.lottery.bean.Cart
import com.itheima.lottery.lottery.bean.CartItem
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpSession

/**
 * @author 钟未鸣
 * @date 2018/6/26
 */
@Controller
@RequestMapping("/cart")
class CartController {

    @RequestMapping("/select-numberUI")
    fun selectNumberUI(randomOneFlag: Boolean?, model: Model, request: HttpServletRequest): String {
        if (randomOneFlag != null && randomOneFlag) {
            println("adding")
            model.addAttribute("randomOneFlag", true)
//            request.setAttribute("randomOneFlag",true)
        }
        println("addAttribute end")
        return "select-number"
    }

    @RequestMapping("/cartUI")
    fun cartUI(session: HttpSession): String {
        val cart = session.getAttribute("cart") as Cart

        session.setAttribute("cart", cart)
        return "cart"
    }

    @RequestMapping("/add")
    @ResponseBody
    fun add(@RequestBody balls: Array<CartItem>, session: HttpSession): HashMap<String, Int> {
        val cart: Cart = session.getAttribute("cart") as Cart

        balls.forEach {
            cart.add(it)
        }

        session.setAttribute("cart", cart)
        val map = HashMap<String, Int>()

        map["count"] = cart.getTotalCount()
        return map
    }

    @GetMapping("/remove")
    fun remove(itemHash: Int, session: HttpSession): String {
        try {
            val cart = session.getAttribute("cart") as Cart

            cart.remove(itemHash)
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            return "redirect:/cart/cartUI"
        }
    }

    @GetMapping("/clear")
    fun clear( session: HttpSession): String {
        val cart = session.getAttribute("cart") as Cart
        cart.clear()
        return "redirect:/cart/cartUI"
    }

}