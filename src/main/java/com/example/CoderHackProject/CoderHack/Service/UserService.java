package com.example.CoderHackProject.CoderHack.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CoderHackProject.CoderHack.Exception.UserNotFoundException;
import com.example.CoderHackProject.CoderHack.Model.User;
import com.example.CoderHackProject.CoderHack.Respository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    public List<User> getAll(){
        return userRepository.findAll().stream().sorted((u1, u2) -> u2.getScore()-u1.getScore()).toList();
    }
    public User getUserWithId(String id){
        return userRepository.findById(id).orElseThrow(()-> new UserNotFoundException(id));
    }
    public User createUser(User user){
       user.setScore(0);
       user.setBadges(new HashSet<>());
        return userRepository.save(user);
    }
    
    public User updateUserDetails(String id, int score){
        User fetchedUser = userRepository.findById(id).orElseThrow(()-> new UserNotFoundException("User not found"));

        fetchedUser.setScore(score);
        Set<String> badges = new HashSet<>();

        if (score >=1 && score <=30){
            badges.add("Code Ninja");
        }
        if (score >=31 && score <=60){
            badges.add("Code Champ");
        }
        if (score >=61 && score <=90){
            badges.add("Code Master");
        }
        fetchedUser.setBadges(badges);
        return userRepository.save(fetchedUser);
    }

    public void deleteById(String id){
        userRepository.deleteById(id);
    }
}
