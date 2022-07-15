<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:include value="/views/includes/_header.jsp" />
<s:include value="/views/includes/sections/_navigation.jsp"/>
<div class="background vh-100">
    <div class="container pt-5 ">
        <div class="col-md-5 py-5 mt-5 bg-light mx-auto my-auto d-flex justify-content-center rounded shadow-lg text-center flex-column">
            <s:form action="signin" style="max-width: 380px; width: 100%;" class="mx-auto px-3">
                <h2 class="text-success"> Hello Master!</h2>
                <hr>
                <p class="text-danger mb-4"><s:property value="errorMessage"/></p>
                <s:textfield name="userBean.userEmail" class="form-control mt-2 " placeholder="Email Address"/>
                <s:password name="userBean.userPassword" class="form-control mt-2" placeholder="Password" />
                <s:submit value="Sign In" class="btn btn-warning mt-3 py-3 text-light" style="width: 100% ;"/>
            </s:form>
            <s:url var="signup" action="sign_up"/>
            <p class="text-dark mt-3 h6">Not a member yet? <s:a href="%{signup}" class="text-decoration-none" >Register </s:a></p>
        </div>
    </div>
</div>
<s:include value="/views/includes/_footer.jsp" />