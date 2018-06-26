package com.itheima.lottery.lottery.repository

import com.itheima.lottery.lottery.bean.User
import org.springframework.data.jpa.repository.JpaRepository

/**
 * @author 钟未鸣
 * @date 2018/6/24
 */
interface UserRepository : JpaRepository<User, String> {
    fun findByUsernameAndPassword(username: String, password: String): User?
}