package maverick.ogs.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import maverick.ogs.beans.UserAccount;
import maverick.ogs.dao.UserAccountDAOImpl;
import maverick.ogs.service.UserService;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Gson gson = new Gson();
		BufferedReader reader = request.getReader();
		UserAccount userAccount = (UserAccount)gson.fromJson(reader, UserAccount.class);
		userAccount.setUserId(UUID.randomUUID().toString());
		System.out.println(userAccount.toString());

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		UserAccount validUser = null;	
		String id = null;
		
		if((id = UserService.insertNewUserAccount(userAccount)) != null) {
			validUser = UserService.getUserById(id);
			out.println(gson.toJson(validUser));
			System.out.println("New user with username: " + userAccount.getUsername() + " created");
		}
		else {
			System.out.println("registration failed");
		}
	}

}
