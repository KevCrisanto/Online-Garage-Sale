package maverick.ogs.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import maverick.ogs.beans.UserAccount;
import maverick.ogs.service.UserService;

/**
 * Servlet implementation class UpdateUser
 */
public class UpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUser() {
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
		String id = userAccount.getAccountId();
		System.out.println(userAccount.toString());
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		UserAccount validUser = null;	
		
		if(UserService.updateUserById(id, userAccount)) {
			validUser = UserService.getUserById(id);
			out.println(gson.toJson(validUser));
			System.out.println("Updated user with username: " + userAccount.getUsername());
		}
		else {
			System.out.println("Updated failed");
		}
	}

}
