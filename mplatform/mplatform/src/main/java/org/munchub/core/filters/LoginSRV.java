package org.munchub.core.filters;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginSRV extends HttpServlet{

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestData = null;
		StringBuffer jb = new StringBuffer();
		try
		{
			BufferedReader reader = request.getReader();
			int charRead = 0;
			char[] buffer = new char[1024 * 8];
			StringBuffer stringBuffer = new StringBuffer();
			while ((charRead = reader.read(buffer)) > 0)
			{
				jb.append(buffer, 0, charRead);
			}
		}
		catch (Exception e)
		{
			response.setStatus(400);
			e.printStackTrace();
		}
		requestData = jb.toString();      
		String responseData = "{\"userName\":\"Ankur\"}";
		
		response.setContentType("application/json");
		response.addHeader("Pragma", "no-cache");
		response.addHeader("Cache-Control", "no-cache, no-store");

		OutputStream out = null;
		try
		{  
			String ae = request.getHeader("accept-encoding");
			if (ae != null && ae.indexOf("gzip") != -1) 
			{
				response.addHeader("Content-Encoding","gzip");
				out = new java.util.zip.GZIPOutputStream(response.getOutputStream());
			}
			else
			{
				out = response.getOutputStream();
			}

			out.write(responseData.getBytes());
		}
		catch (Exception e)
		{
			//Magic lamp issue : ServletResponseCommit3 fix
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
		finally
		{
			if (null != out)
			{
				out.close();
			}
		}

	}

}
