<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:include value="/views/includes/_header.jsp" />
<s:include value="/views/includes/sections/_session_nav.jsp"/>

<div class="container mx-auto mb-5  pb-5">
    <h2 class="text-center mt-3"> Quest Board</h2>
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
    <table class="table table-secondary table-hover ">
        <thead>
        <tr class="table-dark">
            <th scope="col">Title</th>
            <th scope="col">Provider</th>
            <th scope="col">Timespan</th>
            <th scope="col">Location</th>
            <th scope="col">Description</th>
            <th scope="col">rate/hr</th>
            <th scope="col">Action</th>
        </tr>
        </thead>
        <tbody>
            <s:iterator value="quests" status="questRow" >
                <tr>
                    <th><s:property value="questName"/></th>
                    <th><s:property value="questProvider"/></th>
                    <td><s:property value="questTimespan"/></td>
                    <td><s:property value="questLocation"/></td>
                    <td><s:property value="questDescription"/></td>
                    <td>P<s:property value="questBounty"/>.00 /hr</td>
                    <td>
                        <s:url var="accept_quest" action="acceptQuest" >
                            <s:param name="transaction.questID" value="questId" />
                            <s:param name="transaction.questProviderID" value="questProviderId" />
                            <s:param name="transaction.questSeekerID" value="#session.sessionUser.userID" />
                        </s:url>
                        <s:a href="%{accept_quest}" class="btn btn-warning"><i class="fas fa-check text-light"></i> Accept</s:a>
                    </td>
                </tr>
            </s:iterator>
        </tbody>
    </table>
</div>
<s:include value="/views/includes/_footer.jsp" />

  