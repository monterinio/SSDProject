<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"
	name="viewport" content="initial-scale=1, maximum-scale=1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Submit paper</title>
</head>
<body style="background-color: #f7f7f7">
	<section>
		<div class="jumbotron" style="background-color: #46B5DA;">
			<div class="container">
				<h1 style="color: white; text-align: center;">Submit paper.</h1>
			</div>
		</div>
	</section>
	<section class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<div class="panel panel-default">
					<div class="panel-body">
						<form action="SubmitPaperService" method="post" enctype="multipart/form-data">
							<fieldset>
								<div class="form-group">
									<label for="firstName">First Name:</label> <input type="text"
										class="form-control" name="firstName">
								</div>
								<div class="form-group">
									<label for="lastName">Last Name:</label> <input type="text"
										class="form-control" name="lastName">
								</div>
								<div class="form-group">
									<label for="subject">Subject:</label> <input type="text"
										class="form-control" name="subject">
								</div>
								<div class="form-group">
									<label for="topic">Topic:</label> <input type="text"
										class="form-control" name="topic">
								</div>
								<div class="form-group">
									<label for="report">File:</label> <input type="file"
										class="form-control" name="report">
								</div>
								<input class="btn btn-primary btn-block" type="submit"
									value="Send">
							</fieldset>
						</form>
					</div>
				</div>
			</div>
		</div>
	</section>
	<script type="text/javascript" src="webjars/jquery/2.1.1/jquery.min.js"></script>
	<script type="text/javascript"
		src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>