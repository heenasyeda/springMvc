
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<style>
.container {
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
}

.content {
	width: 80%;
	max-width: 800px;
	text-align: center;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Insert title here</title>
</head>
<body>
	<h5>Login Page</h5>
	<div class="container">
		<div class="content">
			<form action="/login" method="post">
				<div>
					<label for="username">Username:</label> <input type="text"
						id="username" name="username" required>
				</div>
				<br />
				<div>
					<label for="password">Password:</label> <input type="password"
						id="password" name="password" required>
				</div>
				<br />
				<div>
					<button type="submit">Login</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>

