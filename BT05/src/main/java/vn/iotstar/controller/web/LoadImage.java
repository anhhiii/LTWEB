package vn.iotstar.controller.web;

import java.io.File;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.iotstar.ultis.Constants;

@WebServlet("/image")
public class LoadImage extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LoadImage() {
        super();
    }

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String filename = req.getParameter("fname"); // lấy từ query param
        if (filename == null) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        File file = new File(Constants.DIR, filename);

        if (!file.exists()) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        resp.setContentType(getServletContext().getMimeType(filename));
        resp.setContentLength((int) file.length());

        java.nio.file.Files.copy(file.toPath(), resp.getOutputStream());
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
