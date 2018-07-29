package maverick.ogs.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.amazonaws.auth.EnvironmentVariableCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;

import maverick.ogs.service.FileService;

/**
 * Servlet implementation class UploadServlet
 */
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServlet() {
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
		ServletFileUpload sf = new ServletFileUpload(new DiskFileItemFactory());
		AmazonS3 s3client = AmazonS3ClientBuilder.standard()
				.withRegion("us-east-2")
                .withCredentials(new EnvironmentVariableCredentialsProvider())
                .build();
		String bucketname = "OGS-Bucket";
		s3client.createBucket(bucketname);
		response.setContentType("text");
		String itemid = "";
		try {
			List<FileItem> files = sf.parseRequest(request);
			for(FileItem item: files) {
				if (item.isFormField()) {
					String fieldname = item.getFieldName();
			        String fieldvalue = item.getString();
			        if(fieldname.equals("item_id")) {
			        	itemid = fieldvalue;
			        }

				}
				if(itemid != null && item.getName() != "null" && item.getName() != null) {
					
//					RFormService.setFileKeyRForm(iid, itemid+item.getName());
					FileService.createFile(itemid, itemid+item.getName());
					InputStream is = item.getInputStream();
					s3client.putObject(new PutObjectRequest(bucketname, itemid+item.getName(),is,new ObjectMetadata())
											.withCannedAcl(CannedAccessControlList.PublicRead));
					is.close();
				}

			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("user/emphome.html");
		rd.forward(request, response);
	}

}
