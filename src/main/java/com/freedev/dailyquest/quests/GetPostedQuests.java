package com.freedev.dailyquest.quests;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.apache.struts2.action.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class GetPostedQuests extends ActionSupport implements SessionAware{
    Map<String, Object> userSession;
    List<Quest> postedQuests;
    private String displayError;
    
    @Override
    public String execute() throws Exception{
         
        Predicate<Quest> isMyPostedQuest = quest -> quest.getQuestProviderId().equals(userSession.get("sessionUserID"));
        Predicate<Quest> isActivePostedQuest = quest -> !quest.getQuestStatus().equals("deleted");
        Predicate<Quest> isNotQuestDone = quest -> !quest.getQuestStatus().equals("done");
        setPostedQuests( QuestDAO.getAllQuestFromDB().stream()
            .filter(isMyPostedQuest.and(isActivePostedQuest).and(isNotQuestDone))
            .collect(Collectors.toList()));  
    
        return SUCCESS;
    }   

    @Override
    public void withSession(Map<String, Object> session) {
        this.userSession = session;
    }

  

    public List<Quest> getPostedQuests() {
        return postedQuests;
    }

    public void setPostedQuests(List<Quest> postedQuests) {
        this.postedQuests = postedQuests;
    }

    public String getDisplayError() {
        return displayError;
    }

    public void setDisplayError(String displayError) {
        this.displayError = displayError;
    }

    public void setUserSession(Map<String, Object> userSession) {
        this.userSession = userSession;
    }

  
}
