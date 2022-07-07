package com.freedev.dailyquest.quests;

import java.util.Date;

public class Quest {
    private Integer questId, questProviderId;
    private String questName, questDescription, questDate, questLocation, questTimespan, questStatus, questDifficulty;
    private Double questBounty;
    private Date createAt = new Date(), upadtedAt;
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
    public String getQuestDate() {
        return questDate;
    }
    public void setQuestDate(String questDate) {
        this.questDate = questDate;
    }
    public String getQuestLocation() {
        return questLocation;
    }
    public void setQuestLocation(String questLocation) {
        this.questLocation = questLocation;
    }
    public String getQuestTimespan() {
        return questTimespan;
    }
    public void setQuestTimespan(String questTimespan) {
        this.questTimespan = questTimespan;
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
    public Double getQuestBounty() {
        return questBounty;
    }
    public void setQuestBounty(Double questBounty) {
        this.questBounty = questBounty;
    }
    public Date getCreateAt() {
        return createAt;
    }
    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
    public Date getUpadtedAt() {
        return upadtedAt;
    }
    public void setUpadtedAt(Date upadtedAt) {
        this.upadtedAt = upadtedAt;
    }
    @Override
    public String toString() {
        return "Quest [createAt=" + createAt + ", questBounty=" + questBounty + ", questDate=" + questDate
                + ", questDescription=" + questDescription + ", questDifficulty=" + questDifficulty + ", questId="
                + questId + ", questLocation=" + questLocation + ", questName=" + questName + ", questProviderId="
                + questProviderId + ", questStatus=" + questStatus + ", questTimespan=" + questTimespan + ", upadtedAt="
                + upadtedAt + "]";
    }
  

    
}
