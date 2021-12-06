package com.Manager.Controller;

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

import com.Manager.Repo.ManagerRepo;
import com.Manager.SecurityConfig.ManagerAuthResponse;
import com.Manager.SecurityConfig.ManagerService;

@RestController
@RequestMapping("/Manager")
public class ManagerController {
	@Autowired
	private ManagerService ManagerService;
	@Autowired
	private ManagerRepo ManagerRepo;
	@Autowired
	private AuthenticationManager authenticationManager;

//Creating/Adding Washer
	/*
	 * @PostMapping("/addwasher") public Washer saveWasher(@RequestBody Washer
	 * washer) { return washerService.addWasher(washer); }
	 */
	@PostMapping("/addManager")
	private ResponseEntity<?> saveManagerInfo(@RequestBody ManagerInfo managerInfo) {
		String email = managerInfo.getEmail();
		String password = managerInfo.getPassword();
		ManagerInfo Manager1 = new managerInfo();
		manager1.setEmail(email);
		manager1.setPassword(password);
		try {

			ManagerRepo.save(managerInfo);
		} catch (Exception e) {
			return ResponseEntity.ok(new ManagerAuthResponse("Error creating Owner" + email));
		}
		return ResponseEntity.ok(new ManagerAuthResponse("Successfully created Owner " + email));
	}

//authenticating washer
	@PostMapping("/auth")
	private ResponseEntity<?> authWasher(@RequestBody managerInfo) {
		String email = ManagerInfo.getEmail();
		String password = ManagerInfo.getPassword();
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
		} catch (Exception e) {
			return ResponseEntity.ok(new ManagerAuthResponse("Error during Owner Authentication" + email));
		}
		return ResponseEntity.ok(new ManagerAuthResponse("Successfully Authenticated Owner" + email));
	}

//Reading all washer
	@GetMapping("/Manager")
	public <ManagerInfo> List<ManagerInfo> findAllManagers() {
		return ManagerService.getManagerInfos();
	}

}
