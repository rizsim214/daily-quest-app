package com.freedev.dailyquest.transactions;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.freedev.dailyquest.users.User;
import com.freedev.dailyquest.users.UsersDAO;
import com.opensymphony.xwork2.ActionSupport;

public class AcceptQuestTransaction extends ActionSupport implements SessionAware{
    private Transaction transaction;
    private String successMessage;
    private String errorMessage;
    Map<String, Object> userSession;

    public String execute() throws Exception {
        String result = INPUT;
        if(TransactionDAO.saveTransactionToDB(transaction)) {
            setSuccessMessage("Quest Accepted! Proceed to My Daily Quest to see your accepted quests...");
            result = SUCCESS;
            User user = UsersDAO.getOneUserFromDB(userSession.get("sessionUserID"));
            userSession.putIfAbsent("sessionUserStatus", user.getUserStatus());
        } else {
            setErrorMessage("Something went wrong while processing your accept request... please try again");
        } 
        return result;
    }

    public Transaction getTransaction() {
        return transaction;
    }
    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }
    public String getSuccessMessage() {
        return successMessage;
    }

    public void setSuccessMessage(String successMessage) {
        this.successMessage = successMessage;
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
