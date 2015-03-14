package je.backit.control;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.jooq.Configuration;
import org.jooq.DAO;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.RecordMapper;
import org.jooq.SQLDialect;
import org.jooq.Table;
import org.jooq.TableRecord;
import org.jooq.UpdatableRecord;
import org.jooq.conf.Settings;
import org.jooq.exception.DataAccessException;

public abstract class AbstractDAO<R extends TableRecord<R>, T, I> implements DAO<R, T, Integer> {

  <R extends UpdatableRecord<R>> void insertIntoNoReturn(DSLContext sql, Table<R> t, R record) {
    if (Arrays.stream(record.fields()).filter(f -> record.getValue(f) != null).count() == 0) {
      throw new IllegalStateException("The record has all its fields set to null: can't be inserted.");
    }

    for (Field<?> f : record.fields()) {
      if (record.getValue(f) == null) record.changed(f, false);
    }
    sql.attach(record);
    record.store();
  }

  <R extends UpdatableRecord<R>> long insertInto(DSLContext sql, Table<R> t, R record) {
    insertIntoNoReturn(sql, t, record);
    return record.getValue(record.getTable().getIdentity().getField()).longValue();
  }

  @Override
  public Configuration configuration() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Settings settings() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public SQLDialect dialect() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public SQLDialect family() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public RecordMapper<R, T> mapper() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void insert(T object) throws DataAccessException {
    // TODO Auto-generated method stub

  }

  @Override @SuppressWarnings("unchecked")
  public void insert(T... objects) throws DataAccessException {
    // TODO Auto-generated method stub

  }

  @Override
  public void insert(Collection<T> objects) throws DataAccessException {
    // TODO Auto-generated method stub

  }

  @Override
  public void update(T object) throws DataAccessException {
    // TODO Auto-generated method stub

  }

  @Override @SuppressWarnings("unchecked")
  public void update(T... objects) throws DataAccessException {
    // TODO Auto-generated method stub

  }

  @Override
  public void update(Collection<T> objects) throws DataAccessException {
    // TODO Auto-generated method stub

  }

  @Override @SuppressWarnings("unchecked")
  public void delete(T... objects) throws DataAccessException {
    // TODO Auto-generated method stub

  }

  @Override
  public void delete(Collection<T> objects) throws DataAccessException {
    // TODO Auto-generated method stub

  }

  @Override @SuppressWarnings("unchecked")
  public void deleteById(Integer... ids) throws DataAccessException {
    // TODO Auto-generated method stub

  }

  @Override
  public void deleteById(Collection<Integer> ids) throws DataAccessException {
    // TODO Auto-generated method stub

  }

  @Override
  public boolean exists(T object) throws DataAccessException {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean existsById(Integer id) throws DataAccessException {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public long count() throws DataAccessException {
    // TODO Auto-generated method stub
    return 0;
  }


  @Override
  public T findById(Integer id) throws DataAccessException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override @SuppressWarnings("unchecked")
  public <Z> List<T> fetch(Field<Z> field, Z... values)
      throws DataAccessException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public <Z> T fetchOne(Field<Z> field, Z value) throws DataAccessException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Table<R> getTable() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Class<T> getType() {
    // TODO Auto-generated method stub
    return null;
  }

}
