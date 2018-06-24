package com.itheima.lottery.lottery.bean

import javax.persistence.*


/**
 * @author 钟未鸣
 * @date 2018/6/23
 */
@Entity
@Table(name = "prizegrade")
class PrizeGrade {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var pid: Int? = null
    //几等奖
    var type: Int? = null
    //中了几注
    var typenum: Int? = null
    //中奖金额
    var typemoney: Long? = null
    //属于哪一期
    var code: String? = null
}