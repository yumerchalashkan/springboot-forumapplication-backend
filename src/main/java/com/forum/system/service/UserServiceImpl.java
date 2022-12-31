package com.forum.system.service;

import com.forum.system.entity.User;
import com.forum.system.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow();
    }

    @Override
    public User updateUser(Long id, User user) {
        return userRepository.findById(id)
                .map(u -> {
                    u.setUsername(user.getUsername());
                    u.setPassword(user.getPassword());
                    return userRepository.save(u);
                })
                .orElseThrow();
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }


}

