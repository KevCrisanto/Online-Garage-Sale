package maverick.ogs.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import maverick.ogs.beans.UserAccount;
import maverick.ogs.service.UserService;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//response.setContentType("text/html");
		Gson gson = new GsonBuilder().create();
		BufferedReader reader = request.getReader();
		UserAccount user = gson.fromJson(reader,UserAccount.class);

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
//		Cookie[] cookies = request.getCookies();
//		boolean exists = false;
//		if (cookies != null) {
//			for(Cookie c: cookies) {
//				if(c.getName().equals("userjson")) exists = true;
//				System.out.println("1");
//			}
//		}
		
		if((user = UserService.userLogin(user.getUsername(),user.getPassword())) != null) {

//			if(!exists) {
//				Cookie cookie = new Cookie("userjson", user.getAccountId());
//				System.out.println("2");
//				response.addCookie(cookie);
//			}else {
//				for(Cookie c: cookies) {
//					if(c.getName().equals("userjson")) {
//						c.setValue(user.getAccountId());
//						System.out.println("3");
//					}
//
//				}
//			}
			out.println(gson.toJson(user));
			
		}
		//testing git webhook again
//		else {
//			request.getRequestDispatcher("index.html").include(request, response);
//			out.println("<script>document.getElementById('invalidpass')"
//					+ ".innerHTML='Invalid username or password'; </script>");
//		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
