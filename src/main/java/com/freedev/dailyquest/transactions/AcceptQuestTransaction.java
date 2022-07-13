package com.freedev.dailyquest.transactions;

import com.opensymphony.xwork2.ActionSupport;

public class AcceptQuestTransaction extends ActionSupport{
    private Transaction transaction;
    private String successMessage;
    private String errorMessag;

    public String execute() throws Exception {
        String result;        
        if(TransactionDAO.saveTransactionToDB(transaction)) {
            setSuccessMessage("Quest Accepted! Please wait for SMS confirmation when you are chosen...");
            result = SUCCESS;
        } else {
            setErrorMessag("Something went wrong while processing your accept request... please try again");
            result = INPUT;
        } 
        return result;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public String getErrorMessag() {
        return errorMessag;
    }

    public void setErrorMessag(String errorMessag) {
        this.errorMessag = errorMessag;
    }

    public String getSuccessMessage() {
        return successMessage;
    }

    public void setSuccessMessage(String successMessage) {
        this.successMessage = successMessage;
    }

    
    
}
