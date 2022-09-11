<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:include value="/views/includes/_header.jsp" />
<s:include value="/views/includes/sections/_session_nav.jsp"/>

<div class="container col-md-10 mx-auto">
    <div class="row text-center mt-3">
        <div class="col-md-4 ">
            <div class="card" style="width: 100%;">
                <a href="#" type="button" class="text-secondary fs-4 ms-auto px-2 pt-2" data-bs-toggle="modal" data-bs-target="#updateUserModal">
                    <i class="fa-solid fa-gear"></i>
                </a>
                <div class="col-md-8 mx-auto pt-1">
                    <img src='<s:url value="/assets/img/avatarMale.svg"/>' class="card-img-top" alt="maleAvatar">
                </div>
                <div class="card-body">
                  <h5 class="card-title"><s:property value="userBean.userName"/></h5>
                  <p class="card-subtitle"><s:property value="userBean.userEmail"/></p>
                </div>
                <ul class="list-group list-group-flush">
                  <li class="list-group-item"><p class="px-2">
                    <small class="fw-bold">Contact Info</small>
                    <p><s:property value="userBean.userPhoneNumber"/></p>
                  </p></li>
                  <li class="list-group-item"><p class="px-2">
                    <small class="fw-bold">Home Address</small>
                    <p><s:property value="userBean.userAddress"/></p>
                  </p></li>
                </ul>
              </div>
        </div>
        <div class="col-md-8">
            <div class="card text-center">
                <div class="card-header">
                  Information
                </div>
                <div class="card-body">
                  <h5 class="card-title">Achievements</h5>
                    <div class="row">
                        <div class="col-md-6">
                            <span class="h2 text-success">
                                <i class="fa-sharp fa-solid fa-flag-checkered"></i>
                                <span><s:property value="finishedQuests" /></span>
                            </span>
                            <p class="fw-bold text-muted ">Finished Quests</p>
                        </div>
                        <div class="col-md-6">
                            <span class="h2 text-warning">
                                <i class="fa-solid fa-chess-king me-1"></i>
                                <span><s:property value="postedQuestCount" /></span>
                            </span>
                            <p class="fw-bold text-muted ">Posted Quests</p>
                        </div>
                    </div>
                </div>
                <div class="card-footer">
                    Activities
                </div>
                <div class="card-body border-top">
                    <h5 class="card-title">Recent user activity logs here</h5>
                </div>
                <div class="card-footer text-muted">
                    END OF LINE
                </div>
            </div>
        </div>
    </div>
</div>

<s:include value="/views/includes/_footer.jsp" />

  <!-- Modal -->
<div class="modal fade" id="updateUserModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Update Information</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form action="updateUser" method="POST">
                    <input type="email" name="userBean.userEmail" placeholder="Email Address" value='<s:property value="#session.sessionUser.userEmail"/>' class="form-control my-2" required/>
                    <input type="text" name="userBean.userName" placeholder="Username" value='<s:property value="#session.sessionUser.userName"/>' class="form-control my-2" required/>
                    <input type="text" name="userBean.userAddress" placeholder="Home Address" value='<s:property value="#session.sessionUser.userAddress"/>' class="form-control my-2" required/>
                    <input type="number" name="userBean.userPhoneNumber" placeholder="Contact Information" value='<s:property value="#session.sessionUser.userPhoneNumber"/>' class="form-control my-2" required/>
                    <input type="password" name="userBean.userPassword" placeholder="New Password" value='' class="form-control my-2"/>
                    <input type="hidden" name="hiddenPassword" value='<s:property value="userBean.userPassword"/>'>
                    <input type="password" name="passwordConfirmation" placeholder="Confirm Password" class="form-control my-2"/>
                    <button name="submitType" value="update" type="submit" class="btn btn-info w-100" >Update</button>
                </form>
            </div>
           <hr>
        </div>
    </div>
</div>


<!-- <div class="container col-md-8 mt-5">
    <div class="d-flex justify-content-between align-items-center">
        <s:url var="getQuests" action="get_all_quests"/>
        <s:a href="%{getQuests}" class="text-primary fw-bold text-deocration-none  "><i class="fas fa-arrow-left me-2"></i>Go back</s:a>
        
        <s:if test="userBean.userID == #session.sessionUserID">
            <button type="button" class="btn btn-warning text-light" data-bs-toggle="modal" data-bs-target="#updateUserModal">
                <i class="fas fa-pen me-2"></i>Update
            </button>
        </s:if>
    </div>
    <h3 class="text-center mt-5 text-capitalize">Profile</h3>
    <hr class="col-md-8 mx-auto ">
    <div class="col-md-8 mx-auto row mt-5 mb-3">
        
        <div class="col-md-6">
            <p class=" h5 text-dark text-center border-bottom border-secondary pb-2 mx-2"><s:property value="userBean.userEmail"/></p>
            <p class="h6 text-center text-secondary">Email Address</p>
        </div>
        <div class="col-md-6">
            <p class=" h5 text-dark text-center border-bottom border-secondary pb-2 mx-2 text-capitalize"><s:property value="userBean.userName"/></p>
            <p class="h6 text-center text-secondary">Username</p>
        </div>
    </div>
    <div class="col-md-8 mx-auto row my-3 ">
        <div class="col-md-6">
            <p class=" h5 text-dark text-center border-bottom border-secondary pb-2 mx-2"><s:property value="userBean.userAddress"/></p>
            <p class="h6 text-center text-secondary">Home Address</p>
        </div>
        <div class="col-md-6">
            <p class=" h5 text-dark text-center border-bottom border-secondary pb-2 mx-2 text-capitalize"><s:property value="userBean.userPhoneNumber"/></p>
            <p class="h6 text-center text-secondary">Mobile Number</p>
        </div>
    </div>
</div> -->