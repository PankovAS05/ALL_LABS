package com.example.creditbank.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

public class Credit {
    private Long id;
    private String type;
    private BigDecimal sum;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfLoan;

    private Integer termMonths; // Срок в месяцах
    private Long clientId;
    private Long accountId;
    private Date endDate; // Дата окончания кредита
    private String clientFio; // ФИО клиента

    // Геттеры и сеттеры
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }

    public Date getDateOfLoan() {
        return dateOfLoan;
    }

    public void setDateOfLoan(Date dateOfLoan) {
        this.dateOfLoan = dateOfLoan;
    }

    public Integer getTermMonths() {
        return termMonths;
    }

    public void setTermMonths(Integer termMonths) {
        this.termMonths = termMonths;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getClientFio() {
        return clientFio;
    }

    public void setClientFio(String clientFio) {
        this.clientFio = clientFio;
    }
}
