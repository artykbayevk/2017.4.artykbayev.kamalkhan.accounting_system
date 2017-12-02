package kz.sdu.register.test.dao;

import kz.sdu.register.models.CompanyDot;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface CompanyTestDao {

    @Insert("insert into companytable values(#{companyid}, #{name}, #{telephone}, #{email}, #{isaccepted})")
    void insertIntoCompany(@Param("companyid") String companyid,
                           @Param("name") String name,
                           @Param("telephone") String telephone,
                           @Param("email") String email,
                           @Param("isaccepted") String isaccepted
                           );

    @Select("select * from companytable where companyid = #{companyid}")
    CompanyDot getCompanyById(@Param("companyid") String companyid);

}
