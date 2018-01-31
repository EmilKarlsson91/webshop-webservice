package com.awesome.emk.webservice.dtomappers;

import com.awesome.emk.apiclasses.UserDTO;
import com.awesome.emk.webservice.entities.UserJPA;

public interface UserMapper {
	UserJPA userDTOToJPA(UserDTO userDTO);
	UserDTO userJPAToDTO(UserJPA userJPA);
}
