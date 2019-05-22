package Service;

import javax.inject.Inject;

import com.google.gson.Gson;

import domain.Account;
import repo.AccountRepo;
import repo.AccountRepoMap;
import util.JSONUtil;

public class AccountService {
	
	@Inject
	JSONUtil json;
	
	@Inject
	private AccountRepo repo;
	
	private AccountService() {
		
	}
	
	private static AccountService serv = new AccountService();
	
	public static AccountService getInstance() {
		return serv;
	}
	
	public String addAccount(String accountJSON) {
		return this.repo.addAccount(accountJSON);
	}
	
	public void setJson(JSONUtil json) {
		this.json = json;
	}
	
	public void setRepo(AccountRepo repo) {
		this.repo = repo;
	}
}
