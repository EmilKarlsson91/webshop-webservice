package com.awesome.emk.webservice.dtomappers;

import com.awesome.emk.apiclasses.ArticleDTO;
import com.awesome.emk.webservice.entities.ArticleJPA;

public interface ArticleMapper {
	ArticleJPA articleDTOToJPA(ArticleDTO articleDTO);
	ArticleDTO articleJPAToDTO(ArticleJPA articleJPA);
}
