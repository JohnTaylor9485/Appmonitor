<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ page import="com.skylon.Appmonitor.entity.App" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script
        src="https://code.jquery.com/jquery-3.3.1.js"
        integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="
        crossorigin="anonymous"></script>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>Search</title>
</head>

<body>
<b>请选择条件</b>
<br>

<input type="button" value="返回" onclick=window.location.href="/appmonitor";>


<style>
    .inner table {
        border-top: none;
        border-bottom: none;
        border-left: none;
        border-right: none;
    }
</style>

<table border="1" cellspacing="0" cellpadding="0" style="text-align:center; ">
    <c:forEach items="${requestScope.projectList}" var="keywordx" varStatus="id">
        <tr>
            <td width="500px">${keywordx.getName()}</td>
            <td width="3000px" class="inner">
                <table border="1" cellspacing="0" cellpadding="0" style="text-align:center;">
                    <c:forEach items="${keywordx.getAppList()}" var="keyword" varStatus="id">
                        <tr>
                            <td width="500px">${keyword.getName()}</td>
                            <td width="2500px" class="inner">
                                <table border="1" cellspacing="0" cellpadding="0" style="text-align:center;">
                                    <c:forEach items="${keyword.getParameterList()}" var="keywords" varStatus="id">
                                        <tr>
                                            <td width="1000px">${keywords.getpName()}</td>
                                            <c:if test="${keywords.getpStatus()=='NO DATA'}">
                                                <td style="color: brown" width="500px">没有数据</td>
                                            </c:if>
                                            <c:if test="${keywords.getpStatus()=='CONNECTION FAILED'}">
                                                <td style="color: red" width="500px">连接失败</td>
                                            </c:if>
                                            <c:if test="${keywords.getpStatus()=='NO RESPONSEDING'}">
                                                <td style="color: orange" width="500px">反馈超时</td>
                                            </c:if>
                                            <c:if test="${keywords.getpStatus()=='OK'}">
                                                <td width="500px" style="color: green">正常运行</td>
                                            </c:if>
                                            <td width="1000px">
                                                <a href="/appmonitor/status/details?proj=${keywordx.getId()}&app=${keyword.getId()}&param=${keywords.getPid()}">
                                                    <button type="button">显示详细信息</button>
                                                </a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </table>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
