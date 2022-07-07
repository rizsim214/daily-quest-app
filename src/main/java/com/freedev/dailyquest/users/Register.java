package com.freedev.dailyquest.users;

import com.opensymphony.xwork2.ActionSupport;

// For Implementing Create Read Update & Delete methods for the Users
public class Register extends ActionSupport{
    // Global Properties
    private User userBean;
    private String password_confirm;
    private String errorMessage;
    @Override
    public String execute() throws Exception {
        String result;
        
        if(!userBean.getUserPassword().equals(password_confirm)) {
            setErrorMessage("Password confirmation did not match*");
            result = INPUT;
        }else{
            try {
                if(UsersDAO.addOneToDB(userBean)) {
                    result = SUCCESS;
                }else{
                   setErrorMessage("Account Registration Unsuccessful*");
                    result = INPUT;
                }
            } catch (Exception e) {
                e.printStackTrace();
                result = ERROR;
            }
        }
        return result;
    }

    public User getUserBean() {
        return userBean;
    }

    public void setUserBean(User userBean) {
        this.userBean = userBean;
    }

    public String getPassword_confirm() {
        return password_confirm;
    }

    public void setPassword_confirm(String password_confirm) {
        this.password_confirm = password_confirm;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

}

