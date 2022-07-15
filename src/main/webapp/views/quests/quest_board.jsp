<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:include value="/views/includes/_header.jsp" />
<s:include value="/views/includes/sections/_session_nav.jsp"/>

<div class="container mx-auto mb-5  pb-5">
    <h2 class="text-center mt-3"> Quest Board</h2>
    <s:set var="success_message" value="successMessage" />
    <s:set var="error_message" value="errorMessage" />
    
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
    <table class="table table-secondary table-hover ">
        <thead>
        <tr class="table-dark">
            <th >Title</th>
            <th >Provider</th>
            <th >Schedule</th>
            <th >Timespan</th>
            <th >Location</th>
            <th >Description</th>
            <th >Bounty</th>
            <th >Action</th>
        </tr>
        </thead>
        <tbody>
            <s:iterator value="quests" status="questRow" >
                <tr>
                    <th><s:property value="questName"/></th>
                    <th><s:property value="questProvider"/></th>
                    <th><s:property value="questDate"/></th>
                    <td><s:property value="questTimespan"/></td>
                    <td><s:property value="questLocation"/></td>
                    <td><s:property value="questDescription"/></td>
                    <td>P<s:property value="questBounty"/>.00 /hr</td>
                    <td >
                        <s:url var="accept_quest" action="acceptQuest" >
                            <s:param name="transaction.questID" value="questId" />
                            <s:param name="transaction.questProviderID" value="questProviderId" />
                            <s:param name="transaction.questSeekerID" value="#session.sessionUser.userID" />
                        </s:url>
                        <s:a href="%{accept_quest}" class="btn btn-outline-success" onclick="return confirm('You are about to accept this quest. Proceed?')"><i class="fas fa-check"></i> </s:a>
                    </td>
                </tr>
            </s:iterator>
        </tbody>
    </table>
</div>
<s:include value="/views/includes/_footer.jsp" />

  