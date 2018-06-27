package com.itheima.lottery.lottery.bean

import javax.persistence.*

/**
 * @author 钟未鸣
 * @date 2018/6/27
 */
@Entity
data class Comment(
        @Id @GeneratedValue var id:Int?,
        var content: String?,
        var username: String?,
        var time: String?,
        var ipaddress: String?,
        //该字段关联到Note去
        @ManyToOne(targetEntity = Note::class,cascade = [CascadeType.REFRESH])
        var nid:Note
)