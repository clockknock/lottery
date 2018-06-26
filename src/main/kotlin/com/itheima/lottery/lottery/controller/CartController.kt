package com.itheima.lottery.lottery.controller

import com.itheima.lottery.lottery.bean.Cart
import com.itheima.lottery.lottery.bean.CartItem
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import javax.servlet.http.HttpSession

/**
 * @author 钟未鸣
 * @date 2018/6/26
 */
@Controller
@RequestMapping("/cart")
class CartController {

//    @RequestMapping("/add")
//    @ResponseBody
//    fun add(@RequestBody balls:Item): String {
//        println(balls)
//        return "成功"
//    }

    @RequestMapping("/select-number")
    fun selectNumber(): String {
        return "select-number"
    }

    @RequestMapping("/add")
    @ResponseBody
    fun add(@RequestBody balls: Array<CartItem>, session: HttpSession): HashMap<String, Int> {
        var cart: Cart? = session.getAttribute("cart") as Cart?
        if (cart == null) {
            cart = Cart()
        }

        balls.forEach {
            cart.add(it)
        }

        session.setAttribute("cart",cart)
        val map = HashMap<String, Int>()
        val cartItems = cart.getCartItems()
        var numsCount=0
        cartItems.forEachIndexed { _, cartItem ->
            numsCount+= cartItem.count
        }
        map["count"]= numsCount
        return map
    }

}