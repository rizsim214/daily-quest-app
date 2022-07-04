<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<style>
    
</style>
<s:include value="/views/includes/_header.jsp" />
<s:include value="/views/includes/sections/_navigation.jsp"/>
<div class="background vh-100">
    <div class="container pt-5  ">
        <div class="col-md-5 py-5 mb-5 bg-light mx-auto d-flex justify-content-center rounded shadow-lg text-center flex-column">
            <s:form action="signup" style="max-width: 380px; width: 100%;" class="mx-auto px-3">
                <h2 class="text-success"> Sign Up Now!</h2>
                <small class="text-secondary">Your information are safe with us</small>
                <p class="text-danger mb-2"><s:property value="errorMessage"/></p>
                <hr>
                <s:textfield name="userBean.userEmail" class="form-control mt-2 " placeholder="Email Address"/>
                <s:textfield name="userBean.userName" class="form-control mt-2 "  placeholder="Username"/>
                <s:textfield name="userBean.userAddress" class="form-control mt-2" placeholder="Address"/>
                <s:textfield name="userBean.userPhoneNumber"  max="11" class="form-control mt-2" placeholder="Contact Information"/>
                <s:password name="userBean.userPassword" class="form-control mt-2" placeholder="Password" />
                <s:password name="password_confirm" class="form-control mt-2" placeholder="Confirm Password"/>
                <s:submit value="Sign Up" class="btn btn-warning mt-3 py-3 text-light" style="width: 100% ;"/>
            </s:form>
            <s:url var="signin_user" action="sign_in"/>
            <p class="text-dark mt-3 h6">Already have an account? <s:a href="%{signin_user}" class="text-decoration-none">Login </s:a></p>
        </div>
    </div>
</div>
<s:include value="/views/includes/_footer.jsp" />
