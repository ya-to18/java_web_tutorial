<%@ page contentType="text/html; charset=UTF-8" %>

<html>
	<head>
		<title>Servlet/JSPの基礎を学ぼう</title>
	</head>
	<body>
		<h2>お問い合わせ</h2>
		<form action="<%= request.getContextPath() %>/confirm" method="post">
			<table>
				<tr>
					<td>お名前</td>
					<td>
						<input type="text" name="user_name">
					</td>
				</tr>
				<tr>
					<td>メールアドレス</td>
					<td>
						<input type="text" name="user_email">
					</td>
				</tr>
				<tr>
					<td>お問い合わせ内容</td>
					<td>
						<%-- cols属性=入力欄の幅（文字数）、rows属性＝入力欄の高さ（行数） --%>
						<textarea name="message" rows="10" cols="30"></textarea>
					</td>
				</tr>
			</table>
				<input type="submit" value="送信">
		</form>
	</body>
</html>