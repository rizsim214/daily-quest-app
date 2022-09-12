<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:include value="/views/includes/_header.jsp" />
<s:include value="/views/includes/sections/_session_nav.jsp"/>

<div class="container my-3">
    <div class="text-center mb-2">
        <h3 class=" mt-3 mb-0">History Logs</h3>
        <small class="text-secondary mt-0">Here you can see your Quest History (as Quest Seeker or as Quest Provider)</small>
    </div>
    <div class="row">
        <div class="col">
            <h4 class="text-center">My Posted Quest Logs</h4>
            <table class="table table-hover mt-2" id="posted_quest_history">
                <thead class="table-dark">
                    <tr>
                    <th scope="col">Quest Title</th>
                    <th scope="col">Seeker</th>
                    <th scope="col">Location</th>
                    <th scope="col">End Date</th>
                    <th scope="col">Status</th>
                    </tr>
                </thead>
                <tbody>
                    <s:if test="asProviderHistory.isEmpty() != true">
                        <s:iterator value="asProviderHistory" >
                            <tr class="table-secondary">
                                <th scope="row"><s:property value="questName"/></th>
                                <td><s:property value="questSeeker"/></td>
                                <td><s:property value="location"/></td>
                                <td><s:property value="updatedAt" /></td>
                                <td class="text-success fw-bold text-capitalize"><i class="fas fa-check-circle me-1"></i><s:property value="transaction_status"/></td>
                            </tr>
                        </s:iterator>
                    </s:if>
                    <s:else>
                        <h6 class="text-center text-secondary"><em><s:property value="providerTableMessage"/></em></h6>
                    </s:else>
                </tbody>
            </table>
        </div>
        <div class="col">
            <h4 class="text-center">My Accepted Quests Logs</h4>
            <table class="table table-hover mt-2" id="accepted_quest_history">
                <thead class="table-primary">
                    <tr>
                    <th scope="col">Quest Title</th>
                    <th scope="col">Provider</th>
                    <th scope="col">Location</th>
                    <th scope="col">End Date</th>
                    <th scope="col">Status</th>
                    </tr>
                </thead>
                <tbody>
                    <s:if test="asSeekerHistory.isEmpty() != true">
                        <s:iterator value="asSeekerHistory" >
                            <tr class="table-primary">
                                <th scope="row"><s:property value="questName"/></th>
                                <td><s:property value="questProvider"/></td>
                                <td><s:property value="location"/></td>
                                <td><s:property value="updatedAt" /></td>
                                <td class="text-success fw-bold text-capitalize"><i class="fas fa-check-circle me-1"></i><s:property value="transaction_status"/></td>
                            </tr>
                        </s:iterator>
                    </s:if>
                    <s:else>
                        <h6 class="text-center text-secondary"><em><s:property value="seekerTableMessage"/></em></h6>
                    </s:else>
                </tbody>
            </table>
        </div>
    </div>
</div>
<s:include value="/views/includes/_footer.jsp" />

  