package com.freedev.dailyquest.transactions;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.apache.struts2.action.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class GetAllTransactions extends ActionSupport implements SessionAware{
    Map<String, Object> userSession;
    List<Transaction> transactions;
    public String execute() throws Exception {
        List<Transaction> tempTransactions = TransactionDAO.getAllTransactions(userSession.get("sessionUserID"));
        Predicate<Transaction> isTransactionAccepted = transaction -> transaction.getTransaction_status().equals("accepted");
        Predicate<Transaction> isTransactionOngoing = transaction -> transaction.getTransaction_status().equals("ongoing");

        setTransactions(tempTransactions.stream()
            .filter(isTransactionAccepted.or(isTransactionOngoing))
            .collect(Collectors.toList()));

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
