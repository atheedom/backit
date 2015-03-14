package je.backit.control;

public class AbstractActionFactory {
  private final static ActionFactory instance = new ActionFactory();

  private AbstractActionFactory() {
  }

  public static ActionFactory getInstance() {
    return instance;
  }
}
