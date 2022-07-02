package com.codelife.user.service;

import com.codelife.user.VO.Department;
import com.codelife.user.VO.ResponseTemplateOV;
import com.codelife.user.entity.User;
import com.codelife.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User findUserById(Long userId) {
        return userRepository.findById(userId).get();
    }

    public ResponseTemplateOV getUserWithId(Long userId) {
        ResponseTemplateOV vo= new ResponseTemplateOV();
        User user= userRepository.findById(userId).get();

        Department department=restTemplate.getForObject("http://DEPARTMENT-SERVICE/department/"+user.getDepartmentId(), Department.class);

        vo.setUser(user);
        vo.setDepartment(department);
        return vo;
    }
}
