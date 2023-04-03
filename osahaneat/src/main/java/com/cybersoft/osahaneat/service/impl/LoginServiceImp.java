package com.cybersoft.osahaneat.service.impl;

import com.cybersoft.osahaneat.entity.Users;
import com.cybersoft.osahaneat.repository.UserRepository;
import com.cybersoft.osahaneat.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImp implements LoginService {
    @Autowired
    UserRepository userRepository;

    @Override
    public boolean login(String username, String password) {
        List<Users> listUser = userRepository.findUsersByEmailAndPassword(username, password);
        return listUser.size() > 0;
    }
}
