package maverick.ogs.servlets;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import maverick.ogs.beans.UserAccount;
import maverick.ogs.dao.UserAccountDAOImpl;
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
		//System.out.println(user.getUsername());
//      JsonParser parser = new JsonParser();
//		JsonObject obj = (JsonObject) parser.parse(request.getReader());
//		System.out.println(obj.get("key1"));
//		System.out.println(obj.toString());
		//PrintWriter out = response.getWriter();
//		BufferedReader reader = request.getReader();
//		Gson gson = new GsonBuilder().create();
//		User user = gson.fromJson(reader,UserAccount.class);
//		JsonParser parser = new JsonParser();
//		JsonObject jsonuser = parser.getAs
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		//System.out.println(UserService.userLogin("sadsa", "wdwda"));
		//HttpSession session = null;
//		if(UserService.userLogin(user.getUsername(), user.getPassword())){
		UserAccountDAOImpl a = new UserAccountDAOImpl();
		System.out.println(a.getAccountByUsername("kkay"));

//		if(UserService.userLogin("kkay","password")) {
			//session = request.getSession();
//			session.setAttribute("username", username);
//			session.setAttribute("password", password);
//			session.setAttribute("employee", EmployeeService.getEmp(username, password));
			//RequestDispatcher rd = request.getRequestDispatcher("user/emphome.html");
			//rd.forward(request, response);
			//System.out.println("logged in");
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
