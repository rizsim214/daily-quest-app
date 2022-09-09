<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:include value="/views/includes/_header.jsp" />
<s:include value="/views/includes/sections/_session_nav.jsp"/>

<div class="col-md-8 mx-auto">
    <s:set var="success_message" value="successMessage" />
    <s:set var="error_message" value="errorMessage" />
    <s:set var="message" value="message" />
    
    <s:if test="#success_message != null ">
        <div class="alert alert-success mx-auto col-lg-7 mt-3" role="alert">
            <p class="text-success text-center "><s:property value="#success_message"/></p>
        </div>
    </s:if>
    <s:elseif test="#error_message != null">
        <div class="alert alert-danger mx-auto col-lg-7 mt-3" role="alert">
            <p class="text-danger text-center "><s:property value="#error_message"/></p>
        </div>
    </s:elseif>
    <s:elseif test="#message != null">
        <div class="alert alert-warning mx-auto col-lg-7 mt-3" role="alert">
            <p class="text-dark text-center "><s:property value="#message"/></p>
        </div>
    </s:elseif>
</div>
    <div class="container mx-auto mb-5 pb-4">
        <div class="text-center mb-2">
            <h3 class=" mt-3 mb-0"> Accepted Quests</h3>
            <small class="text-secondary mt-0">(Here you can see the quests you accepted from Quest Providers)</small>
        </div>
        <div class="d-flex justify-content-end">
            <s:include value="/views/includes/sections/_search.jsp"/>
        </div>
        <div class="row mt-3">
            <s:if test="transactions.isEmpty() != true ">
            <s:iterator value="transactions" status="transactionQuestRows">
                    <div class="card m-2 shadow-lg" style="width: 22rem;">
                        <div class="card-header mt-2">
                            <p class="h4 card-title text-center fw-bold"><s:property value="questName"/></p>
                            <hr>
                            <s:url var="view_provider" action="fetchUser">
                                <s:param name="userBean.userID" value="questProviderID"/>
                            </s:url>
                            <p class="h6 card-subtitle text-secondary mb-1">Provider: <s:a href="%{view_provider}" class="text-dark text-decoration-none"><span class="text-right" ><s:property value="questProvider"/></span></s:a></p>
                            <p class="h6 card-subtitle text-secondary mb-1">Mobile: <s:property value="contactInfo"/></p>
                            <p class="h6 card-subtitle text-muted">Location: <s:property value="location"/></p>
                        </div>
                        <div class="card-body">
                            <p class="h6 text-dark"><span class="mx-1">P<s:property value="ratePerHour"/>.00 /hr </span> - <span class="mx-1"><s:property value="timespan"/></span></p>
                            <hr>
                            <p class="text-justify"><s:property value="description"/></p>
                        </div>
                        <div class="card-footer">
                            <div class="d-flex justify-content-end align-items-center">
                                <p class=" h6 card-subtitle me-auto text-muted">Status: <small class="text-success text-capitalize"><s:property value="transaction_status"/></small></p>
                                <s:url var="cancel_quest" action="cancelQuest" >
                                    <s:param name="transaction.questID" value="questID" />
                                    <s:param name="transaction.questTransactionID" value="questTransactionID" />
                                </s:url>
                                <s:url var="start_quest" action="startQuest" >
                                    <s:param name="transaction.questTransactionID" value="questTransactionID" />
                                </s:url>
                                <s:if test="transaction_status == 'ongoing'">
                                    <s:a href="%{start_quest}" class="btn btn-outline-success disabled me-2" ><i class="fa-solid fa-clock-rotate-left"></i></s:a>
                                </s:if>
                                <s:else>
                                    <s:a href="%{start_quest}" class="btn btn-outline-success  me-2" ><i class="fa-solid fa-clock-rotate-left"></i></s:a>
                                </s:else>
                                <s:a href="%{cancel_quest}"  onclick="return confirm('Are you sure you want to cancel quest?')" class="btn btn-outline-warning"><i class="fas fa-xmark"></i> </s:a>
                            
                            </div>
                        </div>
                    </div>
            </s:iterator>
            </s:if>
            <h3 class="text-center text-secondary"> <s:property value="displayMessage"/></h3>
        </div>
    </div>
<s:include value="/views/includes/_footer.jsp" />

  
