package maverick.ogs.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import maverick.ogs.service.TransactionsService;

/**
 * Servlet implementation class UpdateRatingServlet
 */
public class UpdateRatingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateRatingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletFileUpload sf = new ServletFileUpload(new DiskFileItemFactory());
		String transid = "";
		int rating = 0;
		try {
			List<FileItem> files = sf.parseRequest(request);
			for(FileItem field: files) {
				if (field.isFormField()) {
					String fieldname = field.getFieldName();
			        String fieldvalue = field.getString();
			        if(fieldname.equals("transid")) {
			    		transid = fieldvalue;
			        }
			        if(fieldname.equals("rating")) {
			    		rating = Integer.parseInt(fieldvalue);
			        }

				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		TransactionsService.updateTransactionRating(transid, rating);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
