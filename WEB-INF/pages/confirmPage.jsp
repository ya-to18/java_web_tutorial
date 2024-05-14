<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.ArrayList" %>

<html>
	<head>
		<title>Servle/JSPの基礎を学ぼう</title>
	</head>
	<body>
		<h2>入力内容をご確認ください。</h2>
		<p>問題なければ「確定」、修正する場合は「キャンセル」をクリックしてください。</p>
		<table border="1">
			<tr>
				<th>項目</th>
				<th>入力内容</th>
			</tr>
			<tr>
				<td>お名前</td>
				<td>${name}</td>
			</tr>
			<tr>
				<td>メールアドレス</td>
				<td>${email}</td>
			</tr>
			<tr>
				<td>お問い合わせ内容</td>
				<td>${message}</td>
			</tr>
		</table>
		
		<%
		ArrayList<String> errorList = (ArrayList<String>) request.getAttribute("errorList");
		
		String disableConfirm = (errorList != null) ? "disabled" : "";
		%>
		
		<p>
			<%-- 確定ボタン（登録に成功した前提で完了画面に遷移） --%>
			<button
				onclick="location.href='<%= request.getContextPath() %>/complete';"
				<%= disableConfirm %>
			>確定</button>
			
			<%-- キャンセルボタン（前の画面に戻る） --%>
			<button onclick="history.back();">キャンセル</button>
		</p>
		
		<%
		if( errorList != null ){
			for( String errorMessage : errorList ){
				out.println("<font color=\"red\">" + errorMessage + "</font><br>");
			}
		}
		%>
	</body>
</html>