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
   
}