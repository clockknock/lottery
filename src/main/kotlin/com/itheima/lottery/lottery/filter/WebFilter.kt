package com.itheima.lottery.lottery.filter

import com.itheima.lottery.lottery.bean.Cart
import com.itheima.lottery.lottery.bean.User
import org.hibernate.annotations.FilterDef
import javax.servlet.*
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * @author 钟未鸣
 * @date 2018/6/26
 */
class WebFilter : Filter {
    override fun destroy() {
    }

    override fun doFilter(request: ServletRequest, response: ServletResponse, chain: FilterChain) {
        val req: HttpServletRequest = request as HttpServletRequest
        val resp: HttpServletResponse = response as HttpServletResponse
        val session = req.session
        var cart = session.getAttribute("cart") as Cart?
        if (cart == null) {
            cart = Cart()
            session.setAttribute("cart", cart)
        }

        chain.doFilter(req, resp)

    }


    override fun init(filterConfig: FilterConfig?) {
    }

}