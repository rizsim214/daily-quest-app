<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:include value="/views/includes/_header.jsp" />
<s:include value="/views/includes/sections/_session_nav.jsp"/>

<div class="container-fluid mx-auto mt-5">
    <!-- Button trigger modal -->
    <button type="button" class="btn btn-primary mb-3" data-bs-toggle="modal" data-bs-target="#postQuestModal">
      <i class="fas fa-plus me-2"></i>Post Quest
    </button>
    <s:include value="/views/includes/sections/_post_quest.jsp"/>
    <table class="table table-secondary table-hover">
        <thead>
        <tr class="table-dark">
            <th scope="col">Title</th>
            <th scope="col">Timespan</th>
            <th scope="col">Location</th>
            <th scope="col">Description</th>
            <th scope="col">Bounty(rate/hr)</th>
            <th scope="col">Action</th>
        </tr>
        </thead>
        <tbody>
            <s:iterator value="posted_quests" status="questRow" >
                <tr>
                    <th><s:property value="questName"/></th>
                    <td><s:property value="questTimespan"/></td>
                    <td><s:property value="questLocation"/></td>
                    <td><s:property value="questDescription"/></td>
                    <td>P<s:property value="questBounty"/>.00 /hr</td>
                    <td>
                        <s:a href="#" class="btn btn-danger"><i class="fas fa-trash-can fs-5"></i></s:a>
                    </td>
                </tr>
            </s:iterator>
        </tbody>
    </table>
</div>

<s:include value="/views/includes/_footer.jsp" />

  