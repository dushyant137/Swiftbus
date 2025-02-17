package com.bus.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bus.entities.Owner;
@Repository
public interface OwnerRepo extends JpaRepository<Owner, Long> {
	
	@Query("select o from Owner o left join fetch o.buses where o.id=:id")
	List<Owner> getOwnerBusDetails(Long id);
	


}
