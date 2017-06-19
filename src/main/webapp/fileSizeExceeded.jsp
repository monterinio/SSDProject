<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html">
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" 
         name="viewport" content="initial-scale=1, maximum-scale=1">
      <link rel="stylesheet"
         href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
      <title>File Size Exceeded</title>
   </head>
   <body style="background-color: #f7f7f7">
      <%! double fileSize; %>
      <% fileSize = request.getPart("report").getSize()/(1024*1024); %>  
      <section>
         <div class="jumbotron" style="background-color: #46B5DA;">
            <div class="container">
               <h1 style="color: white; text-align: center;">
                  Hold on!
               </h1>
               <p style="color: white;">The file you are trying to upload has a size of <%= fileSize %> mb<br>
                  Our servers can store only files whose size does not exceed 50 mb 
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