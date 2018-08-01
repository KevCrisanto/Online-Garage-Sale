package maverick.ogs.servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import maverick.ogs.dao.TransactionsDAO;
import maverick.ogs.dao.TransactionsDAOImpl;

public class TransactionsServlet extends HttpServlet {
	private static final long serialVerisionUUID = 1L;
	
	public TransactionsServlet() {
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse respone) {
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		TransactionsDAO transactionsDAO = new TransactionsDAOImpl();
		
	}
}
