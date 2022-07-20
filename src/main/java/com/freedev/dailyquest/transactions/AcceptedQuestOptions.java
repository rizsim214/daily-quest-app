package com.freedev.dailyquest.transactions;

import com.opensymphony.xwork2.ActionSupport;

public class AcceptedQuestOptions extends ActionSupport{
    private Transaction transaction;
    private String message;
    private String successMessage;

    // CANCEL QUEST METHOD
    public String execute() throws Exception{
        
        String result = ERROR;
        String transactionStatus = "cancelled";
        String questStatus = "active";

        if(TransactionDAO.QuestTransactionStatus(transaction, transactionStatus, questStatus) == true) {
            setMessage("Chosen quest has been cancelled...");
            result = SUCCESS;
        }else {
            setMessage("Something went wrong while cancelling your quest...");
        }   
        return result;
    }
    // SET TRANSACTION TO ONGOING METHOD
    public String startQuest() throws Exception {
        
        String result="error";
        String status = "ongoing";
        if(TransactionDAO.updateQuestTransactionStatus(transaction,status) == true) {
            setSuccessMessage("Quest has been Initiated.. ");
        }else{
            setMessage("Something went wrong while initiating quest");
        }
        return result;
    }
    // SET TRANSACTION TO DONE
    public String endQuest() throws Exception {
        
        String result="error";
        String status = "done";
        String questStatus="done";
        if(TransactionDAO.QuestTransactionStatus(transaction, status, questStatus) == true) {
            setSuccessMessage("Quest has Ended...");
            result = "success";
        }else{
            setMessage("Something went wrong while ending quest");
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
