package com.itheima.lottery.lottery.bean

import java.util.*

/**
 * @author 钟未鸣
 * @date 2018/6/26
 */


data class CartItem(var reds: Array<String>, var blue: String,val price:Int=2,var count:Int=1) {
    //购买的是哪一期
    var code:String?=null
    //这一项是属于哪个订单的
    var oid: String? = null

    var subTotal:Int=0
    get() {
        return count*price
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as CartItem

        if (!Arrays.equals(reds, other.reds)) return false
        if (blue != other.blue) return false

        return true
    }

    override fun hashCode(): Int {
        var result = Arrays.hashCode(reds)
        result = 31 * result + blue.hashCode()
        return result
    }
}