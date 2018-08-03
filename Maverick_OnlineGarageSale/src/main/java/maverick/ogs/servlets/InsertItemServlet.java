package maverick.ogs.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amazonaws.auth.EnvironmentVariableCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.google.gson.Gson;

import maverick.ogs.beans.Item;
import maverick.ogs.service.ItemService;

/**
 * Servlet implementation class InsertItemServlet
 */
public class InsertItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logger logger = LoggerFactory.getLogger(InsertItemServlet.class.getName());
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletFileUpload sf = new ServletFileUpload(new DiskFileItemFactory());
		AmazonS3 s3client = AmazonS3ClientBuilder.standard()
				.withRegion("us-east-2")
                .withCredentials(new EnvironmentVariableCredentialsProvider())
                .build();
		String bucketname = "ogs-bucket";
		//s3client.createBucket(bucketname);
		response.setContentType("text");
		String fileKey = UUID.randomUUID().toString();
		Item jsonItem = null;
		try {
			List<FileItem> files = sf.parseRequest(request);
			for(FileItem item: files) {
				if (item.isFormField()) {
					String fieldname = item.getFieldName();
			        String fieldvalue = item.getString();
			        if(fieldname.equals("subItem")) {
			    		Gson gson = new Gson();
			    		jsonItem = gson.fromJson(fieldvalue,Item.class);
			        }
				}
				else if(item.getName() != "null" && item.getName() != null) {
					fileKey = fileKey+item.getName()+".png";
					System.out.println(fileKey);
					InputStream is = item.getInputStream();
					s3client.putObject(new PutObjectRequest(bucketname, fileKey,is,new ObjectMetadata())
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
		ItemService.insertNewItem(jsonItem,fileKey);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
