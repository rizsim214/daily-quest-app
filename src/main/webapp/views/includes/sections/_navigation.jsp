<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<nav class="navbar navbar-expand-lg navbar-light bg-light py-4 shadow-lg">
    <div class="container">
        <s:url var="home" action="welcome"/>
        <s:a class="navbar-brand" href="%{home}">Daily Quest</s:a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ms-auto d-flex justify-content-sm-center align-items-center ">
                <li class="nav-item mx-2">
                    <a class="nav-link"  href="#">Home</a>
                </li>
                <li class="nav-item mx-2">
                    <a class="nav-link" href="#">About Us</a>
                </li>
                <li class="nav-item mx-2">
                    <s:url var="signin" action="sign_in"/>
                    <s:a class="nav-link" href="%{signin}">Sign In</s:a>
                </li>
                <li class="nav-item mx-2">
                    <s:url var="signup" action="sign_up"/>
                    <s:a class="btn btn-success px-3 py-2" style="width: 140px;" href="%{signup}">Sign Up</s:a>
                </li>
            </ul>
        </div>
    </div>
  </nav>