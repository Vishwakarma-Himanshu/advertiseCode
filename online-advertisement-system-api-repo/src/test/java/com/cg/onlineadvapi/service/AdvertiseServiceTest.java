package com.cg.onlineadvapi.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.cg.onlineadvapi.domain.Advertise;
import com.cg.onlineadvapi.exception.AdvertiseIdException;
import com.cg.onlineadvapi.exception.NoAdvertiseException;
import com.cg.onlineadvapi.repository.AdvertiseRepository;
import com.cg.onlineadvapi.serviceImpl.AdvertiseServiceImpl;

class AdvertiseServiceTest {

	@Mock
	private AdvertiseRepository advertiseRepository;
	
	@InjectMocks
	private AdvertiseServiceImpl advertiseServiceImpl;
	
	private Advertise firstAdvertise;
	private Advertise secondAdvertise;
	private Advertise thirdAdvertise;
	private Advertise advertise;
	private List<Advertise> advertiseList;
	
	@SuppressWarnings("deprecation")
	@BeforeEach
	public void setUp() {
	MockitoAnnotations.initMocks(this); //invoke mock
	advertise = new Advertise();
	advertiseList = new ArrayList<>();
	}
	
	@AfterEach
	public void tearDown() {
	advertiseRepository.deleteAll();
	firstAdvertise = secondAdvertise = null;
	}
	
	@Test
	public void test_saveORUpdate_GivenAdvertise_ShouldReturnAdvertise() {
		firstAdvertise = new Advertise("samsung","mobile",3000.0d,"second hand phone","NEW");
		BDDMockito.given(advertiseRepository.save(advertise))
		.willReturn(firstAdvertise);
		secondAdvertise = advertiseServiceImpl.saveORUpdate(advertise);
		assertNotNull(secondAdvertise);
		assertEquals("samsung", secondAdvertise.getAdvertiseTitle());
		assertEquals("mobile", secondAdvertise.getCategory());
		assertEquals(3000,secondAdvertise.getPrice());
		assertEquals("second hand phone",secondAdvertise.getDescription());
		assertEquals("NEW",secondAdvertise.getStatus());
	}
	
	@Test
    public void test_deleteAdvertiseById_GivenAdvertiseId_ShouldDeleteAdvertisesById() {
    	advertiseRepository.deleteById(advertise.getAdvertiseId());
    	verify(advertiseRepository).deleteById(advertise.getAdvertiseId());
    	assertNull(advertise.getAdvertiseId());
    	assertNull(advertise.getAdvertiseTitle());
    	assertNull(advertise.getCategory());
    	assertNull(advertise.getPrice());
    	assertNull(advertise.getDescription());
    	assertNull(advertise.getStatus());
    	
	}
	
	@Test
	public void test_getAllOpenStatusAdvertise_GivenAdvertiseWithOpenStatus_ShouldReturnOpenStatusAdvertise() {
		firstAdvertise = new Advertise("samsung","mobile",3000.0d,"second hand phone","OPEN");
		secondAdvertise = new Advertise("mi","mobile",4000.0d,"second hand phone","OPEN");
		advertiseList.add(firstAdvertise);
		advertiseList.add(secondAdvertise);
		BDDMockito.given(advertiseRepository.getAllOPENAdvertise())
		.willReturn(advertiseList);
		List<Advertise> getAdvertiseList = advertiseServiceImpl.getAllOpenStatusAdvertise();
		assertNotNull(advertiseList);
		assertNotNull(getAdvertiseList);
		assertEquals(2,getAdvertiseList.size());
		assertEquals(firstAdvertise,getAdvertiseList.get(0));
		assertEquals(secondAdvertise,getAdvertiseList.get(1));
	}

	@Test
	public void test_getAllNewStatusAdvertise() throws Exception {
		BDDMockito.given(advertiseRepository.getAllNEWAdvertise())
		.willThrow(new NoAdvertiseException());
		assertThrows(NoAdvertiseException.class, ()->advertiseServiceImpl.getAllNewStatusAdvertise());
	}
	
	@Test
	public void test_findAdvertiseById() throws Exception {
		BDDMockito.given(advertiseRepository.findById(advertise.getAdvertiseId()))
		.willThrow(new AdvertiseIdException());
		assertThrows(AdvertiseIdException.class, ()->advertiseServiceImpl.findAdvertiseById(1));
	}
	
	@Test
	public void test_getAllNewStatusAdvertise_GivenAdvertiseWithNewStatus_ShouldReturnNewStatusAdvertise() {
		firstAdvertise = new Advertise("samsung","mobile",3000.0d,"second hand phone","NEW");
		secondAdvertise = new Advertise("mi","mobile",4000.0d,"second hand phone","NEW");
		advertiseList.add(firstAdvertise);
		advertiseList.add(secondAdvertise);
		BDDMockito.given(advertiseRepository.getAllNEWAdvertise())
		.willReturn(advertiseList);
		List<Advertise> getAdvertiseList = advertiseServiceImpl.getAllNewStatusAdvertise();
		assertNotNull(advertiseList);
		assertNotNull(getAdvertiseList);
		assertEquals(2,getAdvertiseList.size());
		assertEquals(firstAdvertise,getAdvertiseList.get(0));
		assertEquals(secondAdvertise,getAdvertiseList.get(1));
	}
	
//	@Test
//	public void test_deleteAdById() throws Exception {
//		BDDMockito.given(advertiseRepository.findById(advertise.getAdvertiseId()))
//		.willThrow(new AdvertiseIdException());
//		assertThrows(AdvertiseIdException.class, ()->advertiseServiceImpl.deleteAdById(3));
//	}
	
	@Test
	public void test_getAllClosedStatusAdvertise() throws Exception {
		BDDMockito.given(advertiseRepository.getAllCLOSEDAdvertise())
		.willThrow(new NoAdvertiseException());
		assertThrows(NoAdvertiseException.class, ()->advertiseServiceImpl.getAllClosedStatusAdvertise());
	}
	
	@Test
	public void test_getAllClosedStatusAdvertise_GivenAdvertiseWithClosedStatus_ShouldReturnClosedStatusAdvertise() {
		firstAdvertise = new Advertise("samsung","mobile",3000.0d,"second hand phone","CLOSED");
		secondAdvertise = new Advertise("mi","mobile",7000.0d,"new phone","CLOSED");
		advertiseList.add(firstAdvertise);
		advertiseList.add(secondAdvertise);
		BDDMockito.given(advertiseRepository.getAllCLOSEDAdvertise())
		.willReturn(advertiseList);
		List<Advertise> getAdvertiseList = advertiseServiceImpl.getAllClosedStatusAdvertise();
		assertNotNull(advertiseList);
		assertNotNull(getAdvertiseList);
		assertEquals(2,getAdvertiseList.size());
		assertEquals(firstAdvertise,getAdvertiseList.get(0));
		assertEquals(secondAdvertise,getAdvertiseList.get(1));
	}
	
	@Test
	public void test_getAllRejectedStatusAdvertise() throws Exception {
		BDDMockito.given(advertiseRepository.getAllREJECTEDAdvertise())
		.willThrow(new NoAdvertiseException());
		assertThrows(NoAdvertiseException.class, ()->advertiseServiceImpl.getAllRejectedStatusAdvertise());
	}
	
	@Test
	public void test_getAllRejectedStatusAdvertise_GivenAdvertiseWithRejectedStatus_ShouldReturnRejectedStatusAdvertise() {
		firstAdvertise = new Advertise("samsung","mobile",3000.0d,"second hand phone","REJECTED");
		secondAdvertise = new Advertise("mi","mobile",4000.0d,"second hand phone","REJECTED");
		advertiseList.add(firstAdvertise);
		advertiseList.add(secondAdvertise);
		BDDMockito.given(advertiseRepository.getAllREJECTEDAdvertise())
		.willReturn(advertiseList);
		List<Advertise> getAdvertiseList = advertiseServiceImpl.getAllRejectedStatusAdvertise();
		assertNotNull(advertiseList);
		assertNotNull(getAdvertiseList);
		assertEquals(2,getAdvertiseList.size());
		assertEquals(firstAdvertise,getAdvertiseList.get(0));
		assertEquals(secondAdvertise,getAdvertiseList.get(1));
	}

	@Test
	public void test_getOpenNewStatusAdvertise() throws Exception {
		BDDMockito.given(advertiseRepository.getAllOPENAdvertise())
		.willThrow(new NoAdvertiseException());
		assertThrows(NoAdvertiseException.class, ()->advertiseServiceImpl.getAllOpenStatusAdvertise());
	}
	
	@Test
	public void test_findAllAdvertise_GivenAdvertise_ShouldReturnGivenAdvertise() {
		firstAdvertise = new Advertise("samsung","mobile",3000.0d,"second hand phone","OPEN");
		secondAdvertise = new Advertise("mi","mobile",4000.0d,"second hand phone","NEW");
		thirdAdvertise = new Advertise("ray zr","vehicles",35000.0d,"second hand scooty","NEW");
		advertiseList.add(firstAdvertise);
		advertiseList.add(secondAdvertise);
		advertiseList.add(thirdAdvertise);
		BDDMockito.given(advertiseRepository.findAll())
		.willReturn(advertiseList);
		List<Advertise> getAdvertiseList = advertiseServiceImpl.findAllAdvertise();
		assertNotNull(advertiseList);
		assertNotNull(getAdvertiseList);
		assertEquals(3,getAdvertiseList.size());
		assertEquals(firstAdvertise,getAdvertiseList.get(0));
		assertEquals(secondAdvertise,getAdvertiseList.get(1));
		assertEquals(thirdAdvertise,getAdvertiseList.get(2));
	}
	
	@Test
	public void test_findAllAdvertise() throws Exception {
		BDDMockito.given(advertiseRepository.findAll())
		.willThrow(new NoAdvertiseException());
		assertThrows(NoAdvertiseException.class, ()->advertiseServiceImpl.findAllAdvertise());
	}
	
	@Test
	public void test_findAllOPENAdvertise() throws Exception {
		BDDMockito.given(advertiseRepository.findAllOPENAdvertise(advertise.getAdvertiseTitle()))
		.willThrow(new NoAdvertiseException());
		assertThrows(NoAdvertiseException.class, ()->advertiseServiceImpl.findAllOPENAdvertise("product"));
	}
	
//	@Test//naming convention
//	public void test_findAllOPENAdvertise_GivenAdvertiseWithRejectedStatus_ShouldReturnRejectedStatusAdvertise() {
//		firstAdvertise = new Advertise("mi","mobile",3000.0d,"second hand phone","OPEN");
//		secondAdvertise = new Advertise("mi","mobile",4000.0d,"second hand phone","OPEN");
//		advertiseList.add(firstAdvertise);
//		advertiseList.add(secondAdvertise);
//		BDDMockito.given(advertiseRepository.findAllOPENAdvertise(advertise.getAdvertiseTitle()))
//		.willReturn(advertiseList);
//		List<Advertise> getAdvertiseList = advertiseServiceImpl.findAllOPENAdvertise("mi");
//		assertNotNull(advertiseList);
//		assertNotNull(getAdvertiseList);
//		assertEquals(firstAdvertise,advertise.getAdvertiseTitle());
//		assertEquals(secondAdvertise,advertise.getAdvertiseTitle());
//	}
	
//	@Test
//	public void test_openOrRejectOrClosedAdvertise_GivenAdvertise_ShouldReturnAdvertise() {
//		firstAdvertise = new Advertise("samsung","mobile",3000.0d,"second hand phone","OPEN");
//		BDDMockito.given(advertiseRepository.save(advertise))
//		.willReturn(firstAdvertise);
//		secondAdvertise = advertiseServiceImpl.openOrRejectOrClosedAdvertise(advertise);
//		assertNotNull(secondAdvertise);
//		assertEquals("samsung", secondAdvertise.getAdvertiseTitle());
//		assertEquals("mobile", secondAdvertise.getCategory());
//		assertEquals(3000,secondAdvertise.getPrice());
//		assertEquals("second hand phone",secondAdvertise.getDescription());
//		assertEquals("NEW",secondAdvertise.getStatus());
//	}
}





