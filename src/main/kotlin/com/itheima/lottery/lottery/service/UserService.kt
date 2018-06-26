package com.itheima.lottery.lottery.service

import com.itheima.lottery.lottery.bean.User

/**
 * @author 钟未鸣
 * @date 2018/6/24
 */
interface UserService {

    fun save(user: User)

    fun findByUsernameAndPassword(username:String,password:String):User?
}