package je.backit.control.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CampaignBackingAction implements Action {
  public String execute(HttpServletRequest request, HttpServletResponse response)
      throws Exception {
        
    
    return "GetBacking";
  }

}
