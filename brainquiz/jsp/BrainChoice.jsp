<%@page contentType="text/html; charset=utf-8" %>
<%@page import="bean.*" %>
<jsp:useBean id="choices" scope="request" class="bean.BrainChoiceDTO"></jsp:useBean>
<jsp:useBean id="msg" scope="request" class="java.lang.String"></jsp:useBean>
<jsp:useBean id="question" scope="request" class="java.lang.String"></jsp:useBean>



<script type="text/javascript" src="CheckAnswer.js"></script>
<html>
    <head>
        <title>クイズ画面</title>
    </head>
    <body>
        <h1><%= question %></h1>

        
                <th width="100">選択肢</th>
            

            <% 
                for(int i=0;i < choices.size(); i++){
                    BrainChoiceBean sb=choices.get(i);
                
            %>
            
                <p><label><input type="radio" name="answer" value=<%= sb.getIsAnswer() %>><%= sb.getChoice() %></label></p>
            
            <% } %>
        <p><input type="button" value="回答する" onclick="checkAns()"></p>
        <div id="praceans"></div>
        <p></p>
        <a href="/brainquiz/html/BrainChoice.html">トップページ</a>
        <button onclick="location.href='/brainquiz/choice'" >次へ</button>
    </body>
</html>
