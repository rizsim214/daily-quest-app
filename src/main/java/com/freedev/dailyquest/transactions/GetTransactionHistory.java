package com.freedev.dailyquest.transactions;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.apache.struts2.action.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class GetTransactionHistory extends ActionSupport implements SessionAware{
    
    Map<String, Object> userSession;
    private List<Transaction> asSeekerHistory;
    private String providerTableMessage;
    private String seekerTableMessage;
    private List<Transaction> asProviderHistory;
    @Override
    public String execute() throws Exception {
        List<Transaction> tempUserHistory = TransactionDAO.getAllTransactions();
        List<Transaction> tempUserHistory2 = TransactionDAO.getAllSeekerTransactions();

        Predicate<Transaction> isMyProviderID = transaction -> transaction.getQuestProviderID().equals(userSession.get("sessionUserID"));
        Predicate<Transaction> isMySeekerID = transaction -> transaction.getQuestSeekerID().equals(userSession.get("sessionUserID"));
        if(tempUserHistory != null) {
            setAsProviderHistory(tempUserHistory.stream()
                                .filter(isMyProviderID)
                                .collect(Collectors.toList())); 
        }else{
            setProviderTableMessage("No data present...");
        }
        
        if (tempUserHistory2 != null) {
            setAsSeekerHistory(tempUserHistory2.stream()
                                .filter(isMySeekerID)
                                .collect(Collectors.toList()));
        }else {
            setSeekerTableMessage("No data present...");
        }
        return SUCCESS;
    }

    @Override
    public void withSession(Map<String, Object> session) {
        this.userSession = session;
    }


    public List<Transaction> getAsSeekerHistory() {
        return asSeekerHistory;
    }
    public void setAsSeekerHistory(List<Transaction> asSeekerHistory) {
        this.asSeekerHistory = asSeekerHistory;
    }
    public List<Transaction> getAsProviderHistory() {
        return asProviderHistory;
    }
    public void setAsProviderHistory(List<Transaction> asProviderHistory) {
        this.asProviderHistory = asProviderHistory;
    }
    public String getProviderTableMessage() {
        return providerTableMessage;
    }
    public void setProviderTableMessage(String providerTableMessage) {
        this.providerTableMessage = providerTableMessage;
    }
    public String getSeekerTableMessage() {
        return seekerTableMessage;
    }
    public void setSeekerTableMessage(String seekerTableMessage) {
        this.seekerTableMessage = seekerTableMessage;
    }
    
    
}
