package com.awesome.emk.webservice.dtomappers;

import java.util.ArrayList;
import java.util.List;

import com.awesome.emk.apiclasses.ArticleDTO;
import com.awesome.emk.apiclasses.OrderDTO;
import com.awesome.emk.webservice.entities.BoughtArticleJPA;
import com.awesome.emk.webservice.entities.OrderJPA;

public class OrderMapperImpl implements OrderMapper{

	private ArticleMapper articleMapper = Mappers.getArticleMapper();
	
	@Override
	public OrderJPA orderDTOToJPA(OrderDTO orderDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderDTO orderJPAToDTO(OrderJPA orderJPA) {
		OrderDTO orderDTO = new OrderDTO();
		List<ArticleDTO> articlesDTO = new ArrayList<ArticleDTO>();
		for(BoughtArticleJPA boughtArticle : orderJPA.getArticles()) {
			articlesDTO.add(articleMapper.articleBoughtJPAToDTO(boughtArticle));
		}
		orderDTO.setArticles(articlesDTO);
		orderDTO.setId(orderJPA.getId());
		orderDTO.setPrice(orderJPA.getPrice());
		orderDTO.setUserid(orderJPA.getUserJPA().getId());
		
		return orderDTO;
	}

}
