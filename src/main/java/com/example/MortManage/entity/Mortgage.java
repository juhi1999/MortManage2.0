package com.example.MortManage.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="mortgage")
public class Mortgage {
    //define fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="productname")
    private String productname;

    @Column(name="marketValue")
    private int marketvalue;

    @Column(name="given")
    private int given;

    @Column(name="left")
    private int left;

    @Column(name="issue_date")
    private Date issue_date;

    public Mortgage() {
    }

    public Mortgage(String productname, int marketvalue, int given, int left, Date issue_date) {
        this.productname = productname;
        this.marketvalue = marketvalue;
        this.given = given;
        this.left = left;
        this.issue_date = issue_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public int getMarketvalue() {
        return marketvalue;
    }

    public void setMarketvalue(int marketvalue) {
        this.marketvalue = marketvalue;
    }

    public int getGiven() {
        return given;
    }

    public void setGiven(int given) {
        this.given = given;
    }

    public long getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public Date getIssue_date() {
        return issue_date;
    }

    public void setIssue_date(Date issue_date) {
        this.issue_date = issue_date;
    }

    @Override
    public String toString() {
        return "Mortgage{" +
                "id=" + id +
                ", productname='" + productname + '\'' +
                ", marketvalue=" + marketvalue +
                ", given=" + given +
                ", left=" + left +
                ", issue_date=" + issue_date +
                '}';
    }
}
