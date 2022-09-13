package com.freedev.dailyquest.quests;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class FilterByHard extends ActionSupport implements SessionAware{

    Map<String, Object> userSession;
    private List<Quest> quests;
    private String displayMessage;
    @Override
    public String execute() throws Exception {
        Predicate<Quest> isUserProvider = quest -> !quest.getQuestProviderId().equals(userSession.get("sessionUserID"));
        Predicate<Quest> isQuestActive = quest -> quest.getQuestStatus().equals("active");
       
        if(QuestDAO.filterByHard() == null){
            setDisplayMessage("No quest available yet...");
        }else{
            this.quests = QuestDAO.filterByHard().stream()
                .filter(isUserProvider.and(isQuestActive))
                .collect(Collectors.toList());
            
        }
        
        return SUCCESS;
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

    @Override
    public void setSession(Map<String, Object> session) {
        this.userSession = session;
    }
    
}
