<%@page contentType="text/html; charset=utf-8" %>
<%! 
    String fortune()
    {
        String f;
        double fn=Math.random();
        if(fn>=0.7)
        {
            f="大吉";
        }else if(fn>=0.4)
        {
            f="中吉";
        }else
        {
            f="小吉";
        }
        return f;
    }
%>
<html>
    <head>
        <title>占い</title>
    </head>
    <body>
        <h1>お前の運</h1>
        <% for(int i=0;i<2;i++){ %>
            <strong><%=fortune() %></strong>
            <p></p>
            <% } %>

    </body>
</html>