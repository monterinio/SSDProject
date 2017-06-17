package pl.pwr.miki.services;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginService")
public class LoginService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginService() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.isUserInRole("scientific_worker")) {
			response.sendRedirect("/SSD/scientific_worker.jsp");
		}
		
		if(request.isUserInRole("reviewer")) {
			response.sendRedirect("/SSD/reviewer.jsp");
		}
		
		if(request.isUserInRole("comittee_member")) {
			response.sendRedirect("/SSD/committee_member.jsp");
		}

	}

}
