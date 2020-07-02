package cn.baozcc.me.oa.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

/**
 * @author baozc
 * @date 2019/7/29 2:31 PM
 */
@Data
public class WorkLocationUserRelation {
    @JsonIgnore
    private Integer id;
    private double longitude;
    private double latitude;
    private String worklocation;
    private double distance;
    @JsonIgnore
    private String account;
    @JsonIgnore
    private String createtime;
    @JsonIgnore
    private long createtimeMillisecond;
    private String worklocationAlias;
}
