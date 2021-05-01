package com.cg.onlineadvapi.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineadvapi.domain.Advertise;
import com.cg.onlineadvapi.exception.AdvertiseIdException;
import com.cg.onlineadvapi.exception.NoAdvertiseException;
import com.cg.onlineadvapi.repository.AdvertiseRepository;
import com.cg.onlineadvapi.service.AdvertiseService;


@Service
public class AdvertiseServiceImpl implements AdvertiseService{
	
	@Autowired
	private AdvertiseRepository advertiseRepository;
		
	@Override//test case done
	public Advertise saveORUpdate(Advertise advertise) {
		advertise.setStatus("NEW");
		return advertiseRepository.save(advertise);
	}
	
	@Override
	public Advertise openOrRejectOrClosedAdvertise(Advertise advertise) {
		Optional<Advertise> advertise1 = advertiseRepository.findById(advertise.getAdvertiseId());
		Advertise ad = advertise1.get();
		ad.setStatus(advertise.getStatus());
		return advertiseRepository.save(ad);
	}
	
	@Override//test case done with exception
	public void deleteAdvertiseById(Integer advertiseId) {
		Optional<Advertise> ad = advertiseRepository.findById(advertiseId);
		if(ad.isPresent())
			advertiseRepository.deleteById(advertiseId);
		else
			throw new AdvertiseIdException(advertiseId+" not found");
	}
	
	@Override//test case done- with exception
	public List<Advertise> findAllAdvertise() {
		List<Advertise> advertiseList = advertiseRepository.findAll();
		boolean result = advertiseList.isEmpty();
		if(result == true) {
			throw new NoAdvertiseException("No Advertise available");
		}else {
			return advertiseList;
		}
	}
	
	@Override//exception handled
	public List<Advertise> findAllOPENAdvertise(String advertiseTitle) {
		List<Advertise> advertiseList = advertiseRepository.findAllOPENAdvertise(advertiseTitle);
		boolean result = advertiseList.isEmpty();
		if(result == true) {
			throw new NoAdvertiseException("Product you find is not found");
		}else {
			return advertiseList;
		}
	}
	
	@Override//test case done with exception
	public List<Advertise> getAllOpenStatusAdvertise() {
		List<Advertise> advertiseList = advertiseRepository.getAllOPENAdvertise();
		boolean result = advertiseList.isEmpty();
		if(result == true) {
			throw new NoAdvertiseException("No OPEN Advertise available");
		}else {
			return advertiseList;
		}
	}
	
	@Override//test case done with exception
	public List<Advertise> getAllNewStatusAdvertise() {
		List<Advertise> advertiseList = advertiseRepository.getAllNEWAdvertise();
		boolean result = advertiseList.isEmpty();
		if(result == true) {
			throw new NoAdvertiseException("No NEW Advertise available");
		}else {
			return advertiseList;
		}
	}
	
	@Override//test case done with exception
	public List<Advertise> getAllClosedStatusAdvertise() {
		List<Advertise> advertiseList = advertiseRepository.getAllCLOSEDAdvertise();
		boolean result = advertiseList.isEmpty();
		if(result == true) {
			throw new NoAdvertiseException("No CLOSED Advertise available");
		}else {
			return advertiseList;
		}
	}
	
	@Override//test case done with exception
	public List<Advertise> getAllRejectedStatusAdvertise() {
		List<Advertise> advertiseList = advertiseRepository.getAllREJECTEDAdvertise();
		boolean result = advertiseList.isEmpty();
		if(result == true) {
			throw new NoAdvertiseException("No REJECTED Advertise available");
		}else {
			return advertiseList;
		}
	}

	@Override//test case done with exception
	public Advertise findAdvertiseById(Integer advertiseId) {
		Optional<Advertise> ad = advertiseRepository.findById(advertiseId);
		if(ad.isPresent()){
			if(ad.get().getStatus().equals("OPEN"))
				return ad.get();
			}
		else
			throw new AdvertiseIdException(advertiseId+" not found");
		return null;
	}

	@Override
	public void deleteAdById(Integer advertiseId) {
		Optional<Advertise> ad = advertiseRepository.findById(advertiseId);
		if(ad.isPresent()){
			if(ad.get().getStatus().equals("OPEN"))
				advertiseRepository.deleteById(advertiseId);
			else
				throw new AdvertiseIdException(advertiseId+" not found");
			}
	}
	
}
