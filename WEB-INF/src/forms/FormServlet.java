package forms;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormServlet extends HttpServlet {
    // GETメソッドのリクエスト受信時に実行されるメソッド
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    	
    	Cookie[] userCookies = request.getCookies();
    	
    	if( userCookies != null) {
    		for( Cookie cookie : userCookies ) {
    			switch( cookie.getName() ) {
    				case "name":
    					request.setAttribute("userName", cookie.getValue());
    					break;
    				case "email":
    					request.setAttribute("userEmail", cookie.getValue());
    					break;
    				default:
    					break;
    			}
    		}
    	}
    	
    	// フォワードによる画面遷移
    	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/pages/formPage.jsp");
    	dispatcher.forward(request, response);
    }
}
