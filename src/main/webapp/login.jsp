<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html">
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" 
         name="viewport" content="initial-scale=1, maximum-scale=1">
      <link rel="stylesheet"
         href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
      <title>Login page</title>
   </head>
   <body style="background-color: #f7f7f7">
      <section>
         <div class="jumbotron" style="background-color: #46B5DA;">
            <div class="container">
               <h1 style="color: white; text-align: center;">
                  Log in
               </h1>
            </div>
         </div>
      </section>
      <section class="container">
         <div class="row">
            <div class="col-md-4 col-md-offset-4">
               <div class="panel panel-default">
                  <div class="panel-body">
                     <form action="j_security_check" method="post">
                        <fieldset>
                           <div class="form-group">
                              <input class="form-control" placeholder="user" 
                                 name='j_username' type="text">
                           </div>
                           <div class="form-group">
                              <input class="form-control" placeholder="password"
                                 name='j_password' type="password" value="">
                           </div>
                           <input class="btn btn-primary btn-block" type="submit"
                              value="Login">
                        </fieldset>
                     </form>
                  </div>
               </div>
            </div>
         </div>
      </section>
      <script type="text/javascript" src="webjars/jquery/2.1.1/jquery.min.js"></script>
      <script type="text/javascript" src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
   </body>
</html>