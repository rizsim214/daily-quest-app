package com.freedev.dailyquest.users;

import java.util.Map;

import org.apache.struts2.action.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class Login extends ActionSupport implements SessionAware{
    private User userBean;
    private String errorMessag;
    Map<String, Object> userSession;
    
    @Override
    public String execute() throws Exception {
        String result;
        UsersDAO ud = new UsersDAO();
        User sessionBean = ud.fetchOneToDB(userBean.getUserEmail(), userBean.getUserPassword());
        
        if(sessionBean.getUserEmail() == null && sessionBean.getUserPassword() == null) {
             // IF NOT PRESENT SET ERROR MESSAGE & return INPUT
             setErrorMessag("Incorrect Email or Password*");
             result = INPUT;
        }else{
            userSession.put("sessionUser", sessionBean);
            result = SUCCESS;
        }
        return result;
    }
    public User getUserBean() {
        return userBean;
    }
    public void setUserBean(User userBean) {
        this.userBean = userBean;
    }
    public String getErrorMessag() {
        return errorMessag;
    }
    public void setErrorMessag(String errorMessag) {
        this.errorMessag = errorMessag;
    }
    
    @Override
    public void withSession(Map<String, Object> session) {
        this.userSession = session;
    }
}
