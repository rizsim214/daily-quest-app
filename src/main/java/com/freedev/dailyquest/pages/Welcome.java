package com.freedev.dailyquest.pages;

import com.opensymphony.xwork2.ActionSupport;

public class Welcome extends ActionSupport {
    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }

    public String register() {
        return "success";
    }
    public String login() {
        return "success";
    }
    public String questBoard() {
        return "success";
    }
    public String postedQuest() {
        return "success";
    }
    public String seekerList() {
        return "success";
    }
    public String viewAcceptedQuests() {
        return "success";
    }
    public String questTransactions() {
        return "success";
    }
    public String userProfile() {
        return "success";
    }
    public String questHistory() {
        return "success";
    }
}