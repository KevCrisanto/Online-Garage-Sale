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

import maverick.ogs.beans.Address;
import maverick.ogs.beans.UserAccount;
import maverick.ogs.service.AddressService;
import maverick.ogs.service.UserService;

/**
 * Servlet implementation class AddressServlet
 */
public class AddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddressServlet() {
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
		Address address = (Address)gson.fromJson(reader, Address.class);
		System.out.println(address.toString());
				
		if(address.getAddressId() == null) {
			address.setAddressId(UUID.randomUUID().toString());
			System.out.println("before insert" + address.toString());
			AddressService.insertNewAddress(address);
		}
	
	}

}
