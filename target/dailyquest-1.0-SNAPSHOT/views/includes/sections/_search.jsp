<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div class="row">
    <s:form action="search_quest_board">
        <s:textfield name="searchTitle" placeholder="Search Quest" />
        <s:submit placeholder="Search" />
    </s:form>
    <!-- <form action="#" class="col">
        <input type="text" class="form-control"  placeholder="Search Quest">
    </form> -->
<!-- Example single danger button -->
    <!-- <div class="col">
        <button type="button" class="btn btn-secondary dropdown-toggle" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            Filter
        </button>
        <div class="dropdown-menu">
            <a class="dropdown-item" href="#">Date</a>
            <a class="dropdown-item" href="#">Bounty</a>
            <a class="dropdown-item" href="#">Difficulty</a>
        </div>
    </div> -->
</div>