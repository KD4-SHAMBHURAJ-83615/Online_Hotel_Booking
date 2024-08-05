package com.hotelhub.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotelhub.entity.Address;

public interface AddressDao extends JpaRepository <Address, Long>{
	
	

}
