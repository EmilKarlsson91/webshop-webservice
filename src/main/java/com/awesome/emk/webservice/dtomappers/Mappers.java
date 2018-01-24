package com.awesome.emk.webservice.dtomappers;

public class Mappers {

	public static ArticleMapper getArticleMapper() {
		return new ArticleMapperImpl();
	}
	
	public static UserMapper getUserMapper() {
		return null;
	}
	
	public static UserRoleMapper getUserRoleMapper() {
		return null;
	}
}
