package com.awesome.emk.webservice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.awesome.emk.apiclasses.ArticleDTO;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Controller
public class ApplicationController {
	
	private static Logger log = LoggerFactory.getLogger(Application.class);

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
	
	@RequestMapping(value="/articlestest", method = RequestMethod.GET)
	public List<ArticleDTO> getAllArticlesTest(){		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();				
		return applicationService.getAllArticles();
	}
}
