package pl.pwr.miki.services;

import java.io.IOException;
import java.util.zip.Adler32;
import java.util.zip.Checksum;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import pl.pwr.miki.DAO.ReportDetailDAO;

@WebServlet("/SubmitPaperService")
@MultipartConfig
public class SubmitPaperService extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final long MAX_SIZE = 1024 * 1024 * 50;
	ReportDetailDAO reportDetailDAO;

	public SubmitPaperService() {
		super();
		reportDetailDAO = new ReportDetailDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Part filePart = request.getPart("report");
		checkFileSize(request, response);

		long checksum = calculateChecksum(filePart);
		if(reportDetailDAO.addReportToDB(request, checksum)) {
			response.sendRedirect("/SSD/paperAdded.jsp");
		} else {
			response.sendRedirect("/SSD/duplicateFound.jsp");
		}
	}
	
	private void checkFileSize(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Part filePart = request.getPart("report");
		if (filePart.getSize() > SubmitPaperService.MAX_SIZE) {
			request.getRequestDispatcher("fileSizeExceeded.jsp").forward(request, response);
		}
	}
	
	private long calculateChecksum(Part filePart) throws IOException {
		byte[] bytes = new byte [10000];
		filePart.getInputStream().read(bytes);
		Checksum checksumEngine = new Adler32();
		checksumEngine.update(bytes, 0, bytes.length);
		return checksumEngine.getValue();
	}

}
