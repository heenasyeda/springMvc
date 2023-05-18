<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Revenue</title>
  <style>
		body {
			font-family: Arial, sans-serif;
			background-color: #f2f2f2;
		}
		h1 {
			text-align: center;
			color: #333;
			margin-top: 50px;
			margin-bottom: 30px;
		}
		form {
			margin: auto;
			width: 400px;
			background-color: #fff;
			padding: 20px;
			box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.2);
			border-radius: 10px;
		}
		label {
			display: block;
			margin-bottom: 5px;
			color: #333;
		}
		input[type="text"] {
			display: block;
			width: 100%;
			padding: 10px;
			border: 1px solid #ccc;
			border-radius: 4px;
			font-size: 16px;
			margin-bottom: 20px;
			box-sizing: border-box;
		}
		input[type="submit"] {
			display: block;
			background-color: #a8aca8;
			color: #fff;
			padding: 10px;
			font-size: 16px;
			border: none;
			border-radius: 4px;
			cursor: pointer;
			transition: background-color 0.3s;
		}
		input[type="submit"]:hover {
			background-color: #9faa9f;
		}
	</style>
</head>
<body>
    <div class="container">
        <h1>Add Revenue</h1>

        <form method="post" action="saveRevenue">
          <!--    <label for="revenueID">Revenue ID:</label>
            <input type="text" name="revenueID" id="revenueID"><br>  -->

            <label for="branchID">Branch ID:</label>
            <input type="text" name="branchID" id="branchID"><br>

            <label for="revenueAmount">Revenue Amount:</label>
            <input type="text" name="revenueAmount" id="revenueAmount"><br>

            <label for="timePeriod">Time Period:</label>
            <input type="text" name="timePeriod" id="timePeriod"><br>

            <label for="serviceManagerID">Service Manager ID:</label>
            <input type="text" name="serviceManagerID" id="serviceManagerID"><br>

            <input type="submit" value="Save">
        </form>
    </div>
</body>
</html>
