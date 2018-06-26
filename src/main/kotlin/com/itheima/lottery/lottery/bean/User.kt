package com.itheima.lottery.lottery.bean

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

/**
 * @author 钟未鸣
 * @date 2018/6/24
 */
@Entity
class User {
    //用户的编号
    @Id
    var uid: String? = null
    //邮箱
    @Column(unique = true)
    var email: String? = null
    //用户密码
    var password: String? = null
    //用户名
    var username: String? = null
    //手机号码
    var mobile: String? = null
    //用户的头像
    var headimg: String? = null
    //当前用户的生日
    var birthday: String? = null
    //用户的状态:0 未激活, 1,已激活, 2: 已封号
    var state: Int? = null
    // 账户余额
    var money: Double = 0.toDouble()
}