package maverick.ogs.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;

import maverick.ogs.beans.UserAccount;
import maverick.ogs.service.UserService;

/**
 * Servlet implementation class GetUserServlet
 */
public class GetUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logger logger = LoggerFactory.getLogger(GetUserServlet.class.getName());
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Gson gson = new Gson();
		BufferedReader reader = request.getReader();
		UserAccount user = UserService.getUserById(reader.readLine());
		System.out.println(user.toString());
		PrintWriter out = response.getWriter();
		out.println(gson.toJson(user));
		logger.debug(GetUserServlet.class.getName() + " is passing " + gson.toJson(user).toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
