<%@ page pageEncoding="UTF-8" %>
<link href="https://cdn.bootcss.com/bootstrap/4.1.1/css/bootstrap-grid.css" rel="stylesheet">
<script
        src="https://code.jquery.com/jquery-3.3.1.js"
        integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="
        crossorigin="anonymous"></script>
<style>
    .btn span{
        width: 33%
    }
</style>
<body style="width:100%">
<h2 style="width:100%">应用监控系统</h2>
<p style="width:100%">
    <span class="btn">
        <input type="button" value="转到详细信息" onclick=window.location.href="/appmonitor/Complete";>
    </span>
    <span class="btn">
        <input  type="button" value="转到原始信息" onclick=window.location.href="/appmonitor/raw";>
    </span>
    <span class="btn">
        <input  type="button" value="转到监控信息" onclick=window.location.href="/appmonitor/status";>
    </span>
</p>
</body>







