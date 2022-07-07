package com.freedev.dailyquest.quests;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.struts2.action.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class GetPostedQuests extends ActionSupport implements SessionAware{
    Map<String, Object> userSession;
    List<Quest> posted_quests;
    private String displayError;
    @Override
    public String execute() throws Exception{
        List<Quest> quests = QuestDAO.getAllQuestFromDB();
        this.posted_quests = quests.stream().filter(quest -> quest.getQuestProviderId().equals(userSession.get("sessionUserID"))).collect(Collectors.toList());
       
        if(getPosted_quests() == null){
            setDisplayError("No quests to display...");
        }
        return SUCCESS;
    }   

    @Override
    public void withSession(Map<String, Object> session) {
        this.userSession = session;
    }

    public List<Quest> getPosted_quests() {
        return posted_quests;
    }

    public void setPosted_quests(List<Quest> posted_quests) {
        this.posted_quests = posted_quests;
    }

    public String getDisplayError() {
        return displayError;
    }

    public void setDisplayError(String displayError) {
        this.displayError = displayError;
    }
    
}
