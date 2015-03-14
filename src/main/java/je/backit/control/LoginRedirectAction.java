package je.backit.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginRedirectAction implements Action {
  public String execute(HttpServletRequest request, HttpServletResponse response)
      throws Exception {
    
    // Obtain data from database
    
    
    return "/login.jsp";
  }

}