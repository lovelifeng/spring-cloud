package com.lppz.cloud.api.entities;

/**
 * 渠道表对象
 */
public class DataChannel {
    private int id;
    private String cPlatform;
    private String cPlatcode;
    private String cPlatformname;
    private String cChannelid;
    private String cChannelname;
    private String cScaleStock;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getcPlatform() {
        return cPlatform;
    }

    public void setcPlatform(String cPlatform) {
        this.cPlatform = cPlatform;
    }

    public String getcPlatcode() {
        return cPlatcode;
    }

    public void setcPlatcode(String cPlatcode) {
        this.cPlatcode = cPlatcode;
    }

    public String getcPlatformname() {
        return cPlatformname;
    }

    public void setcPlatformname(String cPlatformname) {
        this.cPlatformname = cPlatformname;
    }

    public String getcChannelid() {
        return cChannelid;
    }

    public void setcChannelid(String cChannelid) {
        this.cChannelid = cChannelid;
    }

    public String getcChannelname() {
        return cChannelname;
    }

    public void setcChannelname(String cChannelname) {
        this.cChannelname = cChannelname;
    }

    public String getcScaleStock() {
        return cScaleStock;
    }

    public void setcScaleStock(String cScaleStock) {
        this.cScaleStock = cScaleStock;
    }
}
