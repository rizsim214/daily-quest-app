package com.freedev.dailyquest.transactions;

import java.util.Date;

public class Transaction {
    private Integer questTransactionID, questID, questSeekerID, questProviderID;
    private String questStatus;
    private Date createdAt;

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
    public String getQuestStatus() {
        return questStatus;
    }
    public void setQuestStatus(String questStatus) {
        this.questStatus = questStatus;
    }
    public Date getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    @Override
    public String toString() {
        return "Transaction [createdAt=" + createdAt + ", questID=" + questID + ", questProviderID=" + questProviderID
                + ", questSeekerID=" + questSeekerID + ", questStatus=" + questStatus + ", questTransactionID="
                + questTransactionID + "]";
    }

        
}
