package Rajesh.projectmanagementsystem.service;

import Rajesh.projectmanagementsystem.config.JwtProvider;
import Rajesh.projectmanagementsystem.model.User;
import Rajesh.projectmanagementsystem.repository.UserRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public User finUserProfileByJwt(String jwt) throws Exception {
        String email = JwtProvider.getEmailFromToken(jwt);
        return findUserByEmail(email);
    }

    @Override
    public User findUserByEmail(String email) throws Exception {
        User user = userRepository.findByEmail(email);
        if(user==null){
            throw new Exception("user not found");
        }
        return user;
    }

    @Override
    public User findUserById(Long userId) throws Exception {
        Optional<User> optionalUser = userRepository.findById(userId);
        if(optionalUser.isEmpty()){
            throw new Exception("user not found");
        }
        return optionalUser.get();
    }

    @Override
    public User updateUsersProjectSize(User user, int number) {
        user.setProjectSize(user.getProjectSize() + number);
        return userRepository.save(user);
    }
}