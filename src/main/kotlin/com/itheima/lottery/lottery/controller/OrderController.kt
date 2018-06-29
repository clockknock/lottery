package com.itheima.lottery.lottery.controller

import com.itheima.lottery.lottery.bean.Cart
import com.itheima.lottery.lottery.bean.Order
import com.itheima.lottery.lottery.bean.OrderItem
import com.itheima.lottery.lottery.bean.User
import com.itheima.lottery.lottery.service.OrderService
import com.itheima.lottery.lottery.utils.UUIDUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.RequestMapping
import java.util.*
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpSession

/**
 * @author 钟未鸣
 * @date 2018/6/27
 */
@Controller
@RequestMapping("/order")
class OrderController {

    @RequestMapping("/submit")
    fun submit(model: Model, session: HttpSession,request:HttpServletRequest): String {
        request.getParameter("username")
        val cart = session.getAttribute("cart") as Cart
        val user = session.getAttribute("user") as User

        val oid = UUIDUtil.getId()

        val orderItems = arrayListOf<OrderItem>()

        cart.getCartItems().forEach {
            val orderItem = OrderItem()
            orderItem.itemid = UUIDUtil.getId()
            orderItem.blue = it.blue
            orderItem.reds = it.reds
            orderItem.count = it.count
            orderItem.oid = oid
            orderItem.code = "20180627期"
            orderItems.add(orderItem)
        }
        val order = Order(
                UUIDUtil.getId(),
                Date(),
                0,
                cart.getTotalPrice(),
                user.username!!,
                orderItems
        )

        orderService.save(order)
        model.addAttribute("order", order)

        return "order-detail"
    }

    @Autowired
    lateinit var orderService: OrderService

}