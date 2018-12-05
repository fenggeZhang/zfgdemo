package com.zfg.test.activity.data;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by zfg on 2018/11/16
 */
@Entity
public class NameData {
    //不能用int （ID 表示标识主键 且主键不能用int autoincrement = true 表示主键会自增）
    @Id(autoincrement = true)
    private Long id;
    private String searchterm;

    @Generated(hash = 2063249013)
    public NameData(Long id, String searchterm) {
        this.id = id;
        this.searchterm = searchterm;
    }

    @Generated(hash = 1262847566)
    public NameData() {
    }

    public String getSearchterm() {
        return searchterm;
    }

    public void setSearchterm(String searchterm) {
        this.searchterm = searchterm;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
