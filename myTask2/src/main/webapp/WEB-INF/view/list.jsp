<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*"%>
<!--相当于response.setContentType("text/html; charset=UTF-8"); 通知浏览器以UTF-8进行中文解码   导入jar包-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!--
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!--我想上面应该就不需要动了-->
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>用户列表</title>
</head>
<body>
<table border="1" width="1000px"  align='center'>
    <tr>
        <td>id</td>
        <td>home</td>
        <td>no</td>
        <td>EntranceTime</td>
        <td>name</td>
        <td>sex</td>
        <td>age</td>
        <td>qq</td>
        <td>school</td>
        <td>city</td>
        <td>motto</td>
    </tr>
    <c:forEach items="${list}" var="c" varStatus="st"><!--打印循环-->
    <tr>
        <td>${c.id}</td>
        <td>${c.home}</td>
        <td>${c.no}</td>
        <td>${c.entranceTime}</td>
        <td>${c.name}</td>
        <td>${c.sex}</td>
        <td>${c.age}</td>
        <td>${c.getqq()}</td>
        <td>${c.school}</td>
        <td>${c.city}</td>
        <td>${c.motto}</td>
        <td><a href="del/${c.id}">删除</a></td>
    </c:forEach>
</table>
<div style="text-align:center">
    <a href="?start=0">首  页</a>
    <a href="?start=${page.start-page.count}">上一页</a>
    <a href="?start=${page.start+page.count}">下一页</a>
    <a href="?start=${page.last}">末  页</a>
</div>
</table>
</body>
<body>
<a href="/add">添加</a>
<a href="/upd">改</a>
</body>
<body>


<form method="post" action="/selI"${id}><!--指向的是路径名称-->
    <table width="100px" border=1>
        <tr>
            <td>ID</td>
            <td><input type="text" name="id" value="" /></td>
        </tr>
        <tr>
            <td><a href="del/${id}">删除</a></td>
            <td colspan="5" align="center"><input type="submit" value="提交" />
            </td>
        </tr>
    </table>
</form>

</body>
</html>

