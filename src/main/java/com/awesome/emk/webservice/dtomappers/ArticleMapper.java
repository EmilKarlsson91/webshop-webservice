package com.awesome.emk.webservice.dtomappers;

import com.awesome.emk.apiclasses.ArticleDTO;
import com.awesome.emk.webservice.entities.ArticleJPA;
import com.awesome.emk.webservice.entities.BoughtArticleJPA;
import com.awesome.emk.webservice.entities.OrderJPA;

public interface ArticleMapper {
	ArticleJPA articleDTOToJPA(ArticleDTO articleDTO);
	ArticleDTO articleJPAToDTO(ArticleJPA articleJPA);
	BoughtArticleJPA articleDTOToBought(ArticleDTO articleDTO, OrderJPA orderJPA);
	ArticleDTO articleBoughtJPAToDTO (BoughtArticleJPA boughtArticleJPA);
}
