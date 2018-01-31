package com.awesome.emk.webservice.dtomappers;

public class Mappers {

	public static ArticleMapper getArticleMapper() {
		return new ArticleMapperImpl();
	}
	
	public static UserMapper getUserMapper() {
		return new UserMapperImpl();
	}
	
	public static OrderMapper getOrderMapper() {
		return new OrderMapperImpl();
	}
}
