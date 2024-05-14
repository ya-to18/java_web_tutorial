package forms;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ConfirmServlet extends HttpServlet {
    // POSTメソッドのリクエスト受信時に実行されるメソッド
    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    	
    	request.setCharacterEncoding("UTF-8");
    	response.setContentType("text/html; charset=UTF-8");
    	
    	String name = request.getParameter("user_name");
    	String email = request.getParameter("user_email");
    	String message = request.getParameter("message");
    	
    	request.setAttribute("name", name);
    	request.setAttribute("email", email);
    	request.setAttribute("message", message);
    	
    	name = Objects.toString(name, "");
    	email = Objects.toString(email, "");
    	message = Objects.toString(message, "");
    	
    	ArrayList<String> errorList = new ArrayList<String>();
    	
    	if( "".equals( name.trim() ) ) {
    		errorList.add("お名前を入力してください。");
    	}
    	
    	if( "".equals(email.trim()) ) {
    		errorList.add("メールアドレスを入力してください。");
    	} else if( !email.matches("^[a-zA-Z0-9.]+@[a-zA-Z0-9.]+$") ) {
    		errorList.add("メールアドレスの入力形式が正しくありません。");
    	}
    	
    	if( "".equals(message.trim()) ) {
    		errorList.add("お問い合わせ内容を入力してください。");
    	} else if( message.length() > 100 ) {
    		errorList.add("お問い合わせ内容が100文字を超えています。");
    	}
    	
    	if( !errorList.isEmpty() ) {
    		request.setAttribute("errorList", errorList);
    	}
    	
    	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/pages/confirmPage.jsp");
    	dispatcher.forward(request, response);
    }
}
