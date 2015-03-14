package je.backit.boundary;

import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import je.backit.control.AccountDAO;
import je.backit.entity.Account;


@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

  @Inject AccountDAO accountDAO;

	public LoginController() {
		super();
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		RequestDispatcher rd = null;

		if (accountDAO.authenticate(username, password)) {
			rd = request.getRequestDispatcher("/success.jsp");
			Account user = accountDAO.findByUsername(username);
			request.setAttribute("user", user);
		} else {
			rd = request.getRequestDispatcher("/error.jsp");
		}
		rd.forward(request, response);
	}

}