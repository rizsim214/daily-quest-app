package com.freedev.dailyquest.users;

import java.util.Map;
import java.util.function.Predicate;

import org.apache.struts2.interceptor.SessionAware;

import com.freedev.dailyquest.quests.Quest;
import com.freedev.dailyquest.quests.QuestDAO;
import com.freedev.dailyquest.transactions.Transaction;
import com.freedev.dailyquest.transactions.TransactionDAO;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateUser extends ActionSupport implements SessionAware {

    private User userBean;
    private String passwordConfirmation;
    Map<String, Object> userSession;
    private String submitType;
    private String hiddenPassword;
    private Integer postedQuestCount = 0;
    private Integer finishedQuests = 0;
    
    public String execute() throws Exception {
        String result = ERROR;
       
        if(userBean.getUserPassword().equals("")) {
            UsersDAO.editUserWithHidden(userBean , hiddenPassword);
            result = SUCCESS;
        }else if(userBean.getUserPassword().equals(passwordConfirmation)) {
            UsersDAO.editUser(userBean);
            result = SUCCESS;
        }else{
            UsersDAO.editUser(userBean);
            result = SUCCESS;
        }
        
        return result;
    }

    public String fetchUser() throws Exception{
        setUserBean(UsersDAO.getOneUserFromDB(userSession.get("sessionUserID")));

        Predicate<Quest> isMyPostedQuest = quest -> quest.getQuestProviderId().equals(userSession.get("sessionUserID"));
        Predicate<Transaction> isMyFinishedQuest = transaction -> transaction.getQuestSeekerID().equals(userSession.get("sessionUserID"));
        
        Long countPostedQuests = QuestDAO.getAllQuestFromDB().stream().filter(isMyPostedQuest).count();
        Long countFinishedQuests = TransactionDAO.getAllSeekerTransactions().stream().filter(isMyFinishedQuest).count();
        
        setPostedQuestCount(countPostedQuests.intValue());
        setFinishedQuests(countFinishedQuests.intValue());
        
        return "success";
    }
    
    public User getUserBean() {
        return userBean;
    }

    public void setUserBean(User userBean) {
        this.userBean = userBean;
    }

    public String getSubmitType() {
        return submitType;
    }

    public void setSubmitType(String submitType) {
        this.submitType = submitType;
    }

    public String getPasswordConfirmation() {
        return passwordConfirmation;
    }

    public void setPasswordConfirmation(String passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
    }

    public String getHiddenPassword() {
        return hiddenPassword;
    }

    public void setHiddenPassword(String hiddenPassword) {
        this.hiddenPassword = hiddenPassword;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.userSession = session;
    }

    public Integer getPostedQuestCount() {
        return postedQuestCount;
    }

    public void setPostedQuestCount(Integer postedQuestCount) {
        this.postedQuestCount = postedQuestCount;
    }

    public Integer getFinishedQuests() {
        return finishedQuests;
    }

    public void setFinishedQuests(Integer finishedQuests) {
        this.finishedQuests = finishedQuests;
    }

}
