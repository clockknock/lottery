package com.itheima.lottery.lottery.bean

import java.util.*


/**
 * @author 钟未鸣
 * @date 2018/6/26
 */
class Cart {
    //    保存所有的商品
    private val map = HashMap<Int, CartItem>()

    //1.添加的方法
    fun add(cartItem: CartItem) {
        //02,04,13,25,28,29-16

        //1.先判断购物车中是否已经包含了这注彩票 key:红球-蓝球 02,04,13,25,28,29 - 16
        val itemHash = cartItem.hashCode()
        if (map.containsKey(itemHash)) {
            //2.若包含了,则取出对应的cartItem修改购买的数量
            val oldCartItem = map[itemHash]
            if (oldCartItem != null) {
                val oldCount = oldCartItem.count
                oldCartItem.count = oldCount + 1
            }

        } else {
            //3.若没有包含,则直接添加进去
            println("map新增一个:${map.size}")
            map[itemHash] = cartItem
        }
    }

    //2.删除指定的彩票的方法 02,04,13,25,28,29-16
    fun remove(cartItem: CartItem) {
        map.remove(cartItem.hashCode())
    }

    //3.清空的方法
    fun clear() {
        map.clear()
    }

    //4.获取总金额的方法
    fun getTotal(): Double {
        var total = 0.0
        //将map中所有cartItem取出来累加里面
        for (key in map.keys) {
            val cartItem = map[key]
            total += cartItem?.subTotal!!
        }
        return total
    }

    //添加一个获取map中所有cartItem的方法
    fun getCartItems(): Collection<CartItem> {
        return map.values
    }

}