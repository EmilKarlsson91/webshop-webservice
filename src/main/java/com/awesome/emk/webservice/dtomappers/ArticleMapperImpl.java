package com.awesome.emk.webservice.dtomappers;

import com.awesome.emk.apiclasses.ArticleDTO;
import com.awesome.emk.webservice.entities.ArticleJPA;

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

        articleDTO.setName( articleJPA.getName() );
        articleDTO.setDescription( articleJPA.getDescription() );
        articleDTO.setProducer( articleJPA.getProducer() );
        articleDTO.setPrice( articleJPA.getPrice() );
        articleDTO.setStock( articleJPA.getStock() );

        return articleDTO;
    }
}
