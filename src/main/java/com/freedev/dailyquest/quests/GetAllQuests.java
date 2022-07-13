package com.freedev.dailyquest.quests;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.apache.struts2.action.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class GetAllQuests extends ActionSupport implements SessionAware{
    Map<String, Object> userSession;
    private List<Quest> quests;
    private String displayMessage;
    @Override
    public String execute() throws Exception {
        Predicate<Quest> isUserProvider = quest -> !quest.getQuestProviderId().equals(userSession.get("sessionUserID"));
        Predicate<Quest> isQuestActive = quest -> quest.getQuestStatus().equals("active");
       
        if(QuestDAO.getAllQuestFromDB() == null){
            setDisplayMessage("No quest available yet...");
        }else{
            this.quests = QuestDAO.getAllQuestFromDB().stream()
                .filter(isUserProvider.and(isQuestActive))
                .collect(Collectors.toList());
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
