package com.tonight.manage.organization.managingmoneyapp.Object;

/**
 * Created by 3 on 2016-11-18.
 */

public class EventInfoMemberPaymentListItem {

    String imgurl;
    String name;
    String userid;
    String spendingstatus;



    public EventInfoMemberPaymentListItem setImgurl(String imgurl) {
        this.imgurl = imgurl;
        return this;
    }
    public EventInfoMemberPaymentListItem setName(String name) {
        this.name = name;
        return this;
    }

    public EventInfoMemberPaymentListItem setSpendingstatus(String spendingstatus) {
        this.spendingstatus = spendingstatus;
        return this;
    }
    public EventInfoMemberPaymentListItem setUserId(String userid) {
        this.userid = userid;
        return this;
    }

    public String getImgurl() {
        return imgurl;
    }

    public String getName() {
        return name;
    }

    public String getSpendingstatus() {
        return spendingstatus;
    }

    public String getUserId() {
        return userid;
    }

}
