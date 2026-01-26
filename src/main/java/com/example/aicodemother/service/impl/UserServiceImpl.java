package com.example.aicodemother.service.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.example.aicodemother.model.entity.User;
import com.example.aicodemother.mapper.UserMapper;
import com.example.aicodemother.service.UserService;
import org.springframework.stereotype.Service;

/**
 * 用户 服务层实现。
 *
 * @author <a href="https://github.com/Kenneth0111">程序员张博洋</a>
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>  implements UserService{

}
