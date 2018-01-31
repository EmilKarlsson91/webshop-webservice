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
public class WebserviceApplication {
	
//	private static Logger log = LoggerFactory.getLogger(WebserviceApplication.class);
//
//	private static String[] articleNames = {"Bildäck", "Sprit", "Bananer", "Handskar", "Pistol"};
//	private static String[] producers = {"Bilverkstan", "Polisen", "Säljarna", "Fiskarna"};
//	private static String[] lastNames = {"Karlsson", "Svensson", "Johansson", "Fransson", "Steijner", "Magnusson", "Kristersson"};
	
	public static void main(String[] args) {
		SpringApplication.run(WebserviceApplication.class, args);
	}
	
//	@Bean
//	public CommandLineRunner init(ArticleRepository articleRepository, UserRepository userRepository, UserRoleRepository userRoleRepository) {
//		return (args) -> {
//			articleRepository.save(new ArticleJPA("Mjölk", "Some description", "Mjölktillverkarna", 9.90f, 150));
//			articleRepository.save(new ArticleJPA("Grafikkort", "Some description", "Graficmania", 9999.90f, 4));
//			articleRepository.save(new ArticleJPA("Ost", "Some description", "Ostgubbarna", 9.90f, 145));
//			articleRepository.save(new ArticleJPA("Bröd", "Some description", "Bagarna", 19.90f, 123));
//			articleRepository.save(new ArticleJPA("Margarin", "Some description", "Mjölktillverkarna", 9.90f, 354));
//			articleRepository.save(new ArticleJPA("Margarin", "Some description", "Smörtillverkarna", 19.90f, 486));
//			articleRepository.save(new ArticleJPA("Smör", "Some description", "Karla", 18.90f, 1550));
//			articleRepository.save(new ArticleJPA("Kivi", "Some description", "Djungelfarmarna", 5.90f, 150));
//			articleRepository.save(new ArticleJPA("Spakcykel", "Some description", "Cykeltanterna", 568.90f, 60));
//			articleRepository.save(new ArticleJPA("Skor", "Some description", "Skomakaren", 156f, 35));
//			articleRepository.save(new ArticleJPA("Gamla skor", "Some description", "Second hand snubbarna", 9.90f, 150));
//			articleRepository.save(new ArticleJPA("Knark", "Some description", "Smugglarna", 9999.90f, 65));
//			articleRepository.save(new ArticleJPA("Hembränt", "Some description", "Raggarna", 2.90f, 1523));
//			for(int i = 0; i < 50; i++) {
//				addArticle(articleRepository);
//			}
//
//			addUser(userRepository, userRoleRepository, "Emil");
//			addUser(userRepository, userRoleRepository, "Bertil");
//			addUser(userRepository, userRoleRepository, "Håkan");
//			addUser(userRepository, userRoleRepository, "Julia");
//			addUser(userRepository, userRoleRepository, "Gunilla");
//			addUser(userRepository, userRoleRepository, "Berit");
//			addUser(userRepository, userRoleRepository, "Johan");
//			addUser(userRepository, userRoleRepository, "Greta");
//			addUser(userRepository, userRoleRepository, "Erik");
//
//		};		
//	}
//	
//	private void addArticle(ArticleRepository articleRepository) {
//			articleRepository.save(new ArticleJPA(articleNames[(int) (Math.random() * articleNames.length)],"Some description" , producers[(int) (Math.random() * producers.length)], (float) (100 * Math.random()), (int)(500 * Math.random())));
//	}
//	
//	private void addUser(UserRepository userRepository, UserRoleRepository userRoleRepository, String username) {
//		UserJPA user = new UserJPA(username, lastNames[(int) (Math.random() * lastNames.length)],"{noop}password", true);
//		userRepository.save(user);
//		addUserRole(userRoleRepository, user);
//	}
//	
//	private void addUserRole(UserRoleRepository userRoleRepository, UserJPA userJPA) {
//		String role;
//		
//		if(Math.random() < 0.5) {
//			role="ROLE_ADMIN";			
//		}
//		else {
//			role="ROLE_USER";
//		}
//		userRoleRepository.save(new UserRoleJPA(userJPA, role));
//	}
}
