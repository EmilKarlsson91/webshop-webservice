package com.awesome.emk.webservice.dtomappers;

import com.awesome.emk.apiclasses.UserDTO;
import com.awesome.emk.webservice.entities.UserJPA;

public class UserMapperImpl implements UserMapper {

	@Override
	public UserJPA userDTOToJPA(UserDTO userDTO) {
		if(userDTO == null) {
			return null;
		}
		UserJPA userJPA = new UserJPA();
		
		userJPA.setUsername(userDTO.getUsername());
		userJPA.setLastName(userDTO.getLastName());
		userJPA.setPassword(userDTO.getPassword());
		userJPA.setEnabled(userDTO.isEnabled());
		
		return userJPA;
	}

	@Override
	public UserDTO userJPAToDTO(UserJPA userJPA) {
		if(userJPA == null) {
			return null;
		}
		
		UserDTO userDTO = new UserDTO();

		userDTO.setUsername(userJPA.getUsername());
		userDTO.setPassword(userJPA.getPassword());
		userDTO.setEnabled(userJPA.isEnabled());
		userDTO.setLastName(userJPA.getLastName());
		userDTO.setRole(userJPA.getUserRole().getRole());		
		userDTO.setId(userJPA.getId());
		
		return userDTO;
	}

}
