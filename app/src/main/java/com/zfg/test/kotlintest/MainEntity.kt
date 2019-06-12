package com.zfg.test.kotlintest

/**
 *    author : zfg
 *    e-mail : zfg_android@163.com
 *    date   : 2019/6/12
 *    desc   :
 */
class MainEntity {
    lateinit var title: String
    lateinit var activity: Class<*>

    constructor(title: String, activity: Class<*>) {
        this.title = title
        this.activity = activity
    }
}
