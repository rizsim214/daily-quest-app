package com.freedev.dailyquest.transactions;

import java.util.Date;


public class Transaction {
    private Integer questTransactionID, questID, questSeekerID, questProviderID;
    private Date createdAt,updatedAt, questDate;
    private String questName, questProvider, questSeeker, contactInfo, timespan, location, description, transaction_status, questStatus;
    private Double questBounty;
    
    public Integer getQuestTransactionID() {
        return questTransactionID;
    }
    public void setQuestTransactionID(Integer questTransactionID) {
        this.questTransactionID = questTransactionID;
    }
    public Integer getQuestID() {
        return questID;
    }
    public void setQuestID(Integer questID) {
        this.questID = questID;
    }
    public Integer getQuestSeekerID() {
        return questSeekerID;
    }
    public void setQuestSeekerID(Integer questSeekerID) {
        this.questSeekerID = questSeekerID;
    }
    public Integer getQuestProviderID() {
        return questProviderID;
    }
    public void setQuestProviderID(Integer questProviderID) {
        this.questProviderID = questProviderID;
    }
    public Date getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    public Date getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
    public Date getQuestDate() {
        return questDate;
    }
    public void setQuestDate(Date questDate) {
        this.questDate = questDate;
    }
    public String getQuestName() {
        return questName;
    }
    public void setQuestName(String questName) {
        this.questName = questName;
    }
    public String getQuestProvider() {
        return questProvider;
    }
    public void setQuestProvider(String questProvider) {
        this.questProvider = questProvider;
    }
    public String getQuestSeeker() {
        return questSeeker;
    }
    public void setQuestSeeker(String questSeeker) {
        this.questSeeker = questSeeker;
    }
    public String getContactInfo() {
        return contactInfo;
    }
    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }
    public String getTimespan() {
        return timespan;
    }
    public void setTimespan(String timespan) {
        this.timespan = timespan;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getTransaction_status() {
        return transaction_status;
    }
    public void setTransaction_status(String transaction_status) {
        this.transaction_status = transaction_status;
    }
    public String getQuestStatus() {
        return questStatus;
    }
    public void setQuestStatus(String questStatus) {
        this.questStatus = questStatus;
    }
    public Double getQuestBounty() {
        return questBounty;
    }
    public void setQuestBounty(Double questBounty) {
        this.questBounty = questBounty;
    }
    @Override
    public String toString() {
        return "Transaction [contactInfo=" + contactInfo + ", createdAt=" + createdAt + ", description=" + description
                + ", location=" + location + ", questBounty=" + questBounty + ", questDate=" + questDate + ", questID="
                + questID + ", questName=" + questName + ", questProvider=" + questProvider + ", questProviderID="
                + questProviderID + ", questSeeker=" + questSeeker + ", questSeekerID=" + questSeekerID
                + ", questStatus=" + questStatus + ", questTransactionID=" + questTransactionID + ", timespan="
                + timespan + ", transaction_status=" + transaction_status + ", updatedAt=" + updatedAt + "]";
    } 
    
    
}
