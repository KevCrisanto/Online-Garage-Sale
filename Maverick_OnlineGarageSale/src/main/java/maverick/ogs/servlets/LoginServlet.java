package maverick.ogs.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

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

//		response.setContentType("text/html");
//		PrintWriter out = response.getWriter();
//		BufferedReader reader = request.getReader();
//		Gson gson = new GsonBuilder().create();
//		User user = gson.fromJson(reader,UserAccount.class);
//		JsonParser parser = new JsonParser();
//		JsonObject jsonuser = parser.getAs
//		
//		HttpSession session = null;
//		if(UserService.userLogin(username, password)){
//
//			session = request.getSession();
//			session.setAttribute("username", username);
//			session.setAttribute("password", password);
//			session.setAttribute("employee", EmployeeService.getEmp(username, password));
//			RequestDispatcher rd = request.getRequestDispatcher("user/emphome.html");
//			rd.forward(request, response);
//		}
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
