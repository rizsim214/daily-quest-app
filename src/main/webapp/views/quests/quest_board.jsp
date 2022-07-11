<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:include value="/views/includes/_header.jsp" />
<s:include value="/views/includes/sections/_session_nav.jsp"/>
<p class="text-danger"><em><s:property value="#errorMessag"/></em></p>
<div class="container-fluid mx-auto mb-5 pb-5">
    <h3 class="text-center"> Quest Board</h3>
    <table class="table table-secondary table-hover ">
        <thead>
        <tr class="table-dark">
            <th scope="col">Title</th>
            <th scope="col">Provider</th>
            <th scope="col">Timespan</th>
            <th scope="col">Location</th>
            <th scope="col">Description</th>
            <th scope="col">Bounty(rate/hr)</th>
            <th scope="col">Action</th>
        </tr>
        </thead>
        <tbody>
            <s:iterator value="quests" status="questRow" >
                <tr>
                    <th><s:property value="questName"/></th>
                    <th>name of provider</th>
                    <td><s:property value="questTimespan"/></td>
                    <td><s:property value="questLocation"/></td>
                    <td><s:property value="questDescription"/></td>
                    <td>P<s:property value="questBounty"/>.00 /hr</td>
                    <td>
                        <s:a href="#" class="btn btn-warning"><i class="fas fa-check text-light"></i> Accept</s:a>
                    </td>
                </tr>
            </s:iterator>
        </tbody>
    </table>
</div>
<s:include value="/views/includes/_footer.jsp" />

  