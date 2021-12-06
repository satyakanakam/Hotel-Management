package com.Receptionist.SecurityConfig;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.Receptionist.Models.ReceptionistInfo;
import com.Receptionist.Repo.ReceptionistRepo;

@Service
public class ReceptionistService implements UserDetailsService {
	@Autowired
	private ReceptionistRepo receptionistRepo;

	/*
	 * //for creating/adding washer[ public Washer addWasher(Washer washer) { return
	 * washerRepository.save(washer); }
	 */
//
	public List<ReceptionistInfo> getOwnerInfos() {
// TODO Auto-generated method stub
		List<ReceptionistInfo> ownerInfos = receptionistRepo.findAll();
		System.out.println("Getting Owner from DB" + ownerInfos);
		return ownerInfos;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		ReceptionistInfo foundedOwner = receptionistRepo.findByEmail(username);
		if (foundedOwner == null)
			return null;
		String Email = foundedOwner.getEmail();
		String Password = foundedOwner.getPassword();
		return new User(Email, Password, new ArrayList<>());
	}

	public static List<ReceptionistInfo> getReceptionistInfos() {
		// TODO Auto-generated method stub
		return null;
	}
}
