package je.backit.service;

import java.util.List;

public interface Service<T, I> {

  public List<T> getAll();

  public T getDetails(I I);
  
  public T persist(T T);

}
