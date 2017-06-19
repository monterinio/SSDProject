package pl.pwr.miki.services;

import static org.junit.Assert.assertFalse;

import java.io.InputStream;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.junit.Test;
import org.mockito.Mockito;
import pl.pwr.miki.DAO.ReportDetailDAO;

public class SubmitPaperServiceTest extends Mockito {
	public static final long OVER_MAX_SIZE = 1024 * 1024 * 50 + 1;
	public static final long MAX_SIZE = 1024 * 1024 * 50;
	public static final String NAME_OK_EXT = "FILE_NAME.pdf";
	public static final String PROPER_EXTENSION = "pdf";
	public static final String NAME_WRONG_EXT = "FILE_NAME.exe";
	public static final String NOT_PROPER_EXTENSION = "exe";

	@Test
	public void shouldNotAcceptToBigFile() throws Exception {
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		SubmitPaperService service = new SubmitPaperService();
		service.reportDetailDAO = mock(ReportDetailDAO.class);
		long checksum;

		when(request.getPart("report")).thenReturn(mock(Part.class));
		when(request.getPart("report").getSize()).thenReturn(OVER_MAX_SIZE);
		when(request.getPart("report").getSubmittedFileName()).thenReturn("FILE_NAME.PDF");
		when(request.getPart("report").getInputStream()).thenReturn(mock(InputStream.class));

		when(request.getRequestDispatcher("fileSizeExceeded.jsp")).thenReturn(mock(RequestDispatcher.class));
		when(request.getRequestDispatcher("invalidFormat.jsp")).thenReturn(mock(RequestDispatcher.class));

		service.doPost(request, response);
		checksum = service.getCheckSum();

		verify(service.reportDetailDAO, never()).addReportToDB(request, checksum);
	}

	@Test
	public void shouldAcceptFileWhenProperSizeAndExtension() throws Exception {
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		SubmitPaperService service = new SubmitPaperService();
		service.reportDetailDAO = mock(ReportDetailDAO.class);
		long checksum;

		when(request.getPart("report")).thenReturn(mock(Part.class));
		when(request.getPart("report").getSize()).thenReturn(MAX_SIZE);
		when(request.getPart("report").getSubmittedFileName()).thenReturn(NAME_OK_EXT);

		int beginIndex = NAME_OK_EXT.indexOf(".") + 1;

		when(request.getPart("report").getSubmittedFileName().substring(beginIndex)).thenReturn(PROPER_EXTENSION);
		when(request.getPart("report").getInputStream()).thenReturn(mock(InputStream.class));

		when(request.getRequestDispatcher("fileSizeExceeded.jsp")).thenReturn(mock(RequestDispatcher.class));
		when(request.getRequestDispatcher("invalidFormat.jsp")).thenReturn(mock(RequestDispatcher.class));
		service.doPost(request, response);
		checksum = service.getCheckSum();

		verify(service.reportDetailDAO, times(1)).addReportToDB(request, checksum);
	}

	@Test
	public void shouldNotAcceptFileWhenNotProperExtension() throws Exception {
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		SubmitPaperService service = new SubmitPaperService();
		service.reportDetailDAO = mock(ReportDetailDAO.class);
		long checksum;

		when(request.getPart("report")).thenReturn(mock(Part.class));
		when(request.getPart("report").getSize()).thenReturn(MAX_SIZE);
		when(request.getPart("report").getSubmittedFileName()).thenReturn(NAME_WRONG_EXT);

		int beginIndex = NAME_WRONG_EXT.indexOf(".") + 1;

		when(request.getPart("report").getSubmittedFileName().substring(beginIndex)).thenReturn(NOT_PROPER_EXTENSION);
		when(request.getPart("report").getInputStream()).thenReturn(mock(InputStream.class));

		when(request.getRequestDispatcher("fileSizeExceeded.jsp")).thenReturn(mock(RequestDispatcher.class));
		when(request.getRequestDispatcher("invalidFormat.jsp")).thenReturn(mock(RequestDispatcher.class));
		service.doPost(request, response);
		checksum = service.getCheckSum();

		verify(service.reportDetailDAO, never()).addReportToDB(request, checksum);
	}

	@Test
	public void shouldNotAcceptFileDuplicate() throws Exception {
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		SubmitPaperService service = new SubmitPaperService();
		service.reportDetailDAO = mock(ReportDetailDAO.class);
		long checksum;

		when(request.getPart("report")).thenReturn(mock(Part.class));
		when(request.getPart("report").getSize()).thenReturn(MAX_SIZE);
		when(request.getPart("report").getSubmittedFileName()).thenReturn(NAME_OK_EXT);

		int beginIndex = NAME_OK_EXT.indexOf(".") + 1;

		when(request.getPart("report").getSubmittedFileName().substring(beginIndex)).thenReturn(PROPER_EXTENSION);
		when(request.getPart("report").getInputStream()).thenReturn(mock(InputStream.class));

		when(request.getRequestDispatcher("fileSizeExceeded.jsp")).thenReturn(mock(RequestDispatcher.class));
		when(request.getRequestDispatcher("invalidFormat.jsp")).thenReturn(mock(RequestDispatcher.class));
		service.doPost(request, response);
		checksum = service.getCheckSum();

		verify(service.reportDetailDAO, times(1)).addReportToDB(request, checksum);

		service.doPost(request, response);
		checksum = service.getCheckSum();

		assertFalse(service.reportDetailDAO.addReportToDB(request, checksum));

	}

}
