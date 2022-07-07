<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:include value="/views/includes/_header.jsp" />
<div class="row">
    <div class="col-lg-3 vh-100">
        <s:include value="/views/includes/sections/_session_nav.jsp"/>
    </div>
    <div class="col">
        <div class="container-fluid mx-auto mt-5">
            <!-- Button trigger modal -->
            <button type="button" class="btn btn-primary mb-3" data-bs-toggle="modal" data-bs-target="#exampleModal">
              <i class="fas fa-plus me-2"></i>Post Quest
            </button>
            <table class="table table-secondary table-hover">
                <thead>
                <tr class="table-dark">
                    <th scope="col">Quest Name</th>
                    <th scope="col">Timespan</th>
                    <th scope="col">Difficulty</th>
                    <th scope="col">Actions</th>
                </tr>
                </thead>
                <tbody>
                <s:iterator value="posted_quests">
                    <tr>
                        <th><s:property value="questName"/></th>
                        <td><s:property value="questTimespan"/></td>
                        <td><s:property value="questDifficulty"/></td>
                        <td><s:a class="btn btn-outline-success btn-sm">View Quest</s:a></td>
                    </tr>
                </s:iterator>
                </tbody>
            </table>
        </div>
    </div>
</div>
<s:include value="/views/includes/_footer.jsp" />

  
  <!-- Modal -->
  <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
            <h6 class="modal-title" id="exampleModalLabel">Quest Information</h6>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
        </div>
        <div class="modal-body">
            <h6 class="text-center"> Please fill out the fields</h6>
        <s:form action="add_quest" class="px-4" style="width: 100%;">
            <!-- <s:hidden type="number" name="questBean.questProviderId" value="#session.sessionUser.userID"/> -->
            <s:textfield class="form-control mt-3" placeholder="Title" name="questBean.questName"/>
            <s:textfield class="form-control mt-3" placeholder="Start Date (dd-mm-yyyy)" name="questBean.questDate"/>
            <s:textfield class="form-control mt-3" placeholder="Location Address" name="questBean.questLocation"/>
            <s:textfield class="form-control mt-3" placeholder="Timespan (9am - 4pm)" name="questBean.questTimespan"/>
            <s:textfield type="number" min="0" class="form-control mt-3" placeholder="Quest Bounty (rate/hour)" name="questBean.questBounty"/>
            <s:select headerKey="-1" headerValue="Task Difficulty"
                list="{'Easy', 'Medium', 'Hard'}" 
                name="questBean.questDifficulty" 
                class="form-control mt-3" />
            <s:textarea class="form-control mt-3" placeholder="Quest Information" name="questBean.questDescription"/>
            <s:submit value="Save" class="btn btn-outline-primary d-block w-100 mt-3"/>
        </s:form>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
        </div>
      </div>
    </div>
  </div>