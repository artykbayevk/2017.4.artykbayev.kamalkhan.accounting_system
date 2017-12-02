package kz.sdu.register.test.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface CompanyTestDao {

    @Insert("insert into companytable (companyid, name, telephone, email) values(#{companyid}, #{name}, #{telephone}, #{email})")
    void insertIntoCompany(@Param("companyid") String companyid,
                           @Param("name") String name,
                           @Param("telephone") String telephone,
                           @Param("email") String email);
}
