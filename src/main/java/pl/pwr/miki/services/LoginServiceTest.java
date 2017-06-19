package pl.pwr.miki.services;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.mockito.Mockito;


public class LoginServiceTest extends Mockito {

	 @Test
	    public void shouldRedirectToWorkerPanelWhenUserIsScientificWorker() throws Exception {
	        HttpServletRequest request = mock(HttpServletRequest.class);       
	        HttpServletResponse response = mock(HttpServletResponse.class);    

	        when(request.isUserInRole("scientific_worker")).thenReturn(true);

	        new LoginService().doGet(request, response);

	        verify(response, times(1)).sendRedirect("/SSD/scientific_worker.jsp"); 
	    }
	 
	 @Test
	    public void shouldRedirectToReviewerPanelWhenUserIsReviewer() throws Exception {
	        HttpServletRequest request = mock(HttpServletRequest.class);       
	        HttpServletResponse response = mock(HttpServletResponse.class);    

	        when(request.isUserInRole("reviewer")).thenReturn(true);

	        new LoginService().doGet(request, response);

	        verify(response, times(1)).sendRedirect("/SSD/GetPapersService"); 
	    }
	 
	 @Test
	    public void shouldRedirectToCommiteMemberPanelWhenUserIsCommiteeMember() throws Exception {
	        HttpServletRequest request = mock(HttpServletRequest.class);       
	        HttpServletResponse response = mock(HttpServletResponse.class);    

	        when(request.isUserInRole("comittee_member")).thenReturn(true);

	        new LoginService().doGet(request, response);

	        verify(response, times(1)).sendRedirect("/SSD/committee_member.jsp"); 
	    }

}
