package com.freedev.dailyquest.users;

import java.util.Map;

import org.apache.struts2.action.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class UpdateUser extends ActionSupport implements SessionAware {

    private User userBean;
    private String passwordConfirmation;
    Map<String, Object> userSession;
    private String submitType;
    private String hiddenPassword;

    public String execute() throws Exception {
        String result = ERROR;
        if(userBean.getUserPassword().equals("")) {
            UsersDAO.editUserWithHidden(userBean , hiddenPassword);
            result = SUCCESS;
        }else if(userBean.getUserPassword().equals(passwordConfirmation)) {
            UsersDAO.editUser(userBean);
            result = SUCCESS;
        }else{
            UsersDAO.editUser(userBean);
            result = SUCCESS;
        }
        return result;
    }

    public String fetchUser() throws Exception{
        setUserBean(UsersDAO.getOneUserFromDB(userSession.get("sessionUserID")));
        return "success";
    }
    
    public User getUserBean() {
        return userBean;
    }

    public void setUserBean(User userBean) {
        this.userBean = userBean;
    }

    @Override
    public void withSession(Map<String, Object> session) {
        this.userSession = session;
    }


    public String getSubmitType() {
        return submitType;
    }

    public void setSubmitType(String submitType) {
        this.submitType = submitType;
    }

    public String getPasswordConfirmation() {
        return passwordConfirmation;
    }

    public void setPasswordConfirmation(String passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
    }

    public String getHiddenPassword() {
        return hiddenPassword;
    }

    public void setHiddenPassword(String hiddenPassword) {
        this.hiddenPassword = hiddenPassword;
    }

    
    
}
