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
                Post Quest
            </button>
            <table class="table table-success table-hover">
                <thead>
                <tr class="table-dark">
                    <th scope="col">Quest Name</th>
                    <th scope="col">Provider</th>
                    <th scope="col">Timespan</th>
                    <th scope="col">Difficulty</th>
                    <th scope="col">Actions</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <th>Gardening</th>
                    <td>Bruce Wayne</td>
                    <td>10AM - 4PM</td>
                    <td>Medium</td>
                    <td><button class="btn btn-outline-success btn-sm">view</button></td>
                </tr>
                <tr>
                    <th>Cleaning Backyard</th>
                    <td>Daymian Wayne</td>
                    <td>10AM - 4PM</td>
                    <td>Medium</td>
                    <td><button class="btn btn-outline-success btn-sm">view</button></td>
                </tr>
                <tr>
                    <th>Carpentry Assistance</th>
                    <td>Bob The Builder</td>
                    <td>10AM - 4PM</td>
                    <td>Medium</td>
                    <td><button class="btn btn-outline-success btn-sm">view</button></td>
                </tr>
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
          <h5 class="modal-title" id="exampleModalLabel">Quest Information</h5>
          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
        </div>
        <div class="modal-body">
          <h4>Add fields for Quest Information</h4>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
          <button type="button" class="btn btn-primary">Save changes</button>
        </div>
      </div>
    </div>
  </div>