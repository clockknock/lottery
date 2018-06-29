package com.itheima.lottery.lottery.bean

import com.fasterxml.jackson.databind.annotation.JsonSerialize
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

/**
 * @author 钟未鸣
 * @date 2018/6/27
 */
@Entity
class OrderItem {
    //0.订单项的编号
    @Id
    var itemid: String? = null
    //1.购买的是哪一期
    var code: String? = null
    //2.购买红球的号码
    @JsonSerialize var reds: Array<String>? = null
    //3.购买的蓝球号码
    var blue: String? = null
    //4.购买的数量
    var count: Int = 0
    //6.这一项是属于哪个订单的
    var oid: String? = null
}