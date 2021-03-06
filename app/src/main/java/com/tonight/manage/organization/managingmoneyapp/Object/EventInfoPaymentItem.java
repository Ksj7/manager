package com.tonight.manage.organization.managingmoneyapp.Object;

/**
 * Created by 3 on 2016-12-03.
 */

public class EventInfoPaymentItem {

    String targetMoney;
    String collectedMoney;
    String eventName;
    String eventDate;
    String personalMoney;
    String managerId;
    String balance;
    String bank;
    String account;

    String userName;
    String userprofileURL;
    String userIspay;

    String managerName;
    String managerProfileimg;

    public String getManagerName() {
        return managerName;
    }

    public EventInfoPaymentItem setManagerName(String managerName) {
        this.managerName = managerName;
        return this;
    }

    public String getManagerProfileimg() {
        return managerProfileimg;
    }

    public EventInfoPaymentItem setManagerProfileimg(String managerProfileimg) {
        this.managerProfileimg = managerProfileimg;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public EventInfoPaymentItem setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getUserprofileURL() {
        return userprofileURL;
    }

    public EventInfoPaymentItem setUserprofileURL(String userprofileURL) {
        this.userprofileURL = userprofileURL;
        return this;
    }

    public String getUserIspay() {
        return userIspay;
    }

    public EventInfoPaymentItem setUserIspay(String userIspay) {
        this.userIspay = userIspay;
        return this;
    }
    public EventInfoPaymentItem setTargetMoney(String targetMoney){
        this.targetMoney = targetMoney;
        return this;
    }
    public EventInfoPaymentItem setName(String eventName){
        this.eventName = eventName;
        return this;
    }
    public EventInfoPaymentItem setDate(String eventDate){
        this.eventDate = eventDate;
        return this;
    }
    public EventInfoPaymentItem setPersonalMoney(String personalMoney){
        this.personalMoney = personalMoney;
        return this;
    }
    public EventInfoPaymentItem setColectedMondey(String collectedMoney){
        this.collectedMoney = collectedMoney;
        return this;
    }
    public EventInfoPaymentItem setManagerId(String managerId){
        this.managerId = managerId;
        return this;
    }
    public EventInfoPaymentItem setBalance(String balance){
        this.balance = balance;
        return this;
    }
    public EventInfoPaymentItem setBank(String bank){
        this.bank = bank;
        return this;
    }
    public EventInfoPaymentItem setAccount(String account){
        this.account = account;
        return this;
    }

    public String getTargetMoney() {
        return targetMoney;
    }
    public String getCollectedMoney() {
        return collectedMoney;
    }
    public String getEventName() {
        return eventName;
    }
    public String getEventDate() {
        return eventDate;
    }
    public String getPersonalMoney() {
        return personalMoney;
    }
    public String getManagerId() {
        return managerId;
    }
    public String getBalance() {
        return balance;
    }
    public String getBank() {
        return bank;
    }
    public String getAccount() {
        return account;
    }
}
