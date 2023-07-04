<%@page contentType="text/html; charset=utf-8" %>
<%@page import="bean.*" %>
<jsp:useBean id="qdto" scope="request" class="bean.QuizBeanDTO"></jsp:useBean>

<%
int questionIndex = Integer.parseInt(request.getParameter("questionIndex"));
QuizBean selectedQuiz = qdto.get(questionIndex);
BrainChoiceDTO choicesDTO = selectedQuiz.getQuizChoicesBeanDTO();
%>

<ul>
<% for(int i=0; i<choicesDTO.size(); i++) {
  BrainChoiceBean qc = choicesDTO.get(i);
%>
  <li><%= qc.getChoice() %></li>
<% } %>
</ul>
