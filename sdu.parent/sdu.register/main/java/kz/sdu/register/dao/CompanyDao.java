package kz.sdu.register.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface CompanyDao {
    @Select("select name from companytable where companyid = #{companyid}")
    String getNameOfCompany(@Param("companyid") String companyID);
}
