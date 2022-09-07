package com.freedev.dailyquest.users;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
// import java.security.GeneralSecurityException;
// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.SQLException;
// import java.sql.Statement;
// import java.text.SimpleDateFormat;
// import java.util.Calendar;
// import java.util.Map;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.codec.binary.Base64;
// import org.apache.struts2.interceptor.SessionAware;

import com.freedev.dailyquest.GmailAPI.*;
import com.google.api.services.gmail.Gmail;
import com.google.api.services.gmail.model.Message;

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
                    Gmail service = GmailAPI.getGmailService();
		            MimeMessage Mimemessage = createEmail(userBean.getUserEmail(),"me","Account Created","Thank you for joining the Daily Quest App!");
		            Message message = createMessageWithEmail(Mimemessage);
		            message = service.users().messages().send("me", message).execute();
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

    public static void sendMessage(Gmail service, String userId, MimeMessage email)
			throws MessagingException, IOException {
		Message message = createMessageWithEmail(email);
		message = service.users().messages().send(userId, message).execute();
	}

	public static Message createMessageWithEmail(MimeMessage email) throws MessagingException, IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		email.writeTo(baos);
		String encodedEmail = Base64.encodeBase64URLSafeString(baos.toByteArray());
		Message message = new Message();
		message.setRaw(encodedEmail);
		return message;
	}

	public static MimeMessage createEmail(String to, String from, String subject, String bodyText) throws MessagingException, IOException {
		Properties props = new Properties();
		Session session = Session.getDefaultInstance(props, null);

		MimeMessage email = new MimeMessage(session);

		email.setFrom(new InternetAddress(from)); //me
		email.addRecipient(javax.mail.Message.RecipientType.TO, new InternetAddress(to)); //
		email.setSubject(subject); 

        email.setText(bodyText);
        
		return email;
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

