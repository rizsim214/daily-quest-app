<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div class="row">
    <s:form action="search_quest_board" theme="simple">
        <s:textfield name="searchTitle" placeholder="Search Quest" class="form-control" />
        <div>
            <button type="button" class="btn btn-secondary dropdown-toggle" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Filter</button>
            <div class="dropdown-menu">
                <li><a class="dropdown-item" href="<s:url action='get_all_quests'/>">Date</a></li>
                <li><a class="dropdown-item" href="<s:url action='filter_all_quests_by_bounty'/>">Bounty</a></li>
                <div class="dropdown-divider"></div>
                <li><a class="dropdown-item" href="<s:url action='get_all_quests_easy'/>">Easy</a></li>
                <li><a class="dropdown-item" href="<s:url action='get_all_quests_medium'/>">Medium</a></li>
                <li><a class="dropdown-item" href="<s:url action='get_all_quests_hard'/>">Hard</a></li>
            </div>
        </div>
    </s:form>      
</div>