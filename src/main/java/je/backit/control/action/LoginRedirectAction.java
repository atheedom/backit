package je.backit.control.action;

import javax.annotation.ManagedBean;
import javax.enterprise.context.RequestScoped;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequestScoped
public class LoginRedirectAction implements Action {
  public String execute(HttpServletRequest request, HttpServletResponse response)
      throws Exception {
    
    // Obtain data from database
    
    
    return "/login.jsp";
  }

}