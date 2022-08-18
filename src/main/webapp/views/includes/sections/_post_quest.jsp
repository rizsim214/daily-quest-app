<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
  <!-- Modal -->
  <div class="modal fade" id="postQuestModal" tabindex="-1" aria-labelledby="postQuestModalLabel" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
            <h6 class="modal-title" id="postQuestModalLabel">Quest Form</h6>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
        </div>
        <div class="modal-body">
            <h6 class="text-center"> Please fill out the fields</h6>
        <s:form action="add_quest" class="px-4" style="width: 100%;" theme="simple">
            <!-- <s:hidden type="number" name="questBean.questProviderId" value="#session.sessionUser.userID"/> -->
            <s:textfield class="form-control mt-2" placeholder="Title" name="questBean.questName"/>
            <!-- <s:textfield class="form-control mt-2" placeholder="Start Date (dd-mm-yyyy)" name="questBean.questDate"/> -->
            <s:textfield class="form-control mt-2" placeholder="Location Address" name="questBean.questLocation"/>
            <!-- NEED START DATE & END DATE ENDPOINT TO POST QUEST ACTION -->
            <!-- <sj:datepicker id="time1" placeholder="Start Date" name="start" class="form-control" value="%{new java.util.Date()}" timepicker="true" />
            <sj:datepicker id="time2" placeholder="End Date" name="end" class="form-control" value="%{new java.util.Date()}" timepicker="true" /> -->
            <!-- <s:textfield class="form-control mt-2" placeholder="Timespan (9am - 4pm)" name="questBean.questTimespan"/> -->
            <s:textfield type="number" min="0" class="form-control mt-2" placeholder="Quest Bounty (rate/hour)" name="questBean.questBounty"/>
            <s:select headerKey="-1" headerValue="Task Difficulty"
                list="{'Easy', 'Medium', 'Hard'}" 
                name="questBean.questDifficulty" 
                class="form-control mt-2" />
            <s:textarea class="form-control mt-2" placeholder="Quest Information" name="questBean.questDescription"/>
            <s:submit value="Save" class="btn btn-outline-primary d-block w-100 mt-2"/>
        </s:form>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
        </div>
      </div>
    </div>
  </div>