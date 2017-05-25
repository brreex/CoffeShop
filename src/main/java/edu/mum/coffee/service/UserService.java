package edu.mum.coffee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.coffee.domain.User;
import edu.mum.coffee.repository.UserRepository;

@Service
@Transactional
public class UserService   {
	
	@Autowired
	private UserRepository userRepository;
		
	public void save(User user) {
		userRepository.save(user);
	}

}
