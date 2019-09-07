package main;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class File_Load_Servlet
 */

public class File_Load_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Inside upload");
		ServletFileUpload sf =new ServletFileUpload(new DiskFileItemFactory());
		
		try {
			PrintWriter out=response.getWriter();
			out.println("Inside try");
			List<FileItem> file1= sf.parseRequest(request);
			
			for(FileItem item: file1) {
				item.getInputStream();
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
	}

}