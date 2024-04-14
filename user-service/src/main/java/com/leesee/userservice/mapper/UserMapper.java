package com.leesee.userservice.mapper;

import com.leesee.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.RequestParam;

@Mapper
public interface UserMapper {
    /**
     * 通过id寻找user
     * @param id
     * @return
     */
    @Select("select * from user where id=#{id} ")
    User findById(Long id);

    @Select("select * from user where username =#{username}")
    User findByUsername(String username);

    @Insert("insert into user(username,password) values (#{username},#{password})")
    void insert(User user);


}
