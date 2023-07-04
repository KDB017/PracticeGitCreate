<%@page contentType="text/html; charset=utf-8" %>
<%@page import="bean.*" %>
<jsp:useBean id="msg" scope="request" class="java.lang.String"></jsp:useBean>
<jsp:useBean id="bdto" scope="request" class="bean.BrainChoiceDTO"></jsp:useBean>

<html>
    <head>
        <title>選択肢表示画面</title>
    </head>
    <body>
        <h1><%= msg %></h1>

        <% 
            for(int i=0;i < bdto.size(); i++){
                BrainChoiceBean sb=bdto.get(i);
                
        %>
        選択肢番号 <%= sb.getID() %>
        ,選択肢 <%= sb.getChoice() %>
        、判定 <%= sb.getIsAnswer() %>
        、どの問題の選択肢か <%= sb.getQuestionID() %>
        <p></p>
        
            <% } %>
        <p></p>
        <a href="/brainquiz/BrainChoice.html">戻る</a>
    </body>
</html>
