package pl.pwr.miki.services;

import java.io.IOException;
import java.nio.file.Paths;
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
	private Part filePart;
	private String fileFormat;
	private long checksum;
	ReportDetailDAO reportDetailDAO;

	public SubmitPaperService() {
		super();
		reportDetailDAO = new ReportDetailDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		getFileParameters(request);
		
		if (filePart.getSize() > SubmitPaperService.MAX_SIZE) {
			request.getRequestDispatcher("fileSizeExceeded.jsp").forward(request, response);
			return;
		}

		if (!(fileFormat.equals("doc") || fileFormat.equals("docx") || fileFormat.equals("odt")
				|| fileFormat.equals("pdf"))) {
			request.getRequestDispatcher("invalidFormat.jsp").forward(request, response);
			return;
		}

		if (reportDetailDAO.addReportToDB(request, checksum)) {
			response.sendRedirect("/SSD/paperAdded.jsp");
		} else {
			response.sendRedirect("/SSD/duplicateFound.jsp");
		}
	}

	private void getFileParameters(HttpServletRequest request) throws IOException, ServletException {
		filePart = request.getPart("report");
		fileFormat = getFileFormat();
		checksum = calculateChecksum(filePart);
	}

	private String getFileFormat() {
		String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
		int beginIndex = fileName.indexOf(".") + 1;
		String fileFormat = fileName.substring(beginIndex);
		return fileFormat;
	}

	private long calculateChecksum(Part filePart) throws IOException {
		byte[] bytes = new byte[(int) filePart.getSize()]; // changed
		filePart.getInputStream().read(bytes);
		Checksum checksumEngine = new Adler32();
		checksumEngine.update(bytes, 0, bytes.length);
		return checksumEngine.getValue();
	}
}
