<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:include value="/views/includes/_header.jsp" />
<s:include value="/views/includes/sections/_session_nav.jsp"/>

<main class="container-fluid col-md-11 mx-auto my-5 px-5">
    <div class="text-center mb-2">
        <h3 class=" mt-3 mb-0">Posted Quests</h3>
        <small class="text-secondary mt-0">(Here you can see all your posted quests as unless deleted)</small>
    </div>
    <div class="d-flex justify-content-between">
        <button type="button" class="btn btn-primary mb-3" data-bs-toggle="modal" data-bs-target="#postQuestModal">
            <i class="fas fa-plus me-2"></i>Post Quest
          </button>
          <s:include value="/views/includes/sections/_post_quest.jsp"/>
          <s:include value="/views/includes/sections/_search.jsp"/>
    </div>
    <div class="row">
        <s:iterator value="postedQuests" status="postedQuestRows">
            <div class="card m-2 col-md-4 rounded shadow-lg " style="width: 20rem;">
                <div class="card-header mt-1">
                    <p class="h5 card-title fw-bold text-capitalize"><s:property value="questName"/></p>
                    <p class="h6 card-subtitle mb-2 text-muted text-capitalize"><s:property value="questLocation"/></p>
                    <small class="text-secondary text-capitalize">Status: <s:property value="questStatus"/></small>
                </div>
                <div class="card-body">
                    <p class="h6 text-dark"><span class="mx-1">P<s:property value="questBounty"/>.00 </span> - <span class="mx-1"><s:property value="questTimespan"/></span></p>
                    <hr>
                    <p class="text-justify text-capitalize"><s:property value="questDescription"/></p>
                </div>
                <div class="card-footer">
                    <div class="d-flex justify-content-end align-items-center">
                        <s:url var="deleteQuest" action="delete_quest">
                            <s:param name="questID" value="questId" />
                        </s:url>
                        <p class=" h6 card-subtitle me-2 text-muted">Start Date: <s:property value="startDate"/></p>
                        <s:a href="" class="btn btn-outline-primary col-3 mx-1"><i class="fas fa-pen fs-5"></i></s:a>
                        <s:a href="%{deleteQuest}" class="btn btn-outline-danger col-3 mx-1" onclick="return confirm('Are you sure you want to delete posted quest?')"><i class="fas fa-trash-can fs-5"></i></s:a>
                    </div>
                </div>
            </div>
        </s:iterator>
    </div>
</main>

<s:include value="/views/includes/_footer.jsp" />
