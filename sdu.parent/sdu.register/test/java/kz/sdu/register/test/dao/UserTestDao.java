package kz.sdu.register.test.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserTestDao {

    @Insert("insert into usertable (userid, name, surname, email, password, telephone,age, companyid, isaccepted,isadmin, ismanager)" +
            "values (#{userid},#{name},#{surname},#{email},#{password},#{telephone},#{age}, #{companyid}, #{isaccepted}, #{isadmin}, #{ismanager})")
    void insertPerson(@Param("userid") String userid,
                      @Param("name") String name,
                      @Param("surname") String surname,
                      @Param("email") String email,
                      @Param("password") String password,
                      @Param("telephone") String telephone,
                      @Param("age") String age,
                      @Param("companyid") String companyid,
                      @Param("isaccepted") String isaccepted,
                      @Param("isadmin") String isadmin,
                      @Param("ismanager") String ismanager);


//  Nope
    @Delete("delete from usertable where userid=#{userid}")
    void deleteUser(@Param("userid") String userid);

    @Select("select userid from accepttable where generatednumber=#{generatednumber}")
    String getUserIdFromAccept(@Param("generatednumber") String generatednumber);
}
