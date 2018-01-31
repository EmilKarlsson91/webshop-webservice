package com.awesome.emk.webservice.dtomappers;


import com.awesome.emk.apiclasses.OrderDTO;
import com.awesome.emk.webservice.entities.OrderJPA;

public interface OrderMapper {
	OrderJPA orderDTOToJPA(OrderDTO orderDTO);
	OrderDTO orderJPAToDTO(OrderJPA orderJPA);
}
