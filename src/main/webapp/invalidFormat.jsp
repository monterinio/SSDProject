<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ page import="java.nio.file.Paths" %>
<!DOCTYPE html">
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" 
         name="viewport" content="initial-scale=1, maximum-scale=1">
      <link rel="stylesheet"
         href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
      <title>Invalid format</title>
   </head>
   <body style="background-color: #f7f7f7">
	<%! String fileName; %>
	<% fileName = Paths.get(request.getPart("report").getSubmittedFileName()).getFileName().toString(); %>
      <section>
         <div class="jumbotron" style="background-color: #46B5DA;">
            <div class="container">
               <h1 style="color: white; text-align: center;">
                  Hold on!
               </h1>
               <p style="color: white;">Unfortunately, file <%= fileName %> has inappropriate file extension. <br>
					Our trolls can only deal with .doc, .docx, .odt and .pdf format
               </p>
            </div>
         </div>
      </section>
      <section class="container">
         <div class="row">
            <div class="col-md-4 col-md-offset-4">
               <button type="button" class="btn btn-primary btn-block" name="back" onclick="history.back()">Back</button>
            </div>
         </div>
      </section>
      <script type="text/javascript" src="webjars/jquery/2.1.1/jquery.min.js"></script>
      <script type="text/javascript" src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
   </body>
</html>