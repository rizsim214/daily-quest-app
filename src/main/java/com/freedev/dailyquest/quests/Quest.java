package com.freedev.dailyquest.quests;

import java.sql.Date;

public class Quest {
    private Integer questId, questProviderId;
    private String questName, questDescription, questLocation, questStatus, questDifficulty, questProvider;
    private Double questBounty;
    private Date createdAt, updatedAt;
    private Date startDate, endDate;
    
    public Integer getQuestId() {
        return questId;
    }
    public void setQuestId(Integer questId) {
        this.questId = questId;
    }
    public Integer getQuestProviderId() {
        return questProviderId;
    }
    public void setQuestProviderId(Integer questProviderId) {
        this.questProviderId = questProviderId;
    }
    public String getQuestName() {
        return questName;
    }
    public void setQuestName(String questName) {
        this.questName = questName;
    }
    public String getQuestDescription() {
        return questDescription;
    }
    public void setQuestDescription(String questDescription) {
        this.questDescription = questDescription;
    }
    public String getQuestLocation() {
        return questLocation;
    }
    public void setQuestLocation(String questLocation) {
        this.questLocation = questLocation;
    }
    public String getQuestStatus() {
        return questStatus;
    }
    public void setQuestStatus(String questStatus) {
        this.questStatus = questStatus;
    }
    public String getQuestDifficulty() {
        return questDifficulty;
    }
    public void setQuestDifficulty(String questDifficulty) {
        this.questDifficulty = questDifficulty;
    }
    public String getQuestProvider() {
        return questProvider;
    }
    public void setQuestProvider(String questProvider) {
        this.questProvider = questProvider;
    }
    public Double getQuestBounty() {
        return questBounty;
    }
    public void setQuestBounty(Double questBounty) {
        this.questBounty = questBounty;
    }
    
    public Date getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
   
    public Date getStartDate() {
        return startDate;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    public Date getEndDate() {
        return endDate;
    }
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    public Date getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Quest [createdAt=" + createdAt + ", endDate=" + endDate + ", questBounty=" + questBounty
                + ", questDescription=" + questDescription + ", questDifficulty=" + questDifficulty + ", questId="
                + questId + ", questLocation=" + questLocation + ", questName=" + questName + ", questProvider="
                + questProvider + ", questProviderId=" + questProviderId + ", questStatus=" + questStatus
                + ", startDate=" + startDate + ", updatedAt=" + updatedAt + "]";
    }
        
}
