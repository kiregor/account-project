package rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import Service.AccountService;

@Path("/account")
public class AccountEndpoint {
	@Inject
	private AccountService serv;
	
	public void setService(AccountService service) {
		serv = service;
	}
	
	@Path("/addAccount")
	@POST
	@Produces({"application/json"})
	public String addAccount(String account) {
		return serv.addAccount(account);
	}
	
	@Path("/getAccount/{id}")
	@GET
	@Produces({"application/json"})
	public String getAccount(@PathParam("id") Integer id) {
		return serv.getAccount(id);
	}
}
