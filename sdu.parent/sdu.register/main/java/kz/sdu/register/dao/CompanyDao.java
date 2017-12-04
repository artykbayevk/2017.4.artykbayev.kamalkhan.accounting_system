package kz.sdu.register.dao;

import kz.sdu.controller.model.CompanyInfo;
import kz.sdu.register.models.CompanyDot;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface CompanyDao {
    @Select("select name from companytable where companyid = #{companyid}")
    String getNameOfCompany(@Param("companyid") String companyID);

    @Select("select * from companytable where companyid = #{companyid}")
    CompanyDot getCompanyById(@Param("companyid") String companyID);

    @Select("select * from companytable")
    List<CompanyDot> getAllCompanies();

    @Select("select * from companytable where isaccepted = 'false'")
    List<CompanyDot> getAllNotAcceptedCompanies();

    @Update("update companytable set name = #{name}, telephone = #{telephone}," +
            "email = #{email} where companyid = #{companyid}")
    void updateCompanyById(@Param("companyid") String companyid,
                           @Param("name") String name,
                           @Param("telephone") String telephone,
                           @Param("email") String email);

    @Update("update companytable set isaccepted = 'true' where companyid = #{companyid}")
    void acceptCompanyQuery(@Param("companyid") String companyid);

    @Update("update companytable set isaccepted = 'decli' where companyid = #{companyid}")
    void declineCompanyQuery(@Param("companyid") String companyid);

    @Insert("insert into companytable values(#{companyid}, #{name}, #{telephone}, #{email}, #{isaccepted})")
    void insertIntoCompany(@Param("companyid") String companyid,
                           @Param("name") String name,
                           @Param("telephone") String telephone,
                           @Param("email") String email,
                           @Param("isaccepted") String isaccepted
    );
}
