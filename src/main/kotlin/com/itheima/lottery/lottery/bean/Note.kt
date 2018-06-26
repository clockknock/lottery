package com.itheima.lottery.lottery.bean

import javax.persistence.Entity
import javax.persistence.Id

/**
 * @author 钟未鸣
 * @date 2018/6/24
 */
@Entity
data class Note(
        @Id var id:String?,
        var title:String?,
        var content:String?,
        var username:String?,
        var time:String?,
        var ip:String?
)