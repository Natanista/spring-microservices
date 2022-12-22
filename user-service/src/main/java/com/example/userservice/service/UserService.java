package com.example.userservice.service;

import com.example.userservice.VO.Department;
import com.example.userservice.VO.ResponseTemplateVO;
import com.example.userservice.entity.User;
import com.example.userservice.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
@Slf4j
public class UserService {

    private UserRepository userRepository;

    private RestTemplate restTemplate;

    public User saveUser(User user) {
        log.info("inside saveUser of UserService");
        return userRepository.save(user);
    }

    public ResponseTemplateVO getUserAndDepartmentById(Long userId) {
        log.info("inside getUserAndDepartmentById of UserService");
        ResponseTemplateVO responseTemplateVO = new ResponseTemplateVO();
        User user = userRepository.findById(userId).get();
        Department department =
                restTemplate.getForObject(
                        "http://localhost:9001/api/v1/departments/" + user.getDepartmentId(),
                        Department.class
                );
        responseTemplateVO.setUser(user);
        responseTemplateVO.setDepartment(department);

        return responseTemplateVO;
    }
}
