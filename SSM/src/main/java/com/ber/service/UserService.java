package com.ber.service;

import com.ber.bean.User;
import com.ber.dao.UserMapper;
import com.ber.dto.UserDto;
import com.ber.utils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import java.util.List;

/**
 * 版权所有：宝润兴业科技股份有限公司
 * 类描述：${DESCRIPTION}
 * 创建时间：2018/11/9 10:35
 *
 * @author 朱超
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 查询用户列表
     * @return
     */
    public List<UserDto> selectUserList(){
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        //criteria.andEqualTo("type","1");
        //criteria.andIn("",new ArrayList<String>());
        List<User> findUsers = userMapper.selectByExample(example);
        final List<UserDto> userDtos = BeanUtils.copyList(findUsers, UserDto.class);
        return userDtos;
    }

    /**
     * 测试  根据主键ID 获取 user
     * @param id
     * @return
     */
    public UserDto getUserById(Integer id){
        final User user = userMapper.selectByPrimaryKey(id);
        return BeanUtils.copyProps(user,UserDto.class);
    }
}
