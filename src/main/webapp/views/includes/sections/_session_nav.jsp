<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:if test="%{#session != null}">
<div class="d-flex flex-column flex-shrink-0 p-3 bg-dark shadow-lg" style="width: 90%; height:100%;">
    <a href="#" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-light text-decoration-none">
      <i class="fa-solid fa-chess fs-5 me-2"></i>
      <span class="fs-4 mx-auto">Dashboard</span>
    </a>
    <hr class="text-white">
    <ul class="nav nav-pills flex-column mb-auto">
      <li class="nav-item">
        <s:url var="questboard" action="get_all_quests"/>
        <s:a href="%{questboard}" class="nav-link text-light" aria-current="page">
            <i class="fas fa-chess-board fs-5 me-2"></i> Quest Board
        </s:a>
      </li>
      <li>
        <s:url var="postedquest" action="get_all_posted_quests"/>
        <s:a href="%{postedquest}" class="nav-link text-light">
            <i class="fas fa-pencil fs-5 me-2"></i> Posted Quests
        </s:a>
      </li>
      <li>
        <a href="#" class="nav-link text-light">
            <i class="fas fa-check fs-5 me-2"></i> Accepted Quests
        </a>
      </li>
      
      <li>
        <a href="#" class="nav-link text-light">
            <i class="fas fa-book fs-5 me-2"></i> Quest History
        </a>
      </li>
    </ul>
    <hr class="text-white">
    <div class="dropdown">
      <a href="#" class="d-flex align-items-center text-light text-decoration-none dropdown-toggle" id="dropdownUser1" data-bs-toggle="dropdown" aria-expanded="false">
        <img src="data:image/png;base64,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" alt="User" width="32" height="32" class="rounded-circle me-2">
        <strong><s:property value="#session.sessionUser.userName"/></strong>
      </a>
      <ul class="dropdown-menu dropdown-menu-dark text-small shadow" aria-labelledby="dropdownUser1">
        <li><a class="dropdown-item" href="#">Settings</a></li>
        <li><a class="dropdown-item" href="#">Profile</a></li>
        <li><hr class="dropdown-divider"></li>
        <s:url var="sessionLogout" action="logoutSession"/>
        <li><s:a class="dropdown-item" href="%{sessionLogout}">Sign out</s:a></li>
      </ul>
    </div>
  </div>
</s:if>
<s:else>
  
</s:else>