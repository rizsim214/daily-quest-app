package com.freedev.dailyquest.quests;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;

public class SearchPostedQuest extends ActionSupport implements SessionAware {
    Map<String, Object> userSession;
    List<Quest> postedQuests;
    private String displayError;
    private String searchTitle;

    @Override
    public String execute() throws Exception {

        Predicate<Quest> isMyPostedQuest = quest -> quest.getQuestProviderId().equals(userSession.get("sessionUserID"));
        Predicate<Quest> isActivePostedQuest = quest -> !quest.getQuestStatus().equals("deleted");
        Predicate<Quest> isNotQuestDone = quest -> !quest.getQuestStatus().equals("done");
        setPostedQuests( QuestDAO.searchPostedQuestFromDB(searchTitle).stream()
            .filter(isMyPostedQuest.and(isActivePostedQuest).and(isNotQuestDone))
            .collect(Collectors.toList()));  
    
        return SUCCESS;
    }

    public String getSearchTitle() {
        return searchTitle;
    }

    public void setSearchTitle(String searchTitle) {
        this.searchTitle = searchTitle;
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

    @Override
    public void setSession(Map<String, Object> session) {
        this.userSession = session;
    }
  

}
