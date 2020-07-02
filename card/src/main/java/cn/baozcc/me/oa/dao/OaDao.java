package cn.baozcc.me.oa.dao;/**
 * @auth baozc
 * @date 2019/7/29 1:31 PM
 */

import java.util.List;

import cn.baozcc.me.model.PasmUser;
import cn.baozcc.me.oa.model.OaBean;
import cn.baozcc.me.oa.model.WorkLocationUserRelation;
import cn.baozcc.me.oa.model.request.AttendanceHistoryRequest;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.type.JdbcType;
import org.springframework.util.StringUtils;

/**
 * @author baozc
 * @date 2019/7/29 1:31 PM
 */
@SuppressWarnings("UnusedReturnValue")
// @Mapper
public interface OaDao {

    @SelectProvider(type = pasmSQL.class, method = "findByUserPhone")
    List<PasmUser> findByUserPhone(@Param("myphone") String myphone);

    @SelectProvider(type = pasmSQL.class, method = "findByAccount")
    List<PasmUser> findByAccount(@Param("account") String account);

    @SuppressWarnings("unused")
    class pasmSQL {

        public static String findByUserPhone(@Param("myphone") String myphone) {
            return commonSQL()
                    .WHERE("u.myphone=#{myphone}")
                    .WHERE("u.state!=3")
                    .toString();
        }

        public static String findByAccount(@Param("account") String account) {
            return commonSQL()
                    .WHERE("u.account=#{account}")
                    .WHERE("u.state != 3")
                    .toString();
        }

        private static String pasmColumn() {
            return "u.account, u.password, u.dept_id, u.deppath, u.username, " +
                    "u.pinyin, u.myphone, u.telephone, u.vnumber, u.email, " +
                    "u.address, u.personorder, u.employee_num, u.sex, u.note, u.state, " +
                    "u.createtime, u.updatetime, u.deletetime, u.rspcode, u.rspdesc";
        }

        private static SQL commonSQL() {
            return new SQL().SELECT(pasmColumn())
                    .SELECT("o.deptname")
                    .FROM("pasm_user u")
                    .INNER_JOIN("pasm_organization o on u.dept_id = o.dept_id");
        }
    }

