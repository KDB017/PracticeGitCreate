<%@page contentType="text/html; charset=utf-8" %>
<%@page import="bean.*" %>
<jsp:useBean id="sdto" scope="request" class="bean.EditStudentDTO"></jsp:useBean>
<jsp:useBean id="msg" scope="request" class="java.lang.String"></jsp:useBean>

<html>
    <head>
        <title>表示画面</title>
    </head>
    <body>
        <h2><%= msg %></h2>
        <table border="0">
            <tr>
                <th width="50">番号</th>
                <th width="50">名前</th>
                <th width="50">点数</th>
            </tr>

            <% 
                for(int i=0;i < sdto.size(); i++){
                    EditStudentBean sb=sdto.get(i);
                
            %>
            <tr>
                <td align = "center"><%= sb.getNo() %></td>
                <td align="center"><%= sb.getName() %></td>
                <td align="center"><%= sb.getScore() %></td>
            </tr>
            <% } %>
        </table>
        <p></p>
        <a href="/brainquiz/editstudent.html">戻る</a>
    </body>
</html>
