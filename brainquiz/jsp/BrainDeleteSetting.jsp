<%@page contentType="text/html; charset=utf-8" %>
<%@page import="bean.*" %>
<jsp:useBean id="msg" scope="request" class="java.lang.String"></jsp:useBean>
<jsp:useBean id="bdto" scope="request" class="bean.BrainTestDTO"></jsp:useBean>

<html>
    <head>
        <title>問題追加画面</title>
    </head>
    <body>
        <h1><%= msg %></h1>

        <% 
            for(int i=0;i < bdto.size(); i++){
                BrainTestBean sb=bdto.get(i);
                
        %>
        <h3><%= sb.getNo() %></h3>
        <p><%= sb.getName() %></p>
            <% } %>
        <p></p>
        <a href="/brainquiz/BrainChoice.html">戻る</a>
    </body>
</html>
