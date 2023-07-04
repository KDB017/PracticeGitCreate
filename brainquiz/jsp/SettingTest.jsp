<%@page contentType="text/html; charset=utf-8" %>
<%@page import="bean.*" %>
<jsp:useBean id="qdto" scope="request" class="bean.QuizBeanDTO"></jsp:useBean>
<jsp:useBean id="msg" scope="request" class="java.lang.String"></jsp:useBean>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
function showChoices() {
  var selectedQuestion = $('input[name="question"]:checked').val();
  var qdto=document.getElementById("qdto");
  alert(qdto);
}
</script>

<html lang="ja">
<head>
  <title>設定</title>
</head>
<body>
  <h2><%= msg %></h2>

  <% for(int i=0;i < qdto.size(); i++){
    QuizBean qb=qdto.get(i);
  %>
  <p><label><input type="radio" name="question" onclick="showChoices()" value="<%= i %>" >
    <%= qb.getQuizQuestion() %></label></p>
  <% } %>

  <div id="choicesPlace"></div>
  <a href="/brainquiz/html/BrainChoice.html">トップページ</a>
</body>
</html>
