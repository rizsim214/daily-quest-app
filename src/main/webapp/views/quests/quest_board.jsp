<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:include value="/views/includes/_header.jsp" />
<s:include value="/views/includes/sections/_session_nav.jsp"/>

<div class="container-fluid mx-auto mb-5 pb-4 px-5">
    <div class="text-center mb-2">
        <h3 class=" mt-3 mb-0">Quests Board</h3>
        <s:url var="get_posted_quests" action="get_all_posted_quests"/>
        <small class="text-secondary mt-0">(Here you can see posted quests from other users. <br> To check your posted quests click <s:a href="%{get_posted_quests}" class="text-decoration-none text-primary">Here</s:a> )</small>
    </div>
    <div class="col-md-8 mx-auto">
        <s:set var="success_message" value="successMessage" />
        <s:set var="error_message" value="errorMessage" />
        
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
    </div>
    <div class="d-flex justify-content-end">
        <s:include value="/views/includes/sections/_search.jsp"/>
    </div>
    <div class="row mt-3">
        <s:iterator value="quests" status="postedQuestRows">
            <div class="card m-2 shadow-lg" style="width: 22rem;">
                <div class="card-header mt-2">
                    <p class="h4 card-title text-center fw-bold"><s:property value="questName"/></p>
                    <p class="text-center">Complexity: 
                        <s:if test="questDifficulty == 'Easy'"> <span class="text-success fw-bold"><s:property value="questDifficulty"/></span></s:if>
                        <s:elseif test="questDifficulty == 'Medium'"><span class="text-warning fw-bold"><s:property value="questDifficulty"/></span></s:elseif>
                        <s:else><span class="text-danger fw-bold"><s:property value="questDifficulty"/></span></s:else>
                    </p>
                    <hr>
                    <p class="h6 card-subtitle text-secondary">Provider: <s:property value="questProvider"/></p>
                    <small class="card-subtitle text-muted">Location: <s:property value="questLocation"/></small>
                </div>
                <div class="card-body">
                    <p class="h6 text-dark"><span class="mx-1">P<s:property value="questBounty"/>.00 /hr </span> - <span class="mx-1"><s:property value="questTimespan"/></span></p>
                    <hr>
                    <p class="text-justify"><s:property value="questDescription"/></p>
                </div>
                
                <div class="card-footer">
                    <div class="d-flex justify-content-end align-items-center">
                        <p class=" h6 card-subtitle me-auto text-muted">Start Date: <br> <span class="text-dark"><s:property value="startDate"/></span></p>
                        <s:url var="accept_quest" action="acceptQuest" >
                            <s:param name="transaction.questID" value="questId" />
                            <s:param name="transaction.questProviderID" value="questProviderId" />
                            <s:param name="transaction.questSeekerID" value="#session.sessionUser.userID" />
                        </s:url>
                        <s:if test="#session.sessionUserStatus == 'questing'">
                            <s:a href="%{accept_quest}" class="btn btn-outline-success disabled"  onclick="return confirm('You are about to accept this quest. Proceed?')"><i class="fas fa-check"></i> Accept</s:a>
                        </s:if>
                        <s:else>
                            <s:a href="%{accept_quest}" class="btn btn-outline-success "  onclick="return confirm('You are about to accept this quest. Proceed?')"><i class="fas fa-check"></i> Accept</s:a>
                        </s:else>
                    </div>
                </div>
            </div>
        </s:iterator>
    </div>
</div>
<s:include value="/views/includes/_footer.jsp" />



  