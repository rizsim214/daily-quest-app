package com.freedev.dailyquest.transactions;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.apache.struts2.action.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class GetAcceptedQuests extends ActionSupport implements SessionAware{
    private Map<String, Object> userSession;
    private List<Transaction> transactions;

    public String execute() throws Exception {
        List<Transaction> tempTransaction = TransactionDAO.getAcceptedTransactions(userSession.get("sessionUserID"));
        Predicate<Transaction> isQuestActive = transaction -> transaction.getQuestStatus().equals("accepted");
        Predicate<Transaction> isTransactionCancelled = transaction -> !transaction.getTransaction_status().equals("cancelled");
        Predicate<Transaction> isTransactionStatusAccepted = transaction -> transaction.getTransaction_status().equals("accepted");
        
        setTransactions(tempTransaction.stream()
            .filter(isQuestActive.and(isTransactionStatusAccepted).or(isTransactionCancelled))
            .collect(Collectors.toList()));
            System.out.println(tempTransaction);
        return SUCCESS;
    }

    @Override
    public void withSession(Map<String, Object> session) {
        this.userSession = session;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
    
}
