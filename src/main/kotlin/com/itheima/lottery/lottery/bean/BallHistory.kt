package com.itheima.lottery.lottery.bean

import com.itheima.lottery.lottery.utils.String2List
import javax.persistence.*


/**
 * @author 钟未鸣
 * @date 2018/6/23
 */
@Entity
@Table(name = "ballhistory")
class BallHistory {
    //彩票的期数
    @Id
    var code: String? = null
    //彩票的名称
    var name: String? = null
    //日期
    var date: String? = null
    //周几开的奖
    var week: String? = null
    //红球的数量
    var red: String? = null

    /**
     * @Transient 不能直接给委托的属性,需要用@deltegate:Xxxxx
     * 数据库保存设计不合理,用list就好了
     * this annotation is not applicable to target 'member property with delegate'
     */
    @delegate:Transient
    var reds: List<String>? by String2List

    //蓝球
    var blue: String? = null
    //销售额
    var sales: Long? = null
    //奖池金额
    var poolmoney: Long? = null
    //一等奖中奖信息
    var content: String? = null
    @OneToMany(cascade = [(CascadeType.ALL)], fetch = FetchType.EAGER, mappedBy = "code")
    var prizegrades: List<PrizeGrade>? = null

    override fun toString(): String {
        return "BallHistory(code=$code, name=$name, date=$date, week=$week, red=$red, blue=$blue," +
                " sales=$sales, poolmoney=$poolmoney, content=$content, " +
                "prizegrades=${prizegrades?.size})"
    }
}