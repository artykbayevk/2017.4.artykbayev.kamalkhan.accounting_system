package kz.sdu.register.test.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;

public interface AuthTestDao {
  @Select("select NOW()")
  Date getSysdate();

  @Insert("insert into Person (id, accountName, encryptedPassword) " +
    "values (#{id},#{accountName},#{enPassword})")
  void insertPerson(@Param("id") String id,
                    @Param("accountName") String accountName,
                    @Param("enPassword") String enPassword);
}
