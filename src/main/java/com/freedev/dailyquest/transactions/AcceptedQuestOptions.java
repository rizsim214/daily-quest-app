package com.freedev.dailyquest.transactions;

import com.opensymphony.xwork2.ActionSupport;

public class AcceptedQuestOptions extends ActionSupport{
    private Transaction transaction;
    private String message;
    private String successMessage;
    public String execute() throws Exception{
        String result = ERROR;
        if(TransactionDAO.cancelQuestTransactionStatus(transaction) == true) {
            setMessage("Chosen quest has been cancelled...");
            result = SUCCESS;
        }else {
            setMessage("Something went wrong while cancelling your quest...");
        }   
        return result;
    }

    public String startQuest() throws Exception {
        
        String result="error";
        if(TransactionDAO.updateQuestTransactionStatusToOnGoing(transaction.getQuestTransactionID()) == true) {
            setSuccessMessage("Quest has been Initiated.. ");
        }else{
            setMessage("Something went wrong while initiating quest");
        }
        return result;
    }
    public Transaction getTransaction() {
        return transaction;
    }
    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public String getSuccessMessage() {
        return successMessage;
    }

    public void setSuccessMessage(String successMessage) {
        this.successMessage = successMessage;
    }
    
}
