package com.freedev.dailyquest.users;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class Login extends ActionSupport implements SessionAware{
    private User userBean;
    private String errorMessage;
    Map<String, Object> userSession;
    
    @Override
    public String execute() throws Exception {
        String result;
        User sessionBean = UsersDAO.fetchOneToDB(userBean.getUserEmail(), userBean.getUserPassword());
        
        if(sessionBean.getUserEmail() == null && sessionBean.getUserPassword() == null) {
             // IF NOT PRESENT SET ERROR MESSAGE & return INPUT
             setErrorMessage("Incorrect Email or Password*");
             result = INPUT;
        }else{
            userSession.put("sessionUser", sessionBean);
            userSession.put("sessionUserID", sessionBean.getUserID());
            result = SUCCESS;
        }
        return result;
    }
    public String logout() {
       if(userSession.isEmpty()){
            userSession.remove("sessionUser");
            return "success";
       }else{
            return "input";
       }
    }
    public User getUserBean() {
        return userBean;
    }
    public void setUserBean(User userBean) {
        this.userBean = userBean;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    public Map<String, Object> getUserSession() {
        return userSession;
    }
    public void setUserSession(Map<String, Object> userSession) {
        this.userSession = userSession;
    }
    @Override
    public void setSession(Map<String, Object> session) {
        this.userSession = session;
    }
}
