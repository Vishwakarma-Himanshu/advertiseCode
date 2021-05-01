package com.cg.onlineadvapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.onlineadvapi.domain.Advertise;
@Repository
public interface AdvertiseRepository extends JpaRepository<Advertise, Integer>{

	/**
	 * In this query we search advertise title with OPEN status
	 * @param advertiseTitle
	 * @return all advertise that matches the advertise title and whose status is OPEN
	 */
	@Query("select a from Advertise a where a.advertiseTitle LIKE %?1% AND a.status='OPEN'")
	public List<Advertise> findAllOPENAdvertise(String advertiseTitle);
	
	/**
	 * This query is used by admin and user module both to get all OPEN status advertise
	 * @return all advertise whose status is OPEN
	 */
	@Query("select a from Advertise a where a.status = 'OPEN'")
	public List<Advertise> getAllOPENAdvertise();
	
	/**
	 * This query is used by admin and user module both to get all OPEN status advertise
	 * @return all advertise whose status is NEW
	 */
	@Query("select a from Advertise a where a.status = 'NEW'")
	public List<Advertise> getAllNEWAdvertise();
	
	/**
	 * This query is used by admin and user module both to get all OPEN status advertise
	 * @return all advertise whose status is REJECTED
	 */
	@Query("select a from Advertise a where a.status = 'REJECTED'")
	public List<Advertise> getAllREJECTEDAdvertise();
	
	/**
	 * This query is used by admin and user module both to get all OPEN status advertise
	 * @return all advertise whose status is CLOSED
	 */
	@Query("select a from Advertise a where a.status = 'CLOSED'")
	public List<Advertise> getAllCLOSEDAdvertise();
}
