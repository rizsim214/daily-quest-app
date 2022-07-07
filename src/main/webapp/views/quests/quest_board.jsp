<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:include value="/views/includes/_header.jsp" />
<div class="row">
    <div class="col-lg-3 vh-100">
        <s:include value="/views/includes/sections/_session_nav.jsp"/>
    </div>
    <div class="col">
        <p class="text-danger"><em><s:property value="#errorMessag"/></em></p>
        <div class="container-fluid mx-auto mt-5">
            <table class="table table-secondary table-hover">
                <thead>
                <tr class="table-dark">
                    <th scope="col">Quest Name</th>
                    <th scope="col">Date</th>
                    <th scope="col">Location</th>
                    <th scope="col">Bounty(rate/hr)</th>
                    <th scope="col">Actions</th>
                </tr>
                </thead>
                <tbody>
                    <s:iterator value="quests">
                    <tr>
                        <th><s:property value="questName"/></th>
                        <td><s:property value="questDate"/></td>
                        <td><s:property value="questLocation"/></td>
                        <td>P<s:property value="questBounty"/>.00 /hr</td>
                        <td><s:a class="btn btn-outline-success btn-sm">View Quest</s:a></td>
                    </tr>
                </s:iterator>
                </tbody>
            </table>
        </div>
    </div>
</div>
<s:include value="/views/includes/_footer.jsp" />

  