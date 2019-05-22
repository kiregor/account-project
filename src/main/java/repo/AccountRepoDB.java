package repo;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import domain.Account;
import util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class AccountRepoDB implements AccountRepo{
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	
	@Inject
	private JSONUtil util;
	
	@Override
	public String getAllAccounts() {
		TypedQuery<Account> query = manager.createQuery("Select a FROM Account a", Account.class);
		Collection<Account> accounts = query.getResultList();
		return util.toJSON(accounts);
	}

	@Override
	@Transactional(REQUIRED)
	public String addAccount(String account) {
		Account newAccount = util.fromJSON(account, Account.class);
		manager.persist(newAccount);
		return "{\"message\": \"The account has been successfully added\"}";
	}

	@Override
	public Account getAccount(int id) {
		return manager.find(Account.class, id);
	}

	@Override
	@Transactional(REQUIRED)
	public String deleteAccount(int id) {
		if(manager.contains(manager.find(Account.class, id))) {
			manager.remove(manager.find(Account.class, id));
		}
		return "{\"message\": \"The account has been successfully deleted\"}";
	}

	@Override
	@Transactional(REQUIRED)
	public Account updateAccount(Account account) {
		Account existingAccount = manager.find(Account.class, account.getAccountNumber());
		return existingAccount.updateAccount(account) ? existingAccount : new Account();
	}
	
	public void setManager(EntityManager manager) {
		this.manager = manager;
	}
	
	public void setUtil(JSONUtil util) {
		this.util = util;
	}
}
