package com.Receptionist.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Receptionist.Models.ReceptionistInfo;
import com.Receptionist.Repo.ReceptionistRepo;
import com.Receptionist.SecurityConfig.ReceptionistAuthResponse;
import com.Receptionist.SecurityConfig.ReceptionistService;

@RestController
@RequestMapping("/receptionist")
public class ReceptionistController {
	@Autowired
	private ReceptionistService receptionistService;
	@Autowired
	private ReceptionistRepo ownerRepo;
	@Autowired
	private AuthenticationManager authenticationManager;

//Creating/Adding Washer
	/*
	 * @PostMapping("/addwasher") public Washer saveWasher(@RequestBody Washer
	 * washer) { return washerService.addWasher(washer); }
	 */
	@PostMapping("/addOwner")
	private ResponseEntity<?> saveOwnerInfo(@RequestBody ReceptionistInfo ownerInfo) {
		String email = ownerInfo.getEmail();
		String password = ownerInfo.getPassword();
		ReceptionistInfo owner1 = new ReceptionistInfo();
		owner1.setEmail(email);
		owner1.setPassword(password);
		try {

			ownerRepo.save(ownerInfo);
		} catch (Exception e) {
			return ResponseEntity.ok(new ReceptionistAuthResponse("Error creating Receptionist" + email));
		}
		return ResponseEntity.ok(new ReceptionistAuthResponse("Successfully created Receptionist " + email));
	}

//authenticating washer
	@PostMapping("/auth")
	private ResponseEntity<?> authWasher(@RequestBody ReceptionistInfo managerInfo) {
		String email = managerInfo.getEmail();
		String password = managerInfo.getPassword();
	private ResponseEntity<?> authReceptionist(@RequestBody ReceptionistInfo receptionistInfo) {
		String email = receptionistInfo.getEmail();
		String password = receptionistInfo.getPassword();
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
		} catch (Exception e) {
			return ResponseEntity.ok(new ReceptionistAuthResponse("Error during Manager Authentication" + email));
			return ResponseEntity.ok(new ReceptionistAuthResponse("Error during Receptionist Authentication" + email));
		}
		return ResponseEntity.ok(new ReceptionistAuthResponse("Successfully Authenticated Manager" + email));
		return ResponseEntity.ok(new ReceptionistAuthResponse("Successfully Authenticated Receptionist" + email));
	}
//Reading all washer
	@GetMapping("/receptionist")
	public List<ReceptionistInfo> findAllReceptionist() {
		return receptionistService.getReceptionistInfos();
	}

}
