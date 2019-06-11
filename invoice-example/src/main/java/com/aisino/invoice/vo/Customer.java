package com.aisino.invoice.vo;

import java.util.Date;

public class Customer {
    private long customerId;

    private Integer classId;

    private String customerTaxCode;

    private Integer taxBureauId;

    private String notes;

    private String customerName;

    private String legalPerson;

    private String registeredFund;

    private String tel1;

    private String tel2;

    private String tel3;

    private String mobile;

    private String accountBank;//开票银行

    private String bankAccount;//银行账号

    private String invoiceTel;//发票电话

    private String invoiceAddr;//发票地址

    private String invoiceName;//发票名称

    private Date createDate;

    private String vocationId;//行业类型

    private Integer isValid;//是否有效

    public Integer getIsValid() {
        return isValid;
    }

    public void setIsValid(Integer isValid) {
        this.isValid = isValid;
    }

    public String getVocationId() {
        return vocationId;
    }

    public void setVocationId(String vocationId) {
        this.vocationId = vocationId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getCustomerTaxCode() {
        return customerTaxCode;
    }

    public void setCustomerTaxCode(String customerTaxCode) {
        this.customerTaxCode = customerTaxCode;
    }

    public Integer getTaxBureauId() {
        return taxBureauId;
    }

    public void setTaxBureauId(Integer taxBureauId) {
        this.taxBureauId = taxBureauId;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getLegalPerson() {
        return legalPerson;
    }

    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson;
    }

    public String getRegisteredFund() {
        return registeredFund;
    }

    public void setRegisteredFund(String registeredFund) {
        this.registeredFund = registeredFund;
    }

    public String getTel1() {
        return tel1;
    }

    public void setTel1(String tel1) {
        this.tel1 = tel1;
    }

    public String getTel2() {
        return tel2;
    }

    public void setTel2(String tel2) {
        this.tel2 = tel2;
    }

    public String getTel3() {
        return tel3;
    }

    public void setTel3(String tel3) {
        this.tel3 = tel3;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAccountBank() {
        return accountBank;
    }

    public void setAccountBank(String accountBank) {
        this.accountBank = accountBank;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getInvoiceTel() {
        return invoiceTel;
    }

    public void setInvoiceTel(String invoiceTel) {
        this.invoiceTel = invoiceTel;
    }

    public String getInvoiceAddr() {
        return invoiceAddr;
    }

    public void setInvoiceAddr(String invoiceAddr) {
        this.invoiceAddr = invoiceAddr;
    }

    public String getInvoiceName() {
        return invoiceName;
    }

    public void setInvoiceName(String invoiceName) {
        this.invoiceName = invoiceName;
    }


    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", classId=" + classId +
                ", customerTaxCode='" + customerTaxCode + '\'' +
                ", taxBureauId=" + taxBureauId +
                ", notes='" + notes + '\'' +
                ", customerName='" + customerName + '\'' +
                ", legalPerson='" + legalPerson + '\'' +
                ", registeredFund='" + registeredFund + '\'' +
                ", tel1='" + tel1 + '\'' +
                ", tel2='" + tel2 + '\'' +
                ", tel3='" + tel3 + '\'' +
                ", mobile='" + mobile + '\'' +
                ", accountBank='" + accountBank + '\'' +
                ", bankAccount='" + bankAccount + '\'' +
                ", invoiceTel='" + invoiceTel + '\'' +
                ", invoiceAddr='" + invoiceAddr + '\'' +
                ", invoiceName='" + invoiceName + '\'' +
                '}';
    }
}
