package je.backit.service;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import je.backit.entity.Account;
import je.backit.jooq.tables.records.AppUserRecord;

import org.jooq.DAO;

@RequestScoped
public class AccountService implements Service<Account, Integer> {

  @Inject
  DAO<AppUserRecord, Account, Integer> accountDAO;

  @Override
  public List<Account> getAll() {
    return accountDAO.findAll();
  }

  @Override
  public Account getDetails(Integer id) {
      return accountDAO.findById(id);
  }

}
