package com.itheima.lottery.lottery.service.impl

import com.itheima.lottery.lottery.bean.Order
import com.itheima.lottery.lottery.repository.OrderRepository
import com.itheima.lottery.lottery.service.OrderService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * @author 钟未鸣
 * @date 2018/6/27
 */
@Service
class OrderServiceImpl : OrderService {
    override fun findById(id: String): Order {
        return orderRepository.findById(id).get()
    }

    override fun save(order: Order) {
        orderRepository.save(order)
    }

    override fun findAll(): List<Order> {
        return orderRepository.findAll()
    }

    @Autowired
    lateinit var orderRepository: OrderRepository

}