package Service;

import javax.enterprise.inject.Default;
import javax.inject.Inject;

import domain.Account;
import repo.AccountRepo;
import util.JSONUtil;

@Default
public class AccountService {

	@Inject
	JSONUtil json;

	@Inject
	private AccountRepo repo;

	public AccountService() {

	}

	private static AccountService serv = new AccountService();

	public static AccountService getInstance() {
		return serv;
	}

	public String addAccount(String accountJSON) {
		return this.repo.addAccount(accountJSON);
	}

	public String getAccount(Integer id) {
		return json.toJSON(this.repo.getAccount(id));
	}
	
	public String getAllAccounts() {
		return json.toJSON(this.repo.getAllAccounts());
	}
	
	public String updateAccount(String account) {
		return json.toJSON(this.repo.updateAccount(json.fromJSON(account, Account.class)));
	}
	
	public String deleteAccount(int id) {
		return this.repo.deleteAccount(id);
	}

	public void setJson(JSONUtil json) {
		this.json = json;
	}

	public void setRepo(AccountRepo repo) {
		this.repo = repo;
	}

}
