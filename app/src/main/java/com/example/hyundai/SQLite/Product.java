package com.example.hyundai.SQLite;


public class Product {
    public String station_num;
    public String sku;
    public String part_name;
    public String position;
    public String pn_api;
    public String pn_cust;
    public String ptloc;
    public String sfgwh;
    public String fgwh;
    public String nkiwh;
    public String type;
    public String customer;
    public String cust_id;
    public String supplier_id;
    public String job_num;
    public String address;
    public String time_production;
    public String qty_packaging;
    public String qty_child;
    public String goods;
    public String line_prod;
    public String seq_qr;
    public String seq_data_part;

    public Product(String station_num, String sku, String part_name, String position,
                   String pn_api, String pn_cust, String ptloc, String sfgwh,
                   String fgwh, String nkiwh, String type, String customer, String cust_id,
                   String supplier_id, String job_num, String address, String time_production,
                   String qty_packaging, String qty_child, String goods, String line_prod, String seq_qr,
                   String seq_data_part) {
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

    public String getPtloc() {
        return ptloc;
    }

    public void setPtloc(String ptloc) {
        this.ptloc = ptloc;
    }

    public String getSfgwh() {
        return sfgwh;
    }

    public void setSfgwh(String sfgwh) {
        this.sfgwh = sfgwh;
    }

    public String getFgwh() {
        return fgwh;
    }

    public void setFgwh(String fgwh) {
        this.fgwh = fgwh;
    }

    public String getNkiwh() {
        return nkiwh;
    }

    public void setNkiwh(String nkiwh) {
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

    public String getTime_production() {
        return time_production;
    }

    public void setTime_production(String time_production) {
        this.time_production = time_production;
    }

    public String getQty_packaging() {
        return qty_packaging;
    }

    public void setQty_packaging(String qty_packaging) {
        this.qty_packaging = qty_packaging;
    }

    public String getQty_child() {
        return qty_child;
    }

    public void setQty_child(String qty_child) {
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

    public String getSeq_qr() {
        return seq_qr;
    }

    public void setSeq_qr(String seq_qr) {
        this.seq_qr = seq_qr;
    }

    public String getSeq_data_part() {
        return seq_data_part;
    }

    public void setSeq_data_part(String seq_data_part) {
        this.seq_data_part = seq_data_part;
    }
}
