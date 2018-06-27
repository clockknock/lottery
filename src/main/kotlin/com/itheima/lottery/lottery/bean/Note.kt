package com.itheima.lottery.lottery.bean

import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.OneToMany

/**
 * @author 钟未鸣
 * @date 2018/6/24
 */
@Entity
data class Note(
        @Id var id: String?,
        var title: String?,
        var content: String?,
        var username: String?,
        var time: String?,
        var ipaddress: String?,
        @OneToMany(mappedBy = "nid",cascade = [CascadeType.MERGE])//mappedBy指定一对多,多的一方中的外建名
        var comments:List<Comment>
)