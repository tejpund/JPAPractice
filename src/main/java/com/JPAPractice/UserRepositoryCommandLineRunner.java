package com.JPAPractice;

import java.util.List;
import java.util.Optional;

import com.JPAPractice.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.JPAPractice.service.UserRepository;

@Component
public class UserRepositoryCommandLineRunner implements CommandLineRunner{

	private static final Logger log = 
			LoggerFactory.getLogger(UserRepositoryCommandLineRunner.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... arg0) throws Exception {
		User user = new User("Jill", "Admin");
		userRepository.save(user);
		log.info("New User is created : " + user);
		
		Optional<User> userWithIdOne = userRepository.findById(1L);
		log.info("User is retrived : " + userWithIdOne);

		List<User> users = userRepository.findAll();
		log.info("All Users : " + users);			
	}
	
}