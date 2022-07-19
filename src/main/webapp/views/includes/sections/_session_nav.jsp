<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark py-2">
  <div class="container">
    <s:url var="getQuests" action="get_all_quests"/>
    <s:a class="navbar-brand" href="%{getQuests}">Dashboard</s:a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
            <li class="nav-item">
                <s:url var="getQuests" action="get_all_quests"/>
                <s:a class="nav-link active" aria-current="page" href="%{getQuests}">Quest Board</s:a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle text-capitalize" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                    <s:property value="#session.sessionUser.userName"/>
                </a>
                <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <small class="text-secondary ms-3">Quest Seekers</small>
                        <li>
                            <s:url var="get_accepted_quests" action="getAcceptedQuests"/>
                            <s:a class="dropdown-item" href="%{get_accepted_quests}">My Daily Quests</s:a></li>
                        <li><hr class="dropdown-divider"></li>
                        <small class="text-secondary ms-3">Quest Provider</small>
                        <li>
                          <s:url var="get_posted_quests" action="get_all_posted_quests"/>
                          <s:a class="dropdown-item" href="%{get_posted_quests}">My Posted Quests</s:a></li>
                        <li>
                          <s:url var="get_quest_transactions" action="getAllTransaction"/>
                          <s:a class="dropdown-item" href="%{get_quest_transactions}">My Quest Transactions</s:a></li>
                        <li><hr class="dropdown-divider"></li>
                        <li><a class="dropdown-item" href="#">My History</a></li>
                        <li><a class="dropdown-item" href="#">Profile</a></li>
                        <li><hr class="dropdown-divider"></li>
                        <s:url var="sign_out" action="logoutSession"/>
                        <li><s:a class="dropdown-item" href="%{sign_out}">Sign Out</s:a></li>
                    </ul>
                </li>
            </ul>
    </div>
  </div>
</nav>