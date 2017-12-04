package kz.sdu.register.dao;

import kz.sdu.register.models.LeadDot;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface LeadDao {

    @Select("select * from leadtable where leadid = #{leadid}")
    LeadDot getLeadById(@Param("leadid") String leadid);

    @Insert("insert into leadtable (leadid, name, type, managerid, clientid, status, isaccepted)" +
            "values(#{leadid}, #{name}, #{type}, #{managerid}, #{clientid}, #{status}, #{isaccepted})")
    void insertIntoLead(@Param("leadid") String leadid,
                        @Param("name") String name,
                        @Param("type") String type,
                        @Param("managerid") String managerid,
                        @Param("clientid") String clientid,
                        @Param("status") String status,
                        @Param("isaccepted") String isaccepted);

    @Update("update leadtable set name = #{name},type = #{type} where leadid = #{leadid}")
    void updateLead(@Param("leadid") String leadid,
                    @Param("name") String name,
                    @Param("type") String type);

    @Select("select * from leadtable")
    List<LeadDot> getAllLeadsListQuery();

    @Select("select * from leadtable where managerid = #{userid} or clientid = #{userid}")
    List<LeadDot> getAllMyLeadsQuery(@Param("userid") String userid);

    @Select("select * from leadtable where status = 'none' and managerid = #{userid}")
    List<LeadDot> getAllMyNotAcceptedLeadsQuery(@Param("userid") String userid);

    @Select("select * from leadtable where isaccepted='true' and managerid = #{userid} and status ='started' and clientid !='0' ")
    List<LeadDot> getAllMyAcceptedLeadsQuery(@Param("userid") String userid);

    @Select("select * from leadtable where isaccepted = 'false' ")
    List<LeadDot> getAllNotAcceptedLeadsQuery();

    @Select("select * from leadtable where isaccepted ='true' and clientid != #{clientid} and status = 'none'")
    List<LeadDot> getAllNotMyAcceptedLeads(@Param("clientid") String clientid);

    @Select("select * from leadtable where isaccepted = 'true' and clientid = #{clientid} and status ='started'")
    List<LeadDot> getAllMyActiveLeads(@Param("clientid") String clientid);

    @Update("update leadtable set status = 'stopped' where leadid = #{leadid}")
    void stopStatus(@Param("leadid") String leadid);

    @Update("update leadtable set status = 'started',clientid = #{clientid} where leadid = #{leadid}")
    void startStatus(@Param("leadid") String leadid,
                     @Param("clientid") String clientid);

    @Update("update leadtable set isaccepted = 'true' where leadid = #{leadid}")
    void acceptLeadQuery(@Param("leadid") String leadid);

    @Update("update leadtable set isaccepted = 'decli' where leadid = #{leadid}")
    void declineLeadQuery(@Param("leadid") String leadid);

    @Select("select * from leadtable where isaccepted = 'true' and clientid=#{clientid} and status ='stopped'")
    List<LeadDot> getAllMyFinishedLeads(@Param("clientid") String clientid);
}
