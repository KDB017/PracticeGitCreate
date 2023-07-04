<%@page contentType="text/html; charset=utf-8" %>
<html>
    <head>
        <title>確認

        </title>
    </head>
    <body>
        <p>名前:<strong><%= request.getParameter("name")%></strong></p>
        <p>パスワード:<strong><%= request.getParameter("pass")%></strong></p>
        <p>年齢:<strong><%= request.getAttribute("age")%></strong></p>
        <p>開発経験:<strong><%= request.getAttribute("langs")%></strong></p>
        <p>住所:<strong><%= request.getParameter("address") %></strong></p>
        <p>ご意見・お問い合わせ:<strong><%= request.getParameter("msg") %></strong></p>
        <input type="submit" value="送信" />
        <input type="reset" value="取消" />
        <p>この画面はJSPで出力しています</p>

    </body>