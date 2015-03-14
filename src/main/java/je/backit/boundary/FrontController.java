package je.backit.boundary;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import je.backit.control.action.Action;
import je.backit.control.action.ActionFactory;

@WebServlet({ "/v1/*" })
public class FrontController extends HttpServlet {

  @Inject
  ActionFactory actionFactory;
  
  public FrontController() {
    super();
  }

  private void processRequest(HttpServletRequest request,
      HttpServletResponse response) throws ServletException {

    try {
      Action action = actionFactory.getAction(request);
      String view = action.execute(request, response);
      request.getRequestDispatcher(view).forward(request, response);
    } catch (Exception e) {
      throw new ServletException("Executing action failed.", e);
    }

  }

  /**
   * Delegate processing of GET/POST requests to the processRequest method.
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    processRequest(request, response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    processRequest(request, response);
  }

}
