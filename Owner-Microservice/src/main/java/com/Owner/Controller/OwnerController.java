package com.Owner.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Owner.Models.OwnerInfo;
import com.Owner.Repo.OwnerRepo;
import com.Owner.SecurityConfig.OwnerAuthResponse;
import com.Owner.SecurityConfig.OwnerService;

@RestController
@RequestMapping("/owner")
public class OwnerController {
	@Autowired
	private OwnerService ownerService;
	@Autowired
	private OwnerRepo ownerRepo;
	@Autowired
	private AuthenticationManager authenticationManager;

//Creating/Adding Washer
	/*
	 * @PostMapping("/addwasher") public Washer saveWasher(@RequestBody Washer
	 * washer) { return washerService.addWasher(washer); }
	 */
	@PostMapping("/addOwner")
	private ResponseEntity<?> saveOwnerInfo(@RequestBody OwnerInfo ownerInfo) {
		String email = ownerInfo.getEmail();
		String password = ownerInfo.getPassword();
		OwnerInfo owner1 = new OwnerInfo();
		owner1.setEmail(email);
		owner1.setPassword(password);
		try {

			ownerRepo.save(ownerInfo);
		} catch (Exception e) {
			return ResponseEntity.ok(new OwnerAuthResponse("Error creating Owner" + email));
		}
		return ResponseEntity.ok(new OwnerAuthResponse("Successfully created Owner " + email));
	}

//authenticating washer
	@PostMapping("/auth")
	private ResponseEntity<?> authWasher(@RequestBody OwnerInfo ownerInfo) {
		String email = ownerInfo.getEmail();
		String password = ownerInfo.getPassword();
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
		} catch (Exception e) {
			return ResponseEntity.ok(new OwnerAuthResponse("Error during Owner Authentication" + email));
		}
		return ResponseEntity.ok(new OwnerAuthResponse("Successfully Authenticated Owner" + email));
	}

//Reading all washer
	@GetMapping("/owner")
	public List<OwnerInfo> findAllWashers() {
		return ownerService.getOwnerInfos();
	}

}