    @Select("select longitude, latitude, worklocation, worklocation_alias, distance from me_worklocation_user_relation where account=#{account}")
    @Results({
            @Result(property = "longitude", column = "longitude", javaType = Double.class, jdbcType = JdbcType.VARCHAR),
            @Result(property = "latitude", column = "latitude", javaType = Double.class, jdbcType = JdbcType.VARCHAR),
            @Result(property = "distance", column = "distance", javaType = Double.class, jdbcType = JdbcType.VARCHAR),
            @Result(property = "worklocation", column = "worklocation", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(property = "worklocationAlias", column = "worklocation_alias", javaType = String.class, jdbcType = JdbcType.VARCHAR)
    })
    List<WorkLocationUserRelation> findWorklocationByAccount(String account);

    @Select("select id, userphone, username, deptid, deptname, local_latitude, local_longitude, local_addrStr, " +
            "local_addrStr_alias, locType, timecard, createtime, createtimeMillisecond, " +
            "resType, reason, os, imei from me_oa_attendance " +
            "where userphone=#{userPhone} and timecard=#{timecard} and createtime >= #{createtime}")
    @Results(id = "oaResult", value = {
            @Result(property = "id", column = "id", id = true),
            @Result(property = "userPhone", column = "userphone"),
            @Result(property = "username", column = "username"),
            @Result(property = "deptid", column = "deptid"),
            @Result(property = "deptname", column = "deptname"),
            @Result(property = "latitude", column = "local_latitude"),
            @Result(property = "longitude", column = "local_longitude"),
            @Result(property = "addrStr", column = "local_addrStr"),
            @Result(property = "addrStrAlias", column = "local_addrStr_alias"),
            @Result(property = "locType", column = "locType"),
            @Result(property = "timecard", column = "timecard"),
            @Result(property = "createtime", column = "createtime"),
            @Result(property = "createtimeMillisecond", column = "createtimeMillisecond"),
            @Result(property = "resType", column = "resType", javaType = Integer.class, jdbcType = JdbcType.VARCHAR),
            @Result(property = "reason", column = "reason"),
            // @Result(property = "time", column = "time"),
            @Result(property = "os", column = "os"),
            @Result(property = "imei", column = "imei")

    })
    OaBean findAttendanceByUser(OaBean oa);

    @UpdateProvider(type = attendanceSQL.class, method = "update")
    int updateAttendance(OaBean oa);

    @InsertProvider(type = attendanceSQL.class, method = "save")
    int saveAttendance(OaBean oa);

    @SuppressWarnings("unused")
    class attendanceSQL {

        public static String update(OaBean oa) {
            return new SQL().UPDATE("me_oa_attendance")
                    .SET("userphone=#{userPhone}")
                    .SET("username=#{username}")
                    .SET("deptid=#{deptid}")
                    .SET("deptname=#{deptname}")
                    .SET("local_latitude=#{latitude}")
                    .SET("local_longitude=#{longitude}")
                    .SET("local_addrStr=#{addrStr}")
                    .SET("local_addrStr_alias=#{addrStrAlias}")
                    .SET("timecard=#{timecard}")
                    .SET("resType=#{resType}")
                    .SET("locType=#{locType}")
                    .SET("createtime=#{createtime}")
                    .SET("createtimeMillisecond=#{createtimeMillisecond}")
                    .SET("os=#{os}")
                    .WHERE("id=#{id}")
                    .toString();

        }

        public static String save(OaBean oa) {
            return new SQL().INSERT_INTO("me_oa_attendance")
                    .VALUES("id", "#{id}")
                    .VALUES("userphone", "#{userPhone}")
                    .VALUES("username", "#{username}")
                    .VALUES("deptid", "#{deptid}")
                    .VALUES("deptname", "#{deptname}")
                    .VALUES("local_latitude", "#{latitude}")
                    .VALUES("local_longitude", "#{longitude}")
                    .VALUES("local_addrStr", "#{addrStr}")
                    .VALUES("local_addrStr_alias", "#{addrStrAlias}")
                    .VALUES("timecard", "#{timecard}")
                    .VALUES("resType", "#{resType}")
                    .VALUES("locType", "#{locType}")
                    .VALUES("createtime", "#{createtime}")
                    .VALUES("createtimeMillisecond", "#{createtimeMillisecond}")
                    .VALUES("os", "#{os}")
                    .toString();
        }

        public static String query(OaBean oaBean) {
            SQL sql = new SQL().SELECT(column())
                    .FROM("me_oa_attendance moa");

            if (StringUtils.hasText(oaBean.getUserPhone())) {
                sql.WHERE("userphone = #{userPhone}");
            }
            if (StringUtils.hasText(oaBean.getTimecard())) {
                sql.WHERE("timecard = #{timecard}");
            }
            if (StringUtils.hasText(oaBean.getUserPhone())) {
                sql.WHERE("userphone = #{userPhone}");
            }
            if (StringUtils.hasText(oaBean.getUserPhone())) {
                sql.WHERE("userphone = #{userPhone}");
            }
            if (StringUtils.hasText(oaBean.getUserPhone())) {
                sql.WHERE("userphone = #{userPhone}");
            }
            if (StringUtils.hasText(oaBean.getUserPhone())) {
                sql.WHERE("userphone = #{userPhone}");
            }
            if (StringUtils.hasText(oaBean.getUserPhone())) {
                sql.WHERE("userphone = #{userPhone}");
            }

            return sql.toString();
        }

        public static String column(){
            return "moa.id,moa.userphone,moa.username,moa.deptid,moa.deptname,moa.local_latitude,moa.local_longitude,moa.local_addrStr," +
                    "moa.local_addrStr_alias,moa.timecard,moa.createtime,moa.createtimeMillisecond,moa.resType";
        }
    }

    @Insert("INSERT INTO me_oa_attendance_exception_logs " +
            "( account, username, timecard, longitude, latitude,local_addrStr, " +
            "os,exception_card, createtime ) VALUES " +
            "(#{account}, #{username}, #{timecard}, #{longitude}, #{latitude}, #{addrStr}, #{os}, #{exceptionCard}, #{createtime})")
    int saveExceptionCard(OaBean oaBean);

    @Select("SELECT id,userphone,username,deptid,deptname,local_latitude,local_longitude,local_addrStr," +
            "local_addrStr_alias,timecard,createtime,createtimeMillisecond,resType FROM me_oa_attendance " +
            "where userphone=#{userPhone} and createtimeMillisecond > #{startTime} and createtimeMillisecond < #{endTime} " +
            "order by createtimeMillisecond")
    @ResultMap("oaResult")
    List<OaBean> findAtendanceHistory(AttendanceHistoryRequest today);

}
