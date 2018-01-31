package com.awesome.emk.webservice.dtomappers;

import com.awesome.emk.apiclasses.ArticleDTO;
import com.awesome.emk.webservice.entities.ArticleJPA;
import com.awesome.emk.webservice.entities.BoughtArticleJPA;
import com.awesome.emk.webservice.entities.OrderJPA;

import javax.annotation.Generated;
import org.springframework.stereotype.Component;

public class ArticleMapperImpl implements ArticleMapper {

    @Override
    public ArticleJPA articleDTOToJPA(ArticleDTO articleDTO) {
        if ( articleDTO == null ) {
            return null;
        }

        ArticleJPA articleJPA = new ArticleJPA();

        articleJPA.setName( articleDTO.getName() );
        articleJPA.setDescription( articleDTO.getDescription() );
        articleJPA.setProducer( articleDTO.getProducer() );
        articleJPA.setPrice( articleDTO.getPrice() );
        articleJPA.setStock( articleDTO.getStock() );

        return articleJPA;
    }

    @Override
    public ArticleDTO articleJPAToDTO(ArticleJPA articleJPA) {
        if ( articleJPA == null ) {
            return null;
        }

        ArticleDTO articleDTO = new ArticleDTO();
        
        articleDTO.setId(articleJPA.getId());
        articleDTO.setName( articleJPA.getName() );
        articleDTO.setDescription( articleJPA.getDescription() );
        articleDTO.setProducer( articleJPA.getProducer() );
        articleDTO.setPrice( articleJPA.getPrice() );
        articleDTO.setStock( articleJPA.getStock() );

        return articleDTO;
    }

	@Override
	public BoughtArticleJPA articleDTOToBought(ArticleDTO articleDTO, OrderJPA orderJPA) {
        if ( articleDTO == null ) {
            return null;
        }

        BoughtArticleJPA boughtArticleJPA = new BoughtArticleJPA();

        boughtArticleJPA.setOrderJPA(orderJPA);
        boughtArticleJPA.setName( articleDTO.getName() );
        boughtArticleJPA.setDescription( articleDTO.getDescription() );
        boughtArticleJPA.setProducer( articleDTO.getProducer() );
        boughtArticleJPA.setPrice( articleDTO.getPrice() );
        boughtArticleJPA.setQuantity( articleDTO.getStock() );
        return boughtArticleJPA;
	}

	@Override
	public ArticleDTO articleBoughtJPAToDTO(BoughtArticleJPA boughtArticleJPA) {
        if ( boughtArticleJPA == null ) {
            return null;
        }

        ArticleDTO articleDTO = new ArticleDTO();
        
        articleDTO.setId(boughtArticleJPA.getId());
        articleDTO.setName( boughtArticleJPA.getName() );
        articleDTO.setDescription( boughtArticleJPA.getDescription() );
        articleDTO.setProducer( boughtArticleJPA.getProducer() );
        articleDTO.setPrice( boughtArticleJPA.getPrice() );
        articleDTO.setStock( boughtArticleJPA.getQuantity() );

        return articleDTO;
	}
}
