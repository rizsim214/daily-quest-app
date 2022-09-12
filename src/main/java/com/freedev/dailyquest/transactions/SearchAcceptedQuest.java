package com.freedev.dailyquest.transactions;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class SearchAcceptedQuest extends ActionSupport implements SessionAware{
    Map<String, Object> userSession;
    private List<Transaction> transactions;
    private String displayMessage;
    private String searchTitle;

    public String execute() throws Exception {
        List<Transaction> tempTransaction = TransactionDAO.searchAcceptedTransactions(userSession.get("sessionUserID"),searchTitle);
        Predicate<Transaction> isQuestActive = transaction -> transaction.getQuestStatus().equals("accepted");
        Predicate<Transaction> isTransactionCancelled = transaction -> !transaction.getTransaction_status().equals("cancelled");
        Predicate<Transaction> isTransactionStatusAccepted = transaction -> transaction.getTransaction_status().equals("accepted");
        Predicate<Transaction> isTransactionDone = transaction -> !transaction.getTransaction_status().equals("done");
        Predicate<Transaction> isTransactionOngoing = transaction -> transaction.getTransaction_status().equals("ongoing");
        setTransactions(tempTransaction.stream()
            .filter(isQuestActive.and(isTransactionStatusAccepted).and(isTransactionDone).and(isTransactionCancelled).or(isTransactionOngoing))
            .collect(Collectors.toList()));
            
        if(transactions.isEmpty()){
            setDisplayMessage("No Accepted Quests...");
        }
        return SUCCESS;
    }

    public String getSearchTitle() {
        return searchTitle;
    }

    public void setSearchTitle(String searchTitle) {
        this.searchTitle = searchTitle;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
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
