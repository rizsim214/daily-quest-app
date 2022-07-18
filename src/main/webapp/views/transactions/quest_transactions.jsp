<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:include value="/views/includes/_header.jsp" />
<s:include value="/views/includes/sections/_session_nav.jsp"/>

<div class="container my-3">
    
    <h2 class="text-center">Quest Transactions</h2>
    <table class="table table-hover">
        <thead class="table-dark">
            <tr>
            <th scope="col">Quest Title</th>
            <th scope="col">Provider</th>
            <th scope="col">Seeker</th>
            <th scope="col">Date</th>
            <th scope="col">Status</th>
            </tr>
        </thead>
        <tbody>
            
            <s:iterator value="transactions">
                <tr class="table-success">
                    <th scope="row"><s:property value="questName"/></th>
                    <td><s:property value="#session.sessionUser.userName"/></td>
                    <td><s:property value="questSeeker"/></td>
                    <td><s:property value="questDate"/></td>
                    <td><s:property value="transaction_status"/></td>
                </tr>
        </s:iterator>
        </tbody>
    </table>
</div>
<s:include value="/views/includes/_footer.jsp" />

  