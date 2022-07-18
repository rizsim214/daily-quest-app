<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:include value="/views/includes/_header.jsp" />
<s:include value="/views/includes/sections/_session_nav.jsp"/>

<div class="col-md-8 mx-auto">
    <s:set var="success_message" value="successMessage" />
    <s:set var="error_message" value="errorMessag" />
    <s:if test="#success_message != null ">
        <div class="alert alert-success mx-auto col-lg-7" role="alert">
            <p class="text-success text-center "><s:property value="#success_message"/></p>
        </div>
    </s:if>
    <s:elseif test="#error_message != null">
        <div class="alert alert-danger mx-auto col-lg-7" role="alert">
            <p class="text-danger text-center "><s:property value="#error_message"/></p>
        </div>
    </s:elseif>
</div>
    <div class="container mx-auto mb-5 pb-4">
        <h3 class="text-center mt-3"> Accepted Quests</h3>
        <div class="d-flex justify-content-end">
            <s:include value="/views/includes/sections/_search.jsp"/>
        </div>
        <div class="row mt-3">
            <s:iterator value="transactions" status="transactionQuestRows">
                    <div class="card m-2 shadow-lg" style="width: 22rem;">
                        <div class="card-header mt-2">
                            <p class="h4 card-title text-center fw-bold"><s:property value="questName"/></p>
                            <hr>
                            <p class="h6 card-subtitle text-secondary mb-1">Provider: <s:a href="" class="text-dark text-decoration-none"><span class="text-right" ><s:property value="questProvider"/></span></s:a></p>
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
                                <!-- <s:url var="cancel_quest" action="cancelQuest" >
                                <s:param name="transaction.questID" value="questId" />
                                <s:param name="transaction.questProviderID" value="questProviderId" />
                                <s:param name="transaction.questSeekerID" value="#session.sessionUser.userID" />
                            </s:url> -->
                            <s:a href="" class="btn btn-outline-success  me-2"><i class="fas fa-check"></i></s:a>
                            <s:a href=""  onclick="return confirm('Are you sure you want to cancel quest?')" class="btn btn-outline-warning"><i class="fas fa-xmark"></i> </s:a>
                            </div>
                        </div>
                    </div>
            </s:iterator>
        </div>
    </div>
<s:include value="/views/includes/_footer.jsp" />

  
