package com.example.codeclan.next_best_friend;

import com.example.codeclan.next_best_friend.models.User;
import com.example.codeclan.next_best_friend.models.UserDetailsModel;
import com.example.codeclan.next_best_friend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Optional<User> user = this.userRepository.findByUsername(name);
        System.out.println("<<<FINDING USER>>>");
        if (!user.isPresent()) {
            System.out.println("<<<NO USER FOUND>>>");
            throw new UsernameNotFoundException(name + "Not Found");
        }
//        user.orElseThrow(() -> new UsernameNotFoundException());
        return user.map(UserDetailsModel::new).get();
    }

}
