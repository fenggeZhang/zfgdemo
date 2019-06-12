package com.zfg.test.kotlintest

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.zfg.test.R

/**
 * Created by zfg on 2018/6/15
 */
class MianAdapter(layoutResId: Int, data: List<MainEntity>) : BaseQuickAdapter<MainEntity, BaseViewHolder>(layoutResId,data) {
    override fun convert(helper: BaseViewHolder?, item: MainEntity) {
        helper!!.setText(R.id.title_tv, item.title)
    }
}