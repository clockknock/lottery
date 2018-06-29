package com.itheima.lottery.lottery.service

import com.itheima.lottery.lottery.bean.Order

/**
 * @author 钟未鸣
 * @date 2018/6/27
 */
interface OrderService {
    fun save(order: Order)
    fun findAll():List<Order>

    fun findById(id:String):Order

}