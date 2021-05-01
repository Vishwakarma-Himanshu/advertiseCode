package com.cg.onlineadvapi.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineadvapi.domain.Advertise;
import com.cg.onlineadvapi.service.AdvertiseService;
import com.cg.onlineadvapi.serviceImpl.MapValidationErrorService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
public class AdvertiseController {

	@Autowired
	private AdvertiseService advertiseService;
	
	@Autowired
	private MapValidationErrorService mapValidationErrorService;
	
	@ApiOperation(value = "Create new Advertise")
	@PostMapping("")
	public ResponseEntity<?> createNewAdvertise(@Valid @RequestBody Advertise advertise, BindingResult result) {
		ResponseEntity <?> errorMessage =mapValidationErrorService.mapValidationError(result);
		if(errorMessage!=null) return errorMessage;
		
		advertiseService.saveORUpdate(advertise);
		return new ResponseEntity<String>("Posted Successfully. Waiting for Admin Confirmation", HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "Update Advertise")
	@PatchMapping("")
	public ResponseEntity<?> updateAdvertise(@Valid @RequestBody Advertise advertise, BindingResult result) {
		ResponseEntity <?> errorMessage =mapValidationErrorService.mapValidationError(result);
		if(errorMessage!=null) return errorMessage;
		
		advertiseService.saveORUpdate(advertise);
		return new ResponseEntity<String>(advertise.getAdvertiseTitle()+" Updated Successfully", HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "For admin to accept/reject/close advertise")
	@PutMapping("/acceptOrRejectStatus")
	public String openOrClosedOrRejectAdvertise(Advertise advertise) {
		if(advertise.getStatus().equals("NEW")||advertise.getStatus().equals("OPEN")||advertise.getStatus().equals("REJECTED")||advertise.getStatus().equals("CLOSED")) {
		advertiseService.openOrRejectOrClosedAdvertise(advertise);
		return "Status changed successfully";
		}else {
			return "Please select valid status(OPEN,CLOSED,REJECTED) or Enter valid advertiseId";
		}
	}
	
	@ApiOperation(value = "Get all open advertise(for admin)")
	@GetMapping("/getOpenAdvertise")
	public List<Advertise> getAllOpenAdvertise(){
		return advertiseService.getAllOpenStatusAdvertise();
	}
	
	@ApiOperation(value = "Get all open advertise(for user)")
	@GetMapping("/getOpenAdvertiseForUser")
	public List<Advertise> getAllOpenAdvertiseForUser(){
		return advertiseService.getAllOpenStatusAdvertise();
	}
	
	@ApiOperation(value = "Get all new advertise(for admin)")
	@GetMapping("/getNewAdvertise")
	public List<Advertise> getAllNewAdvertise(){
		return advertiseService.getAllNewStatusAdvertise();
	}
	
	@ApiOperation(value = "Get all closed advertise(for admin)")
	@GetMapping("/getClosedAdvertise")
	public List<Advertise> getAllClosedAdvertise(){
		return advertiseService.getAllClosedStatusAdvertise();
	}
	
	@ApiOperation(value = "Get all rejected advertise(for admin)")
	@GetMapping("/getAccepteRejectedAdvertise")
	public List<Advertise> getAllRejectedAdvertise(){
		return advertiseService.getAllRejectedStatusAdvertise();
	}
	
	@ApiOperation(value = "Get All open/new/closed/rejected Advertise(for admin)")
	@GetMapping("/getAllAdvertise")
	public List<Advertise> getAllAdvertise(){
		return advertiseService.findAllAdvertise();
	}
	
	@ApiOperation(value = "Delete Advertise By Id(for admin)")
	@DeleteMapping("/{advertiseId}")
	public ResponseEntity<?> deleteAdvertise(@PathVariable Integer advertiseId){
		advertiseService.deleteAdvertiseById(advertiseId);
		return new ResponseEntity<String>("Id "+advertiseId+" deleted Successfully",HttpStatus.OK);
	}
	
	@ApiOperation(value = "Delete Advertise By Id(for user)")
	@DeleteMapping("/deleteAdvertiseForUser/{advertiseId}")
	public void deleteAdById(@PathVariable Integer advertiseId){
		advertiseService.deleteAdById(advertiseId);
	}
	
	@ApiOperation(value  = "Search all advertise by title(for user)")
	@GetMapping("/getAllAdvertiseByTitle/{advertiseTitle}")
	public List<Advertise> getAllAdvertiseByTitle(@PathVariable String advertiseTitle){
		return advertiseService.findAllOPENAdvertise(advertiseTitle);
	}
	
	@ApiOperation(value = "Get Advertise By Id(for user)")
	@GetMapping("/getAdvertiseById/{advertiseId}")
	public Advertise getAdvertiseById(@PathVariable Integer advertiseId) {
		 return advertiseService.findAdvertiseById(advertiseId);
	}
	
}
