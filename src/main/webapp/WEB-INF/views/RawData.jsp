<%@ page import="com.skylon.Appmonitor.entity.RealTimeMonitoringInformation" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page pageEncoding="UTF-8" %>
<input type="button" value="返回" onclick=window.location.href="/appmonitor";>
<script type="text/javascript">
    function base64(content) {
        return window.btoa(unescape(encodeURIComponent(content)));
    }

    /*
    *@tableId: table的Id
    *@fileName: 要生成excel文件的名字（不包括后缀，可随意填写）
    */
    function tableToExcel(tableID, fileName) {
        var table = document.getElementById(tableID);
        var excelContent = table.innerHTML;
        var excelFile = "<html xmlns:o='urn:schemas-microsoft-com:office:office' xmlns:x='urn:schemas-microsoft-com:office:excel' xmlns='http://www.w3.org/TR/REC-html40'>";
        excelFile += "<head><!--[if gte mso 9]><xml><x:ExcelWorkbook><x:ExcelWorksheets><x:ExcelWorksheet><x:Name>{worksheet}</x:Name><x:WorksheetOptions><x:DisplayGridlines/></x:WorksheetOptions></x:ExcelWorksheet></x:ExcelWorksheets></x:ExcelWorkbook></xml><![endif]--></head>";
        excelFile += "<body><table>";
        excelFile += excelContent;
        excelFile += "</table></body>";
        excelFile += "</html>";
        var link = "data:application/vnd.ms-excel;base64," + base64(excelFile);
        var a = document.createElement("a");
        a.download = fileName + ".xls";
        a.href = link;
        a.click();
    }
</script>
<button type="button" onclick="tableToExcel('datatable','data')">导出</button>
<table id="datatable" border="1" cellspacing="0" cellpadding="0" width="100%" style="align:center;">
    <tr bgcolor="ff9900" style="font-weight:bold;">
        <th>项目编号</th>
        <th>程序编号</th>
        <th>参数编号</th>
        <th>测试时间</th>
        <th>状态</th>
        <th>接收时间</th>
    </tr>
    <%
        //循环显示数据
        List<RealTimeMonitoringInformation> datalist = (List) request.getAttribute("dataList"); // 取request里面的对象队列
        if (datalist.size() != 0) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH点mm分ss秒");//每循环一次后将此时的值保存到对象里
//每循环一次后将此时的值保存到对象里
            for (int i = 0; i < datalist.size(); i++) {

    %>
    <tr>
        <td><%=datalist.get(i).getProjectCode() %>
        </td>
        <td><%=datalist.get(i).getProgramCode() %>
        </td>
        <td><%=datalist.get(i).getParameterCode() %>
        </td>
        <td><%=sdf.format(datalist.get(i).getCollectionTime())%>
        </td>
        <td><%=datalist.get(i).getStatus() == 2 ? "FAILED" : "OK"%>
        </td>
        <td><%=sdf.format(datalist.get(i).getReceiveTime())%>
        </td>
    </tr>
    <%
        }
    } else {
    %>
    <tr>
        <td colspan="6">数据库中没有数据！</td>
    </tr>
    <%
        }
    %>
</table>

