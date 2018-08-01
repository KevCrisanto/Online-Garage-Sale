package maverick.ogs.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import maverick.ogs.beans.Transactions;
import maverick.ogs.dao.TransactionsDAO;
import maverick.ogs.dao.TransactionsDAOImpl;

public class TransactionsServlet extends HttpServlet {
	private static final long serialVerisionUUID = 1L;
	
	public TransactionsServlet() {
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		TransactionsDAO transactionsDAO = new TransactionsDAOImpl();
		List<Transactions> transactions = transactionsDAO.getAllTransactions();
		// Gson gson = new GsonBuilder().create();
		
		String json = new Gson().toJson(transactions);
		response.setContentType("application/json");
		response.getWriter().write(json);
	}
}
