package com.example.hyundai.SQLite;

public class shopping {

    public String npk;
    public String customer;
    public String kanban_api;
    public String kanban_cust;
    public String hasil;
    public String datetime;
    public String data_api;
    public String data_cust;
    public String TRIAL857;

    public shopping(String npk, String customer, String kanban_api,
                    String kanban_cust, String hasil, String datetime,
                    String data_api, String data_cust, String TRIAL857) {
        this.npk = npk;
        this.customer = customer;
        this.kanban_api = kanban_api;
        this.kanban_cust = kanban_cust;
        this.hasil = hasil;
        this.datetime = datetime;
        this.data_api = data_api;
        this.data_cust = data_cust;
        this.TRIAL857 = TRIAL857;
    }

    //Getter

    public String getNpk() {
        return npk;
    }

    public String getCustomer() {
        return customer;
    }

    public String getKanban_api() {
        return kanban_api;
    }

    public String getKanban_cust() {
        return kanban_cust;
    }

    public String getHasil() {
        return hasil;
    }

    public String getDatetime() {
        return datetime;
    }

    public String getData_api() {
        return data_api;
    }

    public String getData_cust() {
        return data_cust;
    }

    public String getTRIAL857() {
        return TRIAL857;
    }

    //Setter

    public void setNpk(String npk) {
        this.npk = npk;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public void setKanban_api(String kanban_api) {
        this.kanban_api = kanban_api;
    }

    public void setKanban_cust(String kanban_cust) {
        this.kanban_cust = kanban_cust;
    }

    public void setHasil(String hasil) {
        this.hasil = hasil;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public void setData_api(String data_api) {
        this.data_api = data_api;
    }

    public void setData_cust(String data_cust) {
        this.data_cust = data_cust;
    }

    public void setTRIAL857(String TRIAL857) {
        this.TRIAL857 = TRIAL857;
    }


}
