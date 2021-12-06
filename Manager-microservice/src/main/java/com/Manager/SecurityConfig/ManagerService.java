package com.Manager.SecurityConfig;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.Manager.Models.ManagerInfo;
import com.Manager.Repo.ManagerRepo;

public class ManagerService {

}
@Service
public class ManagerService implements UserDetailsService {
	@Autowired
	private ManagerRepo ownerRepo;

	/*
	 * //for creating/adding washer[ public Washer addWasher(Washer washer) { return
	 * washerRepository.save(washer); }
	 */
//
	public List<ManagerInfo> getOwnerInfos() {
// TODO Auto-generated method stub
		List<ManagerInfo> ownerInfos = ownerRepo.findAll();
		System.out.println("Getting Owner from DB" + ownerInfos);
		return ownerInfos;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		ManagerInfo foundedOwner = ownerRepo.findByEmail(username);
		if (foundedOwner == null)
			return null;
		String Email = foundedOwner.getEmail();
		String Password = foundedOwner.getPassword();
		return new User(Email, Password, new ArrayList<>());
	}

	public List<ManagerInfo> getManagerInfos() {
		// TODO Auto-generated method stub
		return null;
	}
}
