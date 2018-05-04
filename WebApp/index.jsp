<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<title>Hello World Page</title>
</head>
<body>
	<div>
		<header>
         		<p>В базе данных: ${message}</p>
         		<form method = "POST" action = "MyUrl">
         			Изменить данные на<input type="text" name ="value">
         			<input type="submit" value="Изменить">
         		</form>
		</header>
	</div>
</body>
</html>