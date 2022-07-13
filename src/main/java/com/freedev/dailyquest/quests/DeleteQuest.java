package com.freedev.dailyquest.quests;

import com.opensymphony.xwork2.ActionSupport;

public class DeleteQuest extends ActionSupport{

    private Integer questID;
    private String successMessage;
    private String errorMessag;
    
    public String execute() throws Exception {
        
        if(QuestDAO.deleteQuestFromDB(questID)){
            setSuccessMessage("Successfully deleted record");
        }else{
            setErrorMessag("Something when wrong while attempting to delete quest...");
        }
        return SUCCESS;
    }

    public Integer getQuestID() {
        return questID;
    }

    public void setQuestID(Integer questID) {
        this.questID = questID;
    }

    public String getSuccessMessage() {
        return successMessage;
    }

    public void setSuccessMessage(String successMessage) {
        this.successMessage = successMessage;
    }

    public String getErrorMessag() {
        return errorMessag;
    }

    public void setErrorMessag(String errorMessag) {
        this.errorMessag = errorMessag;
    }


    
}
