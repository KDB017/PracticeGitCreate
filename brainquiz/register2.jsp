<%@page contentType="text/html; charset=utf-8" %>
<%
    request.setCharacterEncoding("utf-8");
%>
<html>
    <head>
        <title>確認</title>
    </head>
    <body>
        <h1>入力情報</h1>
        <p>名前:<strong><%= request.getParameter("name")%></strong></p>
        <p>パスワード:<strong><%= request.getParameter("pass")%></strong></p>
        <%
            String age=request.getParameter("age");
            if(age.equals("child"))
            {
                age="18歳未満";

            }else
            {
                age="18歳以上";
            }
        %> 
        <p>年齢:<strong><%= age%></strong></p>
        開発経験:<strong>
            <%
                String[] langs=request.getParameterValues("lang");
                for(String lang:langs)
                {
                    out.println(lang+" ");
                }
            %>
        </strong><p></p>
        <p>住所:<strong><%= request.getParameter("address") %></strong></p>
        <p>ご意見・お問い合わせ:<strong><%= request.getParameter("msg") %></strong></p>

        <input type="submit" value="送信" />
        <input type="reset" value="取消" />
        <p>この画面はJSPで出力しています</p>

        
        
    </body>
</html>