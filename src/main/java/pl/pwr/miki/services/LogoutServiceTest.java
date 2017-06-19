package pl.pwr.miki.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.Test;
import org.mockito.Mockito;

public class LogoutServiceTest extends Mockito {

	 @Test
	    public void shouldCallLogout() throws Exception {
	        HttpServletRequest request = mock(HttpServletRequest.class);       
	        HttpServletResponse response = mock(HttpServletResponse.class);    

	        new LogoutService().doGet(request, response);

	        verify(request, times(1)).logout();
	    }
	 
	 @Test
	    public void shouldRedirectToMainPage() throws Exception {
	        HttpServletRequest request = mock(HttpServletRequest.class);       
	        HttpServletResponse response = mock(HttpServletResponse.class);    

	        new LogoutService().doGet(request, response);

	        verify(response, times(1)).sendRedirect("/SSD/index.jsp"); 
	    }
	 
}