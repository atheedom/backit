package je.backit.control;

import java.util.List;
import static java.util.stream.Collectors.toList;
import javax.inject.Inject;
import je.backit.entity.Account;
import je.backit.jooq.JooqProvider;
import static je.backit.jooq.Tables.APP_USER;
import je.backit.jooq.tables.records.AppUserRecord;
import je.backit.utils.Passwords;
import org.jooq.Record2;
import org.jooq.Result;
import org.jooq.exception.DataAccessException;

public class AccountDAO extends AbstractDAO<AppUserRecord, Account, Integer>{

  @Inject JooqProvider jooq;

  /**
   * Creates the account and sets its id based on the unique id returned by the DB
   * @param a an account to be created
   */
  public void create(Account a) {
    byte[] salt = Passwords.getNextSalt();
    byte[] pass = Passwords.hash(a.getPassword().toCharArray(), salt);
    AppUserRecord u = new AppUserRecord()
            .setEmail(a.getEmail())
            .setFirstName(a.getFirstname())
            .setLastName(a.getLastname())
            .setUsername(a.getUsername())
            .setPassword(pass)
            .setSalt(salt);
    insertInto(jooq.sql(), APP_USER, u);
    a.setId(u.getId());
  }

  public boolean authenticate(String username, String password) {
    Record2<byte[], byte[]> userInDb = jooq.sql().select(APP_USER.PASSWORD, APP_USER.SALT).from(APP_USER).fetchOne();
    if (userInDb == null) return false;
    byte[] expectedHash = userInDb.getValue(APP_USER.PASSWORD);
    byte[] salt = userInDb.getValue(APP_USER.SALT);
    return Passwords.isExpectedPassword(password.toCharArray(), salt, expectedHash);
  }

  public Account findById(Integer id) {
    AppUserRecord user = jooq.sql().selectFrom(APP_USER).where(APP_USER.ID.eq(id)).fetchOne();
    if (user == null) return null;
    else return mapRecord(user);
  }

  public Account findByUsername(String username) {
    AppUserRecord user = jooq.sql().selectFrom(APP_USER).where(APP_USER.USERNAME.eq(username)).fetchOne();
    if (user == null) return null;
    else return mapRecord(user);
  }


  private static Account mapRecord(AppUserRecord user) {
    Account a = new Account();
    a.setEmail(user.getEmail());
    a.setFirstname(user.getFirstName());
    a.setId(user.getId());
    a.setLastname(user.getLastName());
    a.setUsername(user.getUsername());
    return a;
  }

  @Override
  public List<Account> findAll() throws DataAccessException {
    Result<AppUserRecord> fetch = jooq.sql().selectFrom(APP_USER).fetch();
    return fetch.stream().map(AccountDAO::mapRecord).collect(toList());
  }

}
