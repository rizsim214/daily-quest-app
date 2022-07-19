<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:include value="/views/includes/_header.jsp" />
<s:include value="/views/includes/sections/_session_nav.jsp"/>

<div class="container my-3">
    <div class="text-center mb-2">
        <h3 class=" mt-3 mb-0">Quests Transactions</h3>
        <small class="text-secondary mt-0">(Here you can see your posted quest which have been accepted by job seekers)</small>
    </div>
    <table class="table table-hover">
        <thead class="table-dark">
            <tr>
            <th scope="col">Quest Title</th>
            <th scope="col">Provider</th>
            <th scope="col">Seeker</th>
            <th scope="col">Date</th>
            <th scope="col">Status</th>
            <th colspan="2"></th>
            
            
            </tr>
        </thead>
        <tbody>
            
            <s:iterator value="transactions" >
                <s:property/>
                <tr class="table-success">
                    <th scope="row"><s:property value="questName"/></th>
                    <td><s:property value="#session.sessionUser.userName"/></td>
                    <td><s:property value="questSeeker"/></td>
                    <td><s:property value="questDate"/></td>
                    <td><s:property value="transaction_status"/></td>
                    <s:if test="transaction_status == 'ongoing'">
                        <s:url var="end_quest" action="endQuest" >
                            <s:param name="transaction.questID"/>
                            <s:param name="transaction.questTransactionID" value="questTransactionID" />
                        </s:url>
                        <td><s:a class="btn btn-outline-success" href="#"><i class="fas fa-check"></i></s:a></td>
                    </s:if>
                    <td><s:a href="#" class="btn btn-warning" onclick="return confirm('You are about to cancel transaction, proceed?')" ><i class="fas fa-xmark"></i></s:a></td>
                </tr>
        </s:iterator>
        </tbody>
    </table>
</div>
<s:include value="/views/includes/_footer.jsp" />

  