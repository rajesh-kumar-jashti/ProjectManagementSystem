package Rajesh.projectmanagementsystem.service;

import Rajesh.projectmanagementsystem.model.User;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;


public interface UserService {

    User findUserProfileByJwt(String jwt) throws Exception;

    User findUserByEmail(String email) throws Exception;

    User findUserById(Long UserId) throws Exception;

    User updateUsersProjectSize(User user, int number);
}
