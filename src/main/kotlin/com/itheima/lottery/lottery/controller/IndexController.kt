package com.itheima.lottery.lottery.controller

import com.google.common.io.BaseEncoding
import com.itheima.lottery.lottery.bean.BallHistory
import com.itheima.lottery.lottery.service.BallHistoryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import sun.security.rsa.RSASignature

/**
 * @author 钟未鸣
 * @date 2018/6/23
 */
@Controller
class IndexController {

    @RequestMapping("/")
    fun index(model: Model): String {
        val page: Pageable = PageRequest.of(0, 10, Sort.Direction.DESC, "code")
        val histories = historyService.findAll(page)

        model.addAttribute("histories", histories.content)

        return "index"
    }


    @RequestMapping("lottery-detail")
    fun lotteryDetail(code:String,model: Model): String {
        val ballHistory:BallHistory? = historyService.findOne(code)
        model.addAttribute("history",ballHistory)

        return "lottery-detail"
    }

    @Autowired
    lateinit var historyService: BallHistoryService
}