package je.backit.control;

import java.util.HashMap;
import java.util.Map;
import je.backit.boundary.*;

import javax.servlet.http.HttpServletRequest;

public class ActionFactory {

  private Map<String, Action> actions = new HashMap<String, Action>();
  private Action action;

  public ActionFactory() {
    actions.put("GET/campaigns/list/", new CampaignListAction());
    actions.put("LoginRedirect", new LoginRedirectAction());

    
    
  }

  public synchronized Action getAction(HttpServletRequest request)
      throws ActionFactoryException {
    String path = request.getPathInfo();
    if (path != null || path.length() > 0) {
      String actionKey = request.getMethod() + path;
      action = actions.get(actionKey);
      if (action == null) {
        action = actions.get("LoginRedirect");
      }
    } else {
      throw new ActionFactoryException();
    }

    return action;
  }
}
