package com.freedev.dailyquest.quests;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class AddQuest extends ActionSupport implements SessionAware{
    private Quest questBean;
    private String errorMessage;
    Map<String, Object> userSession;

    @Override
    public String execute() throws Exception{
        if(QuestDAO.saveQuestToDB(questBean, userSession.get("sessionUserID"))) {
            return SUCCESS;
        }else{
            return INPUT;
        }
    }

    public Quest getQuestBean() {
        return questBean;
    }
    public void setQuestBean(Quest questBean) {
        this.questBean = questBean;
    }
    public String getErrorMessage() {
        return errorMessage;
    }
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.userSession = session;
    }
}
