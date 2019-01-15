package com.zfg.test.entity;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import static com.zfg.test.adapter.CarListAdapter.TYPE_LEVEL_CONTENT;
import static com.zfg.test.adapter.CarListAdapter.TYPE_LEVEL_TITLE;

/**
 * Created by zfg on 2019/1/9
 */
public class CarItemBean implements MultiItemEntity {
    private int makeid;
    private String vehicletype;
    private int modelid;
    private int modelbrandid;
    private String model;
    private String makename;
    private int rowid;

    public void setMakeid(int makeid) {
        this.makeid = makeid;
    }

    public int getMakeid() {
        return makeid;
    }

    public void setVehicletype(String vehicletype) {
        this.vehicletype = vehicletype;
    }

    public String getVehicletype() {
        return vehicletype;
    }

    public void setModelid(int modelid) {
        this.modelid = modelid;
    }

    public int getModelid() {
        return modelid;
    }

    public void setModelbrandid(int modelbrandid) {
        this.modelbrandid = modelbrandid;
    }

    public int getModelbrandid() {
        return modelbrandid;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setMakename(String makename) {
        this.makename = makename;
    }

    public String getMakename() {
        return makename;
    }

    public void setRowid(int rowid) {
        this.rowid = rowid;
    }

    public int getRowid() {
        return rowid;
    }


    @Override
    public int getItemType() {
        return TYPE_LEVEL_CONTENT;
    }
}
