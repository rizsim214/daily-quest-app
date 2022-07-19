package com.freedev.dailyquest.users;

import com.opensymphony.xwork2.ActionSupport;

public class FetchUser extends ActionSupport {

    private User userBean;

    public String execute() throws Exception {
        
        return SUCCESS;
    }

    public User getUserBean() {
        return userBean;
    }

    public void setUserBean(User userBean) {
        this.userBean = userBean;
    }

}
