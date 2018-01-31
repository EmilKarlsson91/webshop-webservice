package com.awesome.emk.webservice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.awesome.emk.apiclasses.ArticleDTO;
import com.awesome.emk.apiclasses.OrderDTO;
import com.awesome.emk.apiclasses.UserDTO;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
public class ApplicationController {
	
	private static Logger log = LoggerFactory.getLogger(WebserviceApplication.class);

	private String message = "Hello World";

	
	@Autowired
	private ApplicationService applicationService;
	
	@RequestMapping("/")
	public String index(Map<String, Object> model) {
		model.put("message", this.message);
		return "home";
	}
	
	@RequestMapping(value= {"/admin"}, method = RequestMethod.GET)
	public String getAllArticles(Model model){
		model.addAttribute("list", applicationService.getAllArticles());
		return "hello-admin";
	}
	
	@RequestMapping(value="/register/order/{username}")
	public void registerOrder(@RequestBody ArticleDTO[] articles, @PathVariable String username) {
		applicationService.registerOrder(articles, username);
	}
	
	@RequestMapping(value="/orders", method = RequestMethod.GET)
	public List<OrderDTO> getAllOrders(){
		return applicationService.getAllOrders();
	}
	
	@RequestMapping(value="/orders/{username}", method = RequestMethod.GET)
	public List<OrderDTO> getOrderByUsername(@PathVariable String username){
		return applicationService.getOrderByUsername(username);
	}
	
	@RequestMapping(value="/articles", method = RequestMethod.GET)
	public List<ArticleDTO> getAllArticles(){		
		return applicationService.getAllArticles();
	}
	
	@RequestMapping(value="/user/{username}", method = RequestMethod.GET)
	public UserDTO getUser(@PathVariable String username) {
		return applicationService.getUser(username);
	}
	
	@RequestMapping(value="/users", method = RequestMethod.GET)
	public List<UserDTO> getAllUsers(){
		return applicationService.getAllUsers();
	}
	
	@RequestMapping(value="/delete/{username}", method = RequestMethod.DELETE)
	public void deleteUser(@PathVariable String username){
		applicationService.deleteUser(username);
	}
	
	@RequestMapping(value="/register/user", method = RequestMethod.POST)
	public void registerUser(@RequestBody UserDTO input){
		applicationService.registerUser(input);
	}
	
	@RequestMapping(value="/edit/user/{username}", method = RequestMethod.PUT)
	public void editUser(@RequestBody UserDTO input, @PathVariable String username) {
		applicationService.editUser(input, username);
	}
	
	@RequestMapping(value="/single", method = RequestMethod.GET)
	public ArticleDTO getSingle() {
		return new ArticleDTO();
	}
}
