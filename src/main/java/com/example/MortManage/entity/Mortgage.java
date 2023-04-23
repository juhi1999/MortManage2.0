package com.example.MortManage.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @Column(name="active")
    private boolean active;

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public float getRateOfInterest() {
        return rateOfInterest;
    }

    public void setRateOfInterest(float rateOfInterest) {
        this.rateOfInterest = rateOfInterest;
    }

    @Column(name="rateOfInterest")
    private float rateOfInterest;

    @JsonIgnore
    public Customer getCustomer() {
        return customer;
    }

    @JsonIgnore
    public void setCustomer(Customer customer) {
        this.customer = customer;
   }

    @JsonBackReference
    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.DETACH,CascadeType.REFRESH})
    @JoinColumn(name="customer_id")
    private Customer customer;



    public Mortgage() {
    }

    public Mortgage(String productname, int marketvalue, int given, int left, Date issue_date, float rateOfInterest,boolean active) {
        this.productname = productname;
        this.marketvalue = marketvalue;
        this.given = given;
        this.left = left;
        this.issue_date = issue_date;
        this.rateOfInterest = rateOfInterest;
        this.active=active;
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
                ", active=" + active +
                ", rateOfInterest=" + rateOfInterest +
                '}';
    }
}