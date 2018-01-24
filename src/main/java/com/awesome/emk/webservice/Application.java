package com.awesome.emk.webservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.awesome.emk.webservice.entities.ArticleJPA;
import com.awesome.emk.webservice.entities.UserJPA;
import com.awesome.emk.webservice.entities.UserRoleJPA;
import com.awesome.emk.webservice.repositories.ArticleRepository;
import com.awesome.emk.webservice.repositories.UserRepository;
import com.awesome.emk.webservice.repositories.UserRoleRepository;

@SpringBootApplication
public class Application {
	
	private static Logger log = LoggerFactory.getLogger(Application.class);

//	//Test data for ArticlesJPA
	private static String[] articleNames = {"Ost", "Toalettpapper", "Mjölk"};
	private static String[] producers = {"Mjölkbönderna", "Bagarna", "Skurkarna"};
	private static String[] lastNames = {"Karlsson", "Svensson", "Johansson"};
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	public CommandLineRunner init(ArticleRepository articleRepository, UserRepository userRepository, UserRoleRepository userRoleRepository) {
		return (args) -> {
			
			//save a couple of list elements
			for(int i = 0; i < 10; i++) {
				addArticle(articleRepository);
			}

			addUser(userRepository, userRoleRepository, "Emil");
			addUser(userRepository, userRoleRepository, "Bertil");
			addUser(userRepository, userRoleRepository, "Håkan");
			addUser(userRepository, userRoleRepository, "Julia");
			addUser(userRepository, userRoleRepository, "Gunnilla");
		};		
	}
	
	private void addArticle(ArticleRepository articleRepository) {
			articleRepository.save(new ArticleJPA(articleNames[(int) (Math.random() * articleNames.length)],"Some description" , producers[(int) (Math.random() * producers.length)], (float) (100 * Math.random()), (int)(500 * Math.random())));
	}
	
	
	
	//Om jag har tid, lägg till en passwordEncoder.
	private void addUser(UserRepository userRepository, UserRoleRepository userRoleRepository, String username) {
		UserJPA user = new UserJPA(username, lastNames[(int) (Math.random() * lastNames.length)],"{noop}password", true);
		userRepository.save(user);
		addUserRole(userRoleRepository, user);
	}
	
	private void addUserRole(UserRoleRepository userRoleRepository, UserJPA userJPA) {
		String role;
		
		if(Math.random() < 0.5) {
			role="ROLE_ADMIN";			
		}
		else {
			role="ROLE_USER";
		}
		userRoleRepository.save(new UserRoleJPA(userJPA, role));
	}
}
