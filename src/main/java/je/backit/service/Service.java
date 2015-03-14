package je.backit.service;

import java.math.BigDecimal;
import java.util.List;

public interface Service<T, I> {

  public List<T> getAll();

  public T getDetails(I I);

}
