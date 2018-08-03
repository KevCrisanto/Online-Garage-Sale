package maverick.ogs.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;

import maverick.ogs.beans.Item;
import maverick.ogs.service.ItemService;

/**
 * Servlet implementation class GetItemsServlet
 */
public class GetItemsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logger logger = LoggerFactory.getLogger(GetItemsServlet.class.getName());
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetItemsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Gson gson = new Gson();

		List<Item> items = ItemService.getItemsForSale();
		String json = gson.toJson(items);
		out.println(json);
		
		logger.debug(GetItemsServlet.class.getName() + " is passing " + json.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
