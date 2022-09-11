package com.freedev.dailyquest.quests;

import java.sql.Date;

public class Quest {
    private Integer questId, questProviderId;
    private String questName, questDescription, questLocation, questStatus, questDifficulty, questProvider, questTimespan, userStatus;
    private Double questBounty;
    private Date createdAt, updatedAt, startDate;
    
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
    public String getQuestTimespan() {
        return questTimespan;
    }
    public void setQuestTimespan(String questTimespan) {
        this.questTimespan = questTimespan;
    }
    public Double getQuestBounty() {
        return questBounty;
    }
    public void setQuestBounty(Double questBounty) {
        this.questBounty = questBounty;
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
    public Date getStartDate() {
        return startDate;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    public String getUserStatus() {
        return userStatus;
    }
    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }
    
}
