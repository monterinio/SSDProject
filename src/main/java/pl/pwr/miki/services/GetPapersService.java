package pl.pwr.miki.services;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pl.pwr.miki.DAO.ReportDetailDAO;
import pl.pwr.miki.model.ReportModel;

@WebServlet("/GetPapersService")
public class GetPapersService extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReportDetailDAO reportDetailDAO;
    private List<ReportModel> reportModelList;
	
    public GetPapersService() {
        super();
        reportDetailDAO = new ReportDetailDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	reportModelList = reportDetailDAO.getReportsFromDB();
    	HttpSession session = request.getSession();
    	session.setAttribute("reportModelList", reportModelList);
    	request.getRequestDispatcher("reviewer.jsp").forward(request, response);
    }

}
