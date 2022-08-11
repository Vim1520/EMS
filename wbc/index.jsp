
<!DOCTYPE html>
<html>
<head>
<title>login</title>

</head>
<body>
<form method='POST' action="j_security_check">
		<h1>
			<center>Login</center>
		</h1>
		<table>
			<tr>
				<td>Employee ID</td>
				<td><input type="text" name ="j_username"></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="j_password" ></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="login"></td>
			</tr>

		</table>

	</form>
</body>
</html>