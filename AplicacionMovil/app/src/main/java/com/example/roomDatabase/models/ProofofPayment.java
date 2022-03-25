package com.example.roomDatabase.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "proof_of_payment")

public class Proofpayment {
    @PrimaryKey(autoGenerate = true)
    Integer id;
    @ColumnInfo(name = "res_account")
    String resAccount;
    @ColumnInfo(name = "req_account")
    String reqAccount;
    @ColumnInfo(name = "id_card")
    Integer idCard;
    @ColumnInfo(name = "amount")
    Double amount;
    @ColumnInfo(name = "detail")
    String detail;
    @ColumnInfo(name = "transaction_type_id")
    Integer transactionTypeId;
    @ColumnInfo(name = "commission")
    Double commission;
    @ColumnInfo(name = "bank_id")
    Integer bankId;

    @Ignore
    public Proofpayment(Integer id, String resAccount, String reqAccount, Integer idCard, Double amount, String detail, Integer transactionTypeId, Double commission, Integer bankId) {
        this.id = id;
        this.resAccount = resAccount;
        this.reqAccount = reqAccount;
        this.idCard = idCard;
        this.amount = amount;
        this.detail = detail;
        this.transactionTypeId = transactionTypeId;
        this.commission = commission;
        this.bankId = bankId;
    }

    public Proofpayment(String resAccount, String reqAccount, Integer idCard, Double amount, String detail, Integer transactionTypeId, Double commission, Integer bankId) {
        this.resAccount = resAccount;
        this.reqAccount = reqAccount;
        this.idCard = idCard;
        this.amount = amount;
        this.detail = detail;
        this.transactionTypeId = transactionTypeId;
        this.commission = commission;
        this.bankId = bankId;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getResAccount() {
        return resAccount;
    }

    public String getReqAccount() {
        return reqAccount;
    }

    public Integer getIdCard() {
        return idCard;
    }

    public Double getAmount() {
        return amount;
    }

    public String getDetail() {
        return detail;
    }

    public Integer getTransactionTypeId() {
        return transactionTypeId;
    }

    public Double getCommission() {
        return commission;
    }

    public Integer getBankId() {
        return bankId;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Proofpayment{" +
            "id=" + id +
            ", resAccount='" + resAccount + '\'' +
            ", reqAccount='" + reqAccount + '\'' +
            ", idCard=" + idCard +
            ", amount=" + amount +
            ", detail='" + detail + '\'' +
            ", transactionTypeId=" + transactionTypeId +
            ", commission=" + commission +
            ", bankId=" + bankId +
            '}';
    }
}
