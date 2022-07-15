<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:include value="/views/includes/_header.jsp" />
<s:include value="/views/includes/sections/_session_nav.jsp"/>

<div class="container-fluid col-md-11 px-4 mt-5">
    <!-- Button trigger modal -->
    <button type="button" class="btn btn-primary mb-3" data-bs-toggle="modal" data-bs-target="#postQuestModal">
      <i class="fas fa-plus me-2"></i>Post Quest
    </button>
    <s:include value="/views/includes/sections/_post_quest.jsp"/>
    <table class="table table-secondary table-hover">
        <thead class="text-center">
        <tr class="table-dark">
            <th>Title</th>
            <th>Timespan</th>
            <th>Location</th>
            <th>Description</th>
            <th>Bounty(rate/hr)</th>
            <th >Actions</th>
            <th></th>

        </tr>
        </thead>
        <tbody>
            <s:iterator value="postedQuests" status="questRow" >
                <tr>
                    <th><s:property value="questName"/></th>
                    <td><s:property value="questTimespan"/></td>
                    <td><s:property value="questLocation"/></td>
                    <td><s:property value="questDescription"/></td>
                    <td>P<s:property value="questBounty"/>.00 /hr</td>
                    <td class="row">
                        <s:url var="deleteQuest" action="delete_quest">
                            <s:param name="questID" value="questId" />
                        </s:url>
                            <s:a href="#" class="btn btn-outline-primary col"><i class="fas fa-pen fs-5"></i></s:a>
                            <s:a href="%{deleteQuest}" class="btn btn-outline-danger col" onclick="return confirm('Are you sure you want to delete posted quest?')"><i class="fas fa-trash-can fs-5"></i></s:a>
                    </td>
                </tr>
            </s:iterator>
        </tbody>
    </table>
</div>

<s:include value="/views/includes/_footer.jsp" />

  