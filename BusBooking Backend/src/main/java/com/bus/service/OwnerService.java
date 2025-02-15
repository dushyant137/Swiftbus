package com.bus.service;

import java.util.List;

import com.bus.dto.OwnerDto;
import com.bus.entities.Owner;

public interface OwnerService {
	String addOwner(Owner owner);
	OwnerDto getOwner(Long id);
	OwnerDto updateOwner(Long id,Owner owner);
	String deleteOwner(Long id);
	List<Owner>getAllOwners();
	List<Owner> findAllOwnerAndBuses(Long id);

}
