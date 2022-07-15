<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:include value="/views/includes/_header.jsp" />
<s:include value="/views/includes/sections/_session_nav.jsp"/>

<div class="container-fluid col-md-11  mx-auto mb-5  pb-5">
    <h2 class="text-center mt-3"> Accepted Quests Board </h2>
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
            <th scope="col">Contact Info</th>
            <th scope="col">Timespan</th>
            <th scope="col">Location</th>
            <th scope="col">Description</th>
            <th scope="col">rate/hr</th>
            <th scope="col">Action</th>
        </tr>
        </thead>
        <tbody>
            <s:iterator value="transactions" status="transactionsRow" >
                <tr>
                    <th><s:property value="questName"/></th>
                    <th><s:property value="questProvider"/></th>
                    <th><s:property value="questDate"/></th>
                    <td><s:property value="timespan"/></td>
                    <td><s:property value="location"/></td>
                    <td><s:property value="description"/></td>
                    <td>P<s:property value="ratePerHour"/>.00 /hr</td>
                    <td>
                        <!-- <s:url var="cancel_quest" action="cancelQuest" >
                            <s:param name="transaction.questID" value="questId" />
                            <s:param name="transaction.questProviderID" value="questProviderId" />
                            <s:param name="transaction.questSeekerID" value="#session.sessionUser.userID" />
                        </s:url> -->
                        <s:a href="#"  onclick="return confirm('Are you sure you want to cancel quest?')" class="btn btn-outline-warning text-dark"><i class="fas fa-xmark"></i> </s:a>
                    </td>
                </tr>
            </s:iterator>
        </tbody>
    </table>
</div>
<s:include value="/views/includes/_footer.jsp" />

  

  