<!DOCTYPE html>
<html>
<head>
  <title>Login Page</title>
  <style>
    body {
      background-color: #F0F0F0;
      font-family: Arial, sans-serif;
      color: #333;
    }

    h1 {
      color: #0099FF;
      text-align: center;
      margin-top: 50px;
    }

    form {
      background-color: #FFF;
      padding: 20px;
      border-radius: 10px;
      box-shadow: 0 0 10px rgba(0,0,0,0.2);
      width: 300px;
      margin: 0 auto;
      margin-top: 50px;
    }

    input[type=text], input[type=password] {
      width: 100%;
      padding: 10px;
      margin: 5px 0 20px;
      display: inline-block;
      border: none;
      border-radius: 4px;
      box-sizing: border-box;
      box-shadow: 0 0 5px rgba(0,0,0,0.1);
    }

  input[type=submit] {
  background-color: #0099FF;
  color: #FFF;
  border: none;
  padding: 10px 20px;
  border-radius: 4px;
  cursor: pointer;
  font-size: 16px;
  font-weight: bold;
  box-shadow: 0 2px 5px rgba(0,0,0,0.2);
  transition: all 0.3s ease-in-out;
}

input[type=submit]:hover {
  background-color: #0066CC;
  box-shadow: 0 2px 5px rgba(0,0,0,0.3);
}



    .error {
      color: #FF0000;
      margin-top: 10px;
      text-align: center;
      font-size: 14px;
      font-weight: bold;
    }
  </style>
</head>
<body>
  <h1>Login Page</h1>
  <form name="submitForm" method="POST" action="loginCheck">
    <div>
      <label for="username">Username:</label>
      <input type="text" id="username" name="username" required>
    </div>
    <div>
      <label for="password">Password:</label>
      <input type="password" id="password" name="password" required>
    </div>
    <div>
      <input type="submit" value="Submit">
    </div>
    <div class="error">
      <% if (request.getAttribute("error") != null) { %>
        <%= request.getAttribute("error") %>
      <% } %>
    </div>
  </form>
</body>
</html>
