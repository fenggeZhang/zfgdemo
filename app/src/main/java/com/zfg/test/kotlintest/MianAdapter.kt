package com.zfg.test.kotlintest

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.zfg.test.R

/**
 * Created by zfg on 2018/6/15
 */
class MianAdapter(layoutResId:Int,data:ArrayList<String>):BaseQuickAdapter<String, BaseViewHolder>(layoutResId, data){
    override fun convert(helper: BaseViewHolder?, item: String?) {
        helper!!.setText(R.id.title_tv,item)
    }
}