package maverick.ogs.servlets;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import maverick.ogs.beans.CreditCard;
import maverick.ogs.service.CreditCardService;

/**
 * Servlet implementation class CreditCardServlet
 */
public class CreditCardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logger logger = LoggerFactory.getLogger(CreditCardServlet.class.getName());
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreditCardServlet() {
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
		System.out.println(reader.readLine());
		
		CreditCard card = (CreditCard)gson.fromJson(reader, CreditCard.class);
		System.out.println(card.toString());
		
		if(CreditCardService.insertCreditCard(card) != null) {
			System.out.println("Credit card with id: " + card.getCardNumber());
		}
		else {
			System.out.println("card not inserted");
		}
	}
}
