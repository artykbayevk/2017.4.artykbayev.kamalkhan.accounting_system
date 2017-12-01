package kz.sdu.register.dao;

import kz.sdu.register.models.UserDot;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserDao {
    @Select("select * from usertable where userid=#{id}")
    UserDot getWholeSelect(@Param("id") String id);
}
