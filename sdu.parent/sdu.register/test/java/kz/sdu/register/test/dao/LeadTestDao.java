package kz.sdu.register.test.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface LeadTestDao {

    @Insert("insert into leadtable (leadid, name, type, managerid, clientid, status, isaccepted)" +
            "values(#{leadid}, #{name}, #{type}, #{managerid}, #{clientid}, #{status}, #{isaccepted})")
    void insertIntoLead(@Param("leadid") String leadid,
                        @Param("name") String name,
                        @Param("type") String type,
                        @Param("managerid") String managerid,
                        @Param("clientid") String clientid,
                        @Param("status") String status,
                        @Param("isaccepted") String isaccepted);


}
