package com.itheima.lottery.lottery.bean

import java.util.*
import javax.persistence.*

/**
 * @author 钟未鸣
 * @date 2018/6/27
 */
@Entity(name = "orders")
data class Order(
        @Id var oid: String,
        var createTime: Date,
        var state: Int,
        var total: Double,
        var uid: String,
        @OneToMany(cascade = [(CascadeType.ALL)], mappedBy = "oid")
        var orderItems: List<OrderItem>
)