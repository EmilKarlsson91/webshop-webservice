package com.awesome.emk.webservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.awesome.emk.apiclasses.ArticleDTO;
import com.awesome.emk.webservice.dtomappers.ArticleMapper;
import com.awesome.emk.webservice.dtomappers.Mappers;
import com.awesome.emk.webservice.entities.ArticleJPA;
import com.awesome.emk.webservice.repositories.ArticleRepository;
import com.awesome.emk.webservice.repositories.UserRoleRepository;
import com.awesome.emk.webservice.repositories.UserRepository;


@Service
public class ApplicationService {

	private ArticleRepository articleRepository;
	private UserRepository userRepository;
	private UserRoleRepository userRoleRepository;
	private ArticleMapper articleMapper = Mappers.getArticleMapper();
	
	@Autowired
	ApplicationService(ArticleRepository articleRepository, UserRepository userRepository, UserRoleRepository userRoleRepository){
		this.articleRepository = articleRepository;
		this.userRepository = userRepository;
		this.userRoleRepository = userRoleRepository;
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	public List<ArticleDTO> getAllArticles(){
		List<ArticleJPA> articlesJPA = articleRepository.findAll();
		List<ArticleDTO> articlesDTO = new ArrayList <ArticleDTO>();
		for(ArticleJPA article : articlesJPA) {
			articlesDTO.add(articleMapper.articleJPAToDTO(article));
		}
		return articlesDTO;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@RequestMapping(value ="/test", method = RequestMethod.GET)
//	public ArticleDTO test(){
//		ArticleJPA articleJPA;
//		if(articleRepository.findById(1L).isPresent()) {
//			articleJPA = articleRepository.findById(1L).get();
//			return articleMapper.articleJPAToDTO(articleJPA);		
//		}
//		return new ArticleDTO();
//	}
//	
//	@Secured("ROLE_ADMIN")
//	@RequestMapping(value="/single/{id}", method = RequestMethod.GET)
//	public ArticleDTO getOne(@PathVariable Long id) {
//		ArticleJPA articleJPA;
//		if(articleRepository.findById(id).isPresent()) {
//			articleJPA = articleRepository.findById(id).get();
//			return articleMapper.articleJPAToDTO(articleJPA);		
//		}
//		return new ArticleDTO();
//	}
//	
//	@RequestMapping("/testaren")
//	public String testaren(Model model) {
////		List<ArticleDTO> articlesDTO = new ArrayList <ArticleDTO>();
////		List<ArticleJPA> articlesJPA = articleRepository.findAll();
////
////		for(ArticleJPA article : articlesJPA) {
////			articlesDTO.add(articleMapper.articleJPAToDTO(article));
////		}		
////		model.addAttribute("list", articlesDTO);
//		System.out.println("BABABABABABABBABABABABABABA");
//		return "test";
//	}
//	
//	@RequestMapping(value = "/post", method = RequestMethod.POST)
//	 ResponseEntity<?> addArticle(@RequestBody ArticleDTO input){
//		ArticleJPA articleJPA = articleMapper.articleDTOToJPA(input);
//		articleRepository.save(articleJPA);
//		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(articleJPA.getId()).toUri();
//		return ResponseEntity.created(location).build();
//	}
//	
//	@RequestMapping(value="/articleslist", method = RequestMethod.GET, produces = {"application/xml", "application/json"})
//	public String getAllArticlesTest(Model model){
//		
//		List<ArticleJPA> articlesJPA = articleRepository.findAll();
//		List<ArticleDTO> articlesDTO = new ArrayList <ArticleDTO>();
//		for(ArticleJPA article : articlesJPA) {
//			articlesDTO.add(articleMapper.articleJPAToDTO(article));
//		}
//		//RestTemplate restTemplate = new RestTemplate();
//		
//		ResponseEntity<ArticleListDTO> list = new ResponseEntity<ArticleListDTO>(new ArticleListDTO(articlesDTO), null);
//		model.addAttribute("list", list.getBody());
//		return "hello-admin";
//	}
	
//	@RequestMapping(value="/list", method = RequestMethod.GET, produces = {"application/xml", "application/json"})
//	public String getAllArticlesTest(Model model){
//		
//		/*List<ArticleJPA> articlesJPA = articleRepository.findAll();
//		List<ArticleDTO> articlesDTO = new ArrayList <ArticleDTO>();
//		for(ArticleJPA article : articlesJPA) {
//			articlesDTO.add(articleMapper.articleJPAToDTO(article));
//		}*/
//		RestTemplate restTemplate = new RestTemplate();
//		ResponseEntity<ArticleListDTO> list = restTemplate.getForEntity("http://localhost:8080/testlist", ArticleListDTO.class);
//		model.addAttribute("list", list.getBody());
//		return "list";
//	}
	
//	@RequestMapping(value="/testlist", method = RequestMethod.GET)
//	public ArticleListDTO getArticleList() {
//		
//		List<ArticleJPA> articlesJPA = articleRepository.findAll();
//		List<ArticleDTO> articlesDTO = new ArrayList <ArticleDTO>();
//		for(ArticleJPA article : articlesJPA) {
//			articlesDTO.add(articleMapper.articleJPAToDTO(article));
//		}
//        ArticleListDTO list = new ArticleListDTO(articlesDTO);
//
//		return list;
//	}
//	
//	@RequestMapping(value="articles/all", method = RequestMethod.GET, produces = {"application/xml", "application/json"})
//	private List<ArticleDTO> getAllArticlesOLD(){
//		
//		List<ArticleJPA> articlesJPA = articleRepository.findAll();
//		List<ArticleDTO> articlesDTO = new ArrayList <ArticleDTO>();
//		
//		for(ArticleJPA article : articlesJPA) {
//			articlesDTO.add(articleMapper.articleJPAToDTO(article));
//		}
//		
//		return articlesDTO;
//	}
//	
//	@RequestMapping(value="/edit/{id}", method = RequestMethod.PUT)
//	ResponseEntity<?> editArticle(@RequestBody ArticleDTO articleDTO, @PathVariable Long id){
//		ArticleJPA articleJPA = articleRepository.findById(id).get();
//		if(articleJPA.getDescription() != articleDTO.getDescription())
//			articleJPA.setDescription(articleDTO.getDescription());
//		if(articleJPA.getName() != articleDTO.getName())
//			articleJPA.setName(articleDTO.getName());
//		if(articleJPA.getPrice() != articleDTO.getPrice())
//			articleJPA.setPrice(articleDTO.getPrice());
//		if(articleJPA.getProducer() != articleDTO.getProducer())
//			articleJPA.setProducer(articleDTO.getProducer());
//		if(articleJPA.getStock() != articleDTO.getStock())
//			articleJPA.setStock(articleDTO.getStock());
//		articleRepository.saveAndFlush(articleJPA);
//		return ResponseEntity.ok().build();
//	}
//	
//	@RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE)
//	ResponseEntity<?> deleteArticle(@PathVariable Long id){
//		articleRepository.delete(articleRepository.findById(id).get());
//		return ResponseEntity.ok().build();
//	}
}
