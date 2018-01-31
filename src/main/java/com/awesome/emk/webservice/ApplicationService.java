package com.awesome.emk.webservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import com.awesome.emk.apiclasses.ArticleDTO;
import com.awesome.emk.apiclasses.OrderDTO;
import com.awesome.emk.apiclasses.UserDTO;
import com.awesome.emk.webservice.dtomappers.ArticleMapper;
import com.awesome.emk.webservice.dtomappers.Mappers;
import com.awesome.emk.webservice.dtomappers.OrderMapper;
import com.awesome.emk.webservice.dtomappers.UserMapper;
import com.awesome.emk.webservice.entities.ArticleJPA;
import com.awesome.emk.webservice.entities.BoughtArticleJPA;
import com.awesome.emk.webservice.entities.OrderJPA;
import com.awesome.emk.webservice.entities.UserJPA;
import com.awesome.emk.webservice.entities.UserRoleJPA;
import com.awesome.emk.webservice.repositories.ArticleRepository;
import com.awesome.emk.webservice.repositories.BoughtArticleRepository;
import com.awesome.emk.webservice.repositories.OrderRepository;
import com.awesome.emk.webservice.repositories.UserRoleRepository;
import com.awesome.emk.webservice.repositories.UserRepository;


@Service
public class ApplicationService {

	private ArticleRepository articleRepository;
	private OrderRepository orderRepository;
	private UserRepository userRepository;
	private UserRoleRepository userRoleRepository;
	
	private ArticleMapper articleMapper = Mappers.getArticleMapper();
	private UserMapper userMapper = Mappers.getUserMapper();
	private OrderMapper orderMapper = Mappers.getOrderMapper();
	
	@Autowired
	ApplicationService(ArticleRepository articleRepository, OrderRepository orderRepository, UserRepository userRepository, UserRoleRepository userRoleRepository){
		this.articleRepository = articleRepository;
		this.orderRepository = orderRepository;
		this.userRepository = userRepository;
		this.userRoleRepository = userRoleRepository;
	}
	
	public UserDTO getUser(String username) {
		return userMapper.userJPAToDTO(userRepository.findByUsername(username).get(0));
	}
	
	public List<ArticleDTO> getAllArticles(){
		List<ArticleJPA> articlesJPA = articleRepository.findAll();
		List<ArticleDTO> articlesDTO = new ArrayList <ArticleDTO>();
		for(ArticleJPA article : articlesJPA) {
			articlesDTO.add(articleMapper.articleJPAToDTO(article));
		}
		return articlesDTO;
	}
	
	public List<OrderDTO> getAllOrders(){
		List<OrderJPA> ordersJPA = orderRepository.findAll();
		List<OrderDTO> ordersDTO = new ArrayList <OrderDTO>();
		for(OrderJPA order : ordersJPA) {
			OrderDTO orderDTO = orderMapper.orderJPAToDTO(order);
			orderDTO.setUsername(userRepository.getOne(orderDTO.getUserid()).getUsername());
			ordersDTO.add(orderDTO);
		}
		return ordersDTO;
	}
	
	public List<OrderDTO> getOrderByUsername(String username){
		UserJPA user = userRepository.findByUsername(username).get(0);
		List<OrderJPA> ordersJPA = user.getOrders();
		List<OrderDTO> ordersDTO = new ArrayList <OrderDTO>();
		for(OrderJPA order : ordersJPA) {
			OrderDTO orderDTO = orderMapper.orderJPAToDTO(order);
			orderDTO.setUsername(userRepository.getOne(orderDTO.getUserid()).getUsername());
			ordersDTO.add(orderDTO);
		}
		return ordersDTO;
	}
	
	public List<UserDTO> getAllUsers(){
		List<UserJPA> usersJPA = userRepository.findAll();
		List<UserDTO> usersDTO = new ArrayList<UserDTO>();
		for(UserJPA user : usersJPA) {
			usersDTO.add(userMapper.userJPAToDTO(user));
		}
		return usersDTO;
	}
	
	public ResponseEntity<?> deleteUser(@PathVariable String username){
		userRepository.delete(userRepository.findByUsername(username).get(0));
		return ResponseEntity.ok().build();
	}
	
	public ResponseEntity<?> registerUser(UserDTO input){
		input.setPassword("{noop}" + input.getPassword());
		UserJPA userJPA = userMapper.userDTOToJPA(input);
		userRepository.save(userJPA);
		userRoleRepository.save(new UserRoleJPA(userJPA, input.getRole()));
		return ResponseEntity.ok().build();
	}
	
	public ResponseEntity<?> editUser(UserDTO userDTO, String username){
		UserJPA userJPA = userRepository.findByUsername(username).get(0);
		UserRoleJPA userRoleJPA = userJPA.getUserRole();
		if(userJPA.getUsername() != userDTO.getUsername()) {
			userJPA.setUsername(userDTO.getUsername());
		}	
		if(userJPA.getLastName() != userDTO.getLastName())
			userJPA.setLastName(userDTO.getLastName());
		if(userJPA.getPassword() != userDTO.getPassword())
			userJPA.setPassword("{noop}" + userDTO.getPassword());
		if(userJPA.isEnabled() != userDTO.isEnabled())
			userJPA.setEnabled(userDTO.isEnabled());
		if(userJPA.getUserRole().getRole() != userDTO.getRole())
			userRoleJPA.setRole(userDTO.getRole());
		userRepository.saveAndFlush(userJPA);
		userRoleRepository.saveAndFlush(userRoleJPA);
		return ResponseEntity.ok().build();
	}
	
	public ResponseEntity<?> registerOrder(ArticleDTO[] articlesDTO, String username){
		UserJPA userJPA = userRepository.findByUsername(username).get(0);
		OrderJPA orderJPA = new OrderJPA();
		int sum = 0;
		List<BoughtArticleJPA> articlesJPA = new ArrayList<BoughtArticleJPA>();
		for(ArticleDTO articleDTO : articlesDTO) {
			sum += articleDTO.getPrice();
			articlesJPA.add(articleMapper.articleDTOToBought(articleDTO, orderJPA));
		}
		orderJPA.setUserJPA(userJPA);
		orderJPA.setArticles(articlesJPA);
		orderJPA.setPrice(sum);
		orderRepository.save(orderJPA);
		return ResponseEntity.ok().build();
	}
}
