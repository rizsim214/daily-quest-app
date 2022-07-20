<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<s:include value="/views/includes/_header.jsp" />
<s:include value="/views/includes/sections/_navigation.jsp"/>

<div class="container">
    <div class="row ">
        <div class="col">
            <div class="mt-5">
                <h1 class="fw-bold text-secondary text-center">The <span class="text-success display-4"> Daily</span><span class="text-warning display-4"> Quest</span> App</h1>
                <p class="h6 text-center text-secondary"> A convenient way to find manpower</p>
                <p class=" text-justify mt-4">
                   The app acts as a portal for People to scout other people to perform daily jobs or odd tasks refered in the app as <span class="text-success fs-4 fw-bold">Quests</span> 
                   where users can post requests like <span class="fs-5 "> backyard cleaning, grasscutting weeds, babysitting children or pets </span> etc. for odd job hunters or <span class="text-secondary fs-4 ">Seekers</span>
                   to accept. 
                </p>
                <p class="text-justify">
                    It enables <span class="text-primary fw-bold fs-4"> flexible </span> working schedules for <span class="text-secondary fs-4 "> Job Seekers </span> due to most jobs being usually done in less than a day. 
                    You can stack jobs as long as it doesn't conflict with other time schedules, so its easy to earn. 
                </p>
                <div class="d-flex justify-content-center mt-5">
                    <s:url var="signup" action="sign_up"/>
                    <s:a href="%{signup}" class="btn btn-success rounded py-3 mx-auto w-50">Sign up Now!</s:a>
                </div>
            </div>
        </div>
        <div class="col-md-6">
            <div class="mx-3 mt-5">
                <img src='<s:url value="/assets/img/myApp.svg"/>' alt="My App" class="img-fluid rounded shadow p-5">
            </div>
        </div>
    </div>
</div>
<s:include value="/views/includes/_footer.jsp" />
