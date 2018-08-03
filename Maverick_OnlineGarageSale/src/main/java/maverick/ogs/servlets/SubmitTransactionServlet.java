package maverick.ogs.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.google.gson.Gson;

import maverick.ogs.beans.Item;
import maverick.ogs.service.TransactionsService;

/**
 * Servlet implementation class SubmitTransactionServlet
 */
public class SubmitTransactionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubmitTransactionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletFileUpload sf = new ServletFileUpload(new DiskFileItemFactory());
		String buyer = "";
		String seller = "";
		String item = "";
		System.out.println("======================");
		try {
			List<FileItem> files = sf.parseRequest(request);
			for(FileItem field: files) {
				if (field.isFormField()) {
					String fieldname = field.getFieldName();
			        String fieldvalue = field.getString();
			        if(fieldname.equals("buyer")) {
			    		buyer = fieldvalue;
			        }
			        if(fieldname.equals("seller")) {
			    		seller = fieldvalue;
			        }
			        if(fieldname.equals("item")) {
			    		item = fieldvalue;
			        }

				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(item);
		System.out.println(buyer);
		System.out.println(seller);

		TransactionsService.submitTransaction(buyer, seller, item);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
