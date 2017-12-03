package kz.sdu.register.dao;


import kz.sdu.controller.model.AuthInfo;
import kz.sdu.register.models.UserDot;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserDao {
    @Select("select * from usertable where userid=#{id}")
    UserDot getWholeSelect(@Param("id") String id);

    @Select("select email from usertable where email = #{email}")
    String checkEmail(@Param("email") String email);

    @Select("select isaccepted from usertable where userid = #{userid}")
    String checkIsAccepted(@Param("userid") String userid);

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

    @Update("update usertable set name = #{name}, " +
            "surname = #{surname}, email = #{email}, " +
            "password = #{password}, telephone = #{telephone}," +
            "age = #{age}, companyid = #{companyid} where userid = #{userid}")
    void updatePerson(@Param("userid") String userid,
                      @Param("name") String name,
                      @Param("surname") String surname,
                      @Param("email") String email,
                      @Param("password") String password,
                      @Param("telephone") String telephone,
                      @Param("age") String age,
                      @Param("companyid") String companyid);




    @Select("select userid from usertable where email=#{email} and password=#{password}")
    String getUserIdSelect(@Param("email") String email,
                           @Param("password") String password);

    @Select("select token from tokentable where userid=#{userid}")
    String getUserToken(@Param("userid") String userid);

    @Insert("insert into tokentable (token, userid) values(#{token}, #{userid})")
    void insertToken(@Param("userid") String userid,
                     @Param("token") String token);

    @Update("update tokentable set token = #{token} where userid = #{userid}")
    void updateToken(@Param("userid") String userid,
                     @Param("token") String token);


    @Select("select * from usertable")
    List<UserDot> getAllUsersList();

    @Select("select * from usertable where isaccepted ='false'")
    List<UserDot> getNotAcceptedUsers();

    @Select("update usertable set isaccepted = 'true' where userid = #{userid}")
    void acceptUser(@Param("userid") String userid);

    @Select("select userid from accepttable where generatednumber=#{generatednumber}")
    String getUserIdFromAccept(@Param("generatednumber") String generatednumber);

    @Insert("insert into accepttable (userid, generatednumber) values(#{userid}, #{generatednumber})")
    void insertIntoAcceptTable(@Param("userid") String userid,
                               @Param("generatednumber") String generatednumber);

    @Select("select email from usertable where userid=#{userid}")
    String getUserEmail(@Param("userid") String userid);

    @Update("update usertable set isaccepted='true' where userid = #{userid}")
    void updateIsAccept(@Param("userid") String userid);

    @Update("update usertable set isaccepted='decli' where userid = #{userid}")
    void declineUser(@Param("userid") String userid);
}
