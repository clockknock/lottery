package com.itheima.lottery.lottery.service.impl

import com.itheima.lottery.lottery.bean.User
import com.itheima.lottery.lottery.repository.UserRepository
import com.itheima.lottery.lottery.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * @author 钟未鸣
 * @date 2018/6/24
 */
@Service
class UserServiceImpl: UserService{
    override fun save(user: User) {
        userRepository.save(user)
    }

    override fun findByUsernameAndPassword(username: String, password: String): User? {
        return userRepository.findByUsernameAndPassword(username,password)
    }

    @Autowired
    lateinit var userRepository: UserRepository

}