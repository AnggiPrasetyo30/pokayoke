package com.example.hyundai.SQLite;

import java.math.BigInteger;

public class Product {
    public String station_num;
    public String sku;
    public String part_name;
    public String position;
    public String pn_api;
    public String pn_cust;
    public BigInteger ptloc;
    public BigInteger sfgwh;
    public BigInteger fgwh;
    public BigInteger nkiwh;
    public String type;
    public String customer;
    public String cust_id;
    public String supplier_id;
    public String job_num;
    public String address;
    public Integer time_production;
    public Integer qty_packaging;
    public Integer qty_child;
    public String goods;
    public String line_prod;
    public BigInteger seq_qr;
    public BigInteger seq_data_part;

    public Product() {
    }

    public Product(String station_num, String sku, String part_name, String position,
                   String pn_api, String pn_cust, BigInteger ptloc, BigInteger sfgwh,
                   BigInteger fgwh, BigInteger nkiwh, String type, String customer, String cust_id,
                   String supplier_id, String job_num, String address, Integer time_production,
                   Integer qty_packaging, Integer qty_child, String goods, String line_prod, BigInteger seq_qr,
                   BigInteger seq_data_part) {
        this.station_num = station_num;
        this.sku = sku;
        this.part_name = part_name;
        this.position = position;
        this.pn_api = pn_api;
        this.pn_cust = pn_cust;
        this.ptloc = ptloc;
        this.sfgwh = sfgwh;
        this.fgwh = fgwh;
        this.nkiwh = nkiwh;
        this.type = type;
        this.customer = customer;
        this.cust_id = cust_id;
        this.supplier_id = supplier_id;
        this.job_num = job_num;
        this.address = address;
        this.time_production = time_production;
        this.qty_packaging = qty_packaging;
        this.qty_child = qty_child;
        this.goods = goods;
        this.line_prod = line_prod;
        this.seq_qr = seq_qr;
        this.seq_data_part = seq_data_part;
    }

    public String getStation_num() {
        return station_num;
    }

    public void setStation_num(String station_num) {
        this.station_num = station_num;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getPart_name() {
        return part_name;
    }

    public void setPart_name(String part_name) {
        this.part_name = part_name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPn_api() {
        return pn_api;
    }

    public void setPn_api(String pn_api) {
        this.pn_api = pn_api;
    }

    public String getPn_cust() {
        return pn_cust;
    }

    public void setPn_cust(String pn_cust) {
        this.pn_cust = pn_cust;
    }

    public BigInteger getPtloc() {
        return ptloc;
    }

    public void setPtloc(BigInteger ptloc) {
        this.ptloc = ptloc;
    }

    public BigInteger getSfgwh() {
        return sfgwh;
    }

    public void setSfgwh(BigInteger sfgwh) {
        this.sfgwh = sfgwh;
    }

    public BigInteger getFgwh() {
        return fgwh;
    }

    public void setFgwh(BigInteger fgwh) {
        this.fgwh = fgwh;
    }

    public BigInteger getNkiwh() {
        return nkiwh;
    }

    public void setNkiwh(BigInteger nkiwh) {
        this.nkiwh = nkiwh;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getCust_id() {
        return cust_id;
    }

    public void setCust_id(String cust_id) {
        this.cust_id = cust_id;
    }

    public String getSupplier_id() {
        return supplier_id;
    }

    public void setSupplier_id(String supplier_id) {
        this.supplier_id = supplier_id;
    }

    public String getJob_num() {
        return job_num;
    }

    public void setJob_num(String job_num) {
        this.job_num = job_num;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getTime_production() {
        return time_production;
    }

    public void setTime_production(Integer time_production) {
        this.time_production = time_production;
    }

    public Integer getQty_packaging() {
        return qty_packaging;
    }

    public void setQty_packaging(Integer qty_packaging) {
        this.qty_packaging = qty_packaging;
    }

    public Integer getQty_child() {
        return qty_child;
    }

    public void setQty_child(Integer qty_child) {
        this.qty_child = qty_child;
    }

    public String getGoods() {
        return goods;
    }

    public void setGoods(String goods) {
        this.goods = goods;
    }

    public String getLine_prod() {
        return line_prod;
    }

    public void setLine_prod(String line_prod) {
        this.line_prod = line_prod;
    }

    public BigInteger getSeq_qr() {
        return seq_qr;
    }

    public void setSeq_qr(BigInteger seq_qr) {
        this.seq_qr = seq_qr;
    }

    public BigInteger getSeq_data_part() {
        return seq_data_part;
    }

    public void setSeq_data_part(BigInteger seq_data_part) {
        this.seq_data_part = seq_data_part;
    }
}
