package com.freedev.dailyquest.quests;

import java.util.List;
import java.util.Map;

import org.apache.struts2.action.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class GetAllQuests extends ActionSupport implements SessionAware{
    Map<String, Object> userSession;
    private List<Quest> quests;
    private String displayMessage;
    @Override
    public String execute() throws Exception {
        if(QuestDAO.getAllQuestFromDB() == null){
            setDisplayMessage("No quest available yet...");
        }else{
            setQuests(QuestDAO.getAllQuestFromDB());
        }
        
        return SUCCESS;
    }

    @Override
    public void withSession(Map<String, Object> session) {
        this.userSession = session;
    }

    public List<Quest> getQuests() {
        return quests;
    }

    public void setQuests(List<Quest> quests) {
        this.quests = quests;
    }

    public String getDisplayMessage() {
        return displayMessage;
    }

    public void setDisplayMessage(String displayMessage) {
        this.displayMessage = displayMessage;
    }
    
}
