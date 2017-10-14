<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>算了，难看就难看点吧</title>

</head>
<body>
<form method="delete" action="/add"><!--指向的是路径名称-->
    <table width="100px" border=1>
        <tr>
            <td>ID</td>
            <td><input type="text" name="id" value="" /></td>
        </tr>
        <tr>
            <td colspan="5" align="center"><input type="submit" value="提交" />
            </td>
        </tr>
    </table>
</form>

</body>

</html>
