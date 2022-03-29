package com.example.roomDatabase.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

/**
 * The type Proofpayment.
 */
@Entity(tableName = "proof_of_payment")
public class Proofpayment {
    /**
     * The Id.
     */
    @PrimaryKey(autoGenerate = true)
    Integer id;
    //res  = envio
    /**
     * The Res account.
     */
    @ColumnInfo(name = "res_account")
    //req = recive
    String resAccount;
    /**
     * The Req account.
     */
    @ColumnInfo(name = "req_account")
    String reqAccount;
    /**
     * The Id card.
     */
    @ColumnInfo(name = "id_card")
    Integer idCard;
    /**
     * The Amount.
     */
    @ColumnInfo(name = "amount")
    Double amount;
    /**
     * The Detail.
     */
    @ColumnInfo(name = "detail")
    String detail;
    /**
     * The Transaction type id.
     */
    @ColumnInfo(name = "transaction_type_id")
    Integer transactionTypeId;
    /**
     * The Commission.
     */
    @ColumnInfo(name = "commission")
    Double commission;
    /**
     * The Bank id.
     */
    @ColumnInfo(name = "bank_id")
    Integer bankId;

    /**
     * Instantiates a new Proofpayment.
     *
     * @param id                the id
     * @param resAccount        the res account
     * @param reqAccount        the req account
     * @param idCard            the id card
     * @param amount            the amount
     * @param detail            the detail
     * @param transactionTypeId the transaction type id
     * @param commission        the commission
     * @param bankId            the bank id
     */
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

    /**
     * Instantiates a new Proofpayment.
     *
     * @param resAccount        the res account
     * @param reqAccount        the req account
     * @param idCard            the id card
     * @param amount            the amount
     * @param detail            the detail
     * @param transactionTypeId the transaction type id
     * @param commission        the commission
     * @param bankId            the bank id
     */
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

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Gets res account.
     *
     * @return the res account
     */
    public String getResAccount() {
        return resAccount;
    }

    /**
     * Gets req account.
     *
     * @return the req account
     */
    public String getReqAccount() {
        return reqAccount;
    }

    /**
     * Gets id card.
     *
     * @return the id card
     */
    public Integer getIdCard() {
        return idCard;
    }

    /**
     * Gets amount.
     *
     * @return the amount
     */
    public Double getAmount() {
        return amount;
    }

    /**
     * Gets detail.
     *
     * @return the detail
     */
    public String getDetail() {
        return detail;
    }

    /**
     * Gets transaction type id.
     *
     * @return the transaction type id
     */
    public Integer getTransactionTypeId() {
        return transactionTypeId;
    }

    /**
     * Gets commission.
     *
     * @return the commission
     */
    public Double getCommission() {
        return commission;
    }

    /**
     * Gets bank id.
     *
     * @return the bank id
     */
    public Integer getBankId() {
        return bankId;
    }

    /**
     * To string java . lang . string.
     *
     * @return the java . lang . string
     */
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