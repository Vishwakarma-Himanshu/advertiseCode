package com.cg.onlineadvapi.service;

import java.util.List;

import com.cg.onlineadvapi.domain.Advertise;

public interface AdvertiseService {

	/**
	 * This method is used to save Or update advertise used by user module
	 * @param advertise
	 * @return saved or update advertise details
	 */
	public Advertise saveORUpdate(Advertise advertise);
	/**
	 * This method is used to delete advertise by Id manage by admin module
	 * Here admin can delete any advertise present in table
	 * @param advertiseId
	 */
	public void deleteAdvertiseById(Integer advertiseId);
	/**
	 * This method is used to delete advertise by Id manage by user module
	 * Here user can delete only advertise posted by him/her whose status is OPEN
	 * @param advertiseId
	 */
	public void deleteAdById(Integer advertiseId); 
	/**
	 * This method is used to get all advertise present in table manage by admin module
	 * @return all advertise present in database
	 */
	public List<Advertise> findAllAdvertise();
	/**
	 * This method is used to search all accepted advertise by text manage by user module
	 * @param advertiseTitle
	 * @return all advertise that matches the advertise title and whose status is OPEN
	 */
	public List<Advertise> findAllOPENAdvertise(String advertiseTitle);
	/**
	 * This method is used to accept/reject/close advertise created/posted by user manage by admin module
	 * @param advertise
	 */
	public Advertise openOrRejectOrClosedAdvertise(Advertise advertise);
	/**
	 * This method is used to get all accepted advertise in table manage by admin and user module
	 * @return all advertise whose status is OPEN
	 */
	public List<Advertise> getAllOpenStatusAdvertise();
	/**
	 * This method is used to get all new advertise in table manage by admin module
	 * @return all advertise whose status is NEW
	 */
	public List<Advertise> getAllNewStatusAdvertise();
	/**
	 * This method is used to get all close advertise in table manage by admin module
	 * @return all advertise whose status is CLOSED
	 */
	public List<Advertise> getAllClosedStatusAdvertise();
	/**
	 * This method is used to get all reject advertise in table manage by admin module
	 * @return all advertise whose status is REJECTED
	 */
	public List<Advertise> getAllRejectedStatusAdvertise();
	/**
	 *  This method is used to get specific advertise by Id manage by user module
	 * @param advertiseId
	 * @return specific advertise by id only if it is present in database and status is OPEN
	 */
	public Advertise findAdvertiseById(Integer advertiseId);
}
