package je.backit.control.action;

import java.util.HashMap;
import java.util.Map;

import je.backit.boundary.*;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

@RequestScoped
public class ActionFactory {

  private Map<String, Action> actions = new HashMap<String, Action>();
  private Action action;

  @Inject
  private CampaignListAction campaignListAction;
  
  @Inject
  private CampaignDetailAction campaignDetailAction;

  @Inject
  private CampaignFundAction campaignFundAction;

  @Inject
  private CampaignBackAction campaignBackAction;
  
  @Inject
  private LoginRedirectAction loginRedirectAction;
  

  @PostConstruct
  public void populateActions() {
    actions.put("GET/campaigns/list/", campaignListAction);
    actions.put("GET/campaigns/details/", campaignDetailAction);
    actions.put("GET/campaigns/details", campaignDetailAction);
    actions.put("GET/campaigns/fund/", campaignFundAction);
    actions.put("POST/campaigns/back/", campaignBackAction);
    actions.put("LoginRedirect", loginRedirectAction);
  }

  public synchronized Action getAction(HttpServletRequest request)
      throws ActionFactoryException {
    String path = request.getPathInfo();
    String campaignid = request.getParameter("campaignId");
    Map<String, String[]> campignid = request.getParameterMap();

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
