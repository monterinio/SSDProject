<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html">
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" 
         name="viewport" content="initial-scale=1, maximum-scale=1">
      <link rel="stylesheet"
         href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
      <title>Reviewer panel</title>
   </head>
   <body style="background-color: #f7f7f7">
      <section>
         <div class="jumbotron" style="background-color: #46B5DA;">
            <div class="container">
               <h1 style="color: white; text-align: center;">
                  Welcome in reviewer panel.
               </h1>
            </div>
         </div>
      </section>
      <section class="container">
         <div class="row">
            <div class="table-responsive">
               <table class="table">
                  <thead>
                     <tr>
                        <th>Last Name</th>
                        <th>First Name</th>
                        <th>Subject</th>
                        <th>Topic</th>
                     </tr>
                  </thead>
                  <tbody>
                     <c:forEach items="${sessionScope.reportModelList}" var="reportModel" varStatus="status">
                        <tr>
                           <td>${reportModel.lastName}</td>
                           <td>${reportModel.firstName}</td>
                           <td>${reportModel.subject}</td>
                           <td>${reportModel.topic}</td>
                        </tr>
                     </c:forEach>
                  </tbody>
               </table>
            </div>
         </div>
         <div class="row">
            <div class="col-md-4 col-md-offset-4">
               <a href="/SSD/index.jsp" class="btn btn-primary btn-block" >Back to index</a>
               <a href="/SSD/LogoutService" class="btn btn-primary btn-block">Log out</a>
            </div>
         </div>
      </section>
      <script type="text/javascript" src="webjars/jquery/2.1.1/jquery.min.js"></script>
      <script type="text/javascript" src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
   </body>
</html>