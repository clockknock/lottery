package com.itheima.lottery.lottery.service

import com.itheima.lottery.lottery.bean.BallHistory
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

/**
 * @author 钟未鸣
 * @date 2018/6/23
 */
interface BallHistoryService {
    fun findAll():List<BallHistory>
    fun findAll(page:Pageable): Page<BallHistory>
    fun findOne(code:String): BallHistory?

    fun save(ballHistory: BallHistory)
    fun saveAll(ballHistories: List<BallHistory>)
}