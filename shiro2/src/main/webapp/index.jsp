<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>Login</h2>
<form method="post" action="login">
    uname	<input type="text" name="uname"><br>
    upass	<input type="text" name="upass"><br>
    <input type="submit" value="登录">
    <br>
    ${error}
</form>
</body>
</html>
