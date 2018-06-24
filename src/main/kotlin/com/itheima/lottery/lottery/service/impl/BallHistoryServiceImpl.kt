package com.itheima.lottery.lottery.service.impl

import com.itheima.lottery.lottery.bean.BallHistory
import com.itheima.lottery.lottery.repository.BallHistoryRepository
import com.itheima.lottery.lottery.service.BallHistoryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

/**
 * @author 钟未鸣
 * @date 2018/6/23
 */
@Service
class BallHistoryServiceImpl : BallHistoryService{
    override fun findAll(): List<BallHistory> {
        return historyRepository.findAll()
    }

    override fun findAll(page: Pageable): Page<BallHistory> {
        /* all.content.forEach {
            it.redArray = it.red?.split(",")
        }*/
        return historyRepository.findAll(page)
    }

    override fun findOne(code: String): BallHistory? {
        return historyRepository.findById(code).get()
    }

    @Autowired
    lateinit var historyRepository: BallHistoryRepository

}