package com.freedev.dailyquest.transactions;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class GetAllTransactions extends ActionSupport implements SessionAware{
    Map<String, Object> userSession;
    List<Transaction> transactions;
    public String execute() throws Exception {
        List<Transaction> tempTransactions = TransactionDAO.getAllProviderTransactions(userSession.get("sessionUserID"));
        Predicate<Transaction> isTransactionAccepted = transaction -> transaction.getTransaction_status().equals("accepted");
        Predicate<Transaction> isTransactionOngoing = transaction -> transaction.getTransaction_status().equals("ongoing");

        setTransactions(tempTransactions.stream()
            .filter(isTransactionAccepted.or(isTransactionOngoing))
            .collect(Collectors.toList()));

        return SUCCESS;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }


    @Override
    public void setSession(Map<String, Object> session) {
        this.userSession = session;
    }
    
}
