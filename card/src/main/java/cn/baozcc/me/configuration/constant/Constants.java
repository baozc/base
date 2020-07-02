package cn.baozcc.me.configuration.constant;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author baozc
 * @date 2019/7/22 2:19 PM
 */
@Component
@ConfigurationProperties(prefix = "card")
public class Constants {

    /**
     * 设置ConnectionPoolTimeout：这定义了从ConnectionManager管理的连接池中取出连接的超时时间，此处设置为1秒
     * @author zhaochen  2014-1-23 上午09:40:41
     */
    public static String  HTTP_CONNMANAGER_TIMEOUT;
    /**
     * 设置ConnectionTimeout：　　这定义了通过网络与服务器建立连接的超时时间。
     * Httpclient包中通过一个异步线程去创建与服务器的socket连接，这就是该socket连接的超时时间，此处设置为2秒。
     * @author zhaochen  2014-1-23 上午09:41:05
     */
    public static String  HTTP_CONNECTION_TIMEOUT;
    /**
     * 设置SocketTimeout：　　　　这定义了Socket读数据的超时时间，即从服务器获取响应数据需要等待的时间，此处设置为4秒。
     * @author zhaochen  2014-1-23 上午09:41:33
     */
    public static String  HTTP_CONNECTION_SOTIMEOUT;


    /**
     * 应用比对全局map
     * @author zhaochen  2013-8-26 下午04:36:24
     */
    public static Map<String,String> dbAppMap;

    /**
     * 应用信息map
     * @author zhaochen  2013-8-26 下午04:36:24
     */
    public static Map<String,String> appInfoMap;

    /**
     * pasm集成路径
     * @author zhaochen  2013-9-5 下午02:48:28
     */
    public static String pasmUri;

    /**
     * pasm 鉴权插件 url
     * @author zhaochen  2013-9-5 下午02:49:30
     */
    public static String pasmTokenPluginUri;

    /**
     * 参数加密密钥
     * @author zhaochen  2013-9-5 下午02:58:28
     */
    public static String meSecurityKey;

    /**
     * 信息通道服务url
     * @author zhaochen  2013-9-5 下午02:58:28
     */
    public static String meChannel;

    /**
     * 图片服务器url
     * @author zhaochen  2013-9-5 下午02:58:28
     */
    public static String meMultimedia;

    /**
     * 鉴权服务url
     * @author zhaochen  2013-9-5 下午02:58:28
     */
    public static String meOpenAuth;
    /**
     * 鉴权服务端口
     * @author zhaochen  2013-9-5 下午02:58:28
     */
    public static String meOpenAuthPort;
    public static String meOpenAuthHttpsPort;
    /**
     * MeOpen服务端口
     * @author zhaochen  2013-9-5 下午02:58:28
     */
    public static String meOpenPort;

    /**
     * pmo通道服务url
     * @author zhaochen  2013-9-5 下午02:58:28
     */
    public static String pmoChannel;

    /**
     * 微分享手机端小字报url
     * @author zhaochen  2013-9-5 下午02:58:28
     */
    public static String circleChannel;

    /**
     * 默认工作地点经度
     */
    public static double defaultLon;
    /**
     * 默认工作地点纬度
     */
    public static double defaultLat;
    public static String defaultDistance;
    public static String worklocation;
    public static String worklocationAlias;

    public static double distance(){
        return Double.parseDouble(defaultDistance);
    }

    /**
     * 生产环境appkey,spid,spps
     */
    public static String appkey="PMORL";
    public static String spid="855680eedaf52b5fba7d0a3761e9d6e4";
    public static String spps="ajcgdt";







    /**
     * 会议室固定推送电话号码
     * @author zhaochen  2013-10-14 上午10:30:55
     */
    public static String fromPhoneOa="ultrapoweroa";

    /**
     * 会议室固定appkey
     * @author zhaochen  2013-10-14 上午10:30:55
     */
    public static String domsOa="schedule";

    /**
     * 应用注册文件上传类型 xml
     * @author zhaochen  2013-10-21 下午02:10:39
     */
    public static String xmlUploadType="xml";

    /**
     * 应用注册文件上传类型 image
     * @author zhaochen  2013-10-21 下午02:10:39
     */
    public static String imageUploadType="img";

    /**
     * 数据库连接url
     * @author zhaochen  2013-11-5 下午03:11:06
     */
    public static String DB_DRIVER;

    /**
     * 初始化app信息
     * @author zhaochen  2013-11-5 下午03:11:06
     */
    public static String initApp;

    /**
     * 初始化第1页
     * @author zhaochen  2013-12-23 下午05:10:20
     */
    public static String pageNo="1";

    /**
     * 初始化每页显示10条
     * @author zhaochen  2013-12-23 下午05:10:37
     */
    public static String pageSize="10";

    /**
     * 权限开放的app
     * @author zhaochen  2014-2-12 上午11:01:51
     */
    public static String APP_ROLE_OPEN="open";
    /**对人授权的app
     * @author zhaochen  2014-2-12 上午11:01:59
     */
    public static String APP_ROLE_BYPERSON="byPerson";

    /**
     * 用户取消关注 app
     * @author zhaochen  2014-2-12 上午11:01:59
     */
    public static String APP_USER_STATUS_FALSE="0";
    /**
     * 用户关注 app
     * @author zhaochen  2014-2-12 上午11:01:59
     */
    public static String APP_USER_STATUS_TRUE="1";

    /**
     * 需要过滤的部门名
     */
    public static String rootDept;
    /**
     * 需要
     */
    public static String emailList;
    /**
     * 是否使用PMO标记
     */
    public static String isUsePmo;

    /**
     * 是否使用PMO标记
     */
    public static String isUsePmoV1;
    /**
     * 上班时间
     */
    public static String attendanceTime;
    /**
     * 下班时间
     */
    public static String closingTime;

    /**
     *
     * 消息推送 判断是通过手机号（mobile）推送还是账号（account）推送
     *
     */
    public static String config_app_getInfoType;

    public static String config_app_mobile="mobile";

    /**
     * 公共配置Map对象
     *
     */
    public static Map<String,String> publicSetMap=new HashMap<String, String>();
    /**
     * 是否允许范围外打卡
     */
    public static String isAllowOutside;

    public String getHttpConnmanagerTimeout() {
        return HTTP_CONNMANAGER_TIMEOUT;
    }

    public void setHttpConnmanagerTimeout(String httpConnmanagerTimeout) {
        HTTP_CONNMANAGER_TIMEOUT = httpConnmanagerTimeout;
    }

    public String getHttpConnectionTimeout() {
        return HTTP_CONNECTION_TIMEOUT;
    }

    public void setHttpConnectionTimeout(String httpConnectionTimeout) {
        HTTP_CONNECTION_TIMEOUT = httpConnectionTimeout;
    }

    public String getHttpConnectionSotimeout() {
        return HTTP_CONNECTION_SOTIMEOUT;
    }

    public void setHttpConnectionSotimeout(String httpConnectionSotimeout) {
        HTTP_CONNECTION_SOTIMEOUT = httpConnectionSotimeout;
    }

    public Map<String, String> getDbAppMap() {
        return dbAppMap;
    }

    public void setDbAppMap(Map<String, String> dbAppMap) {
        Constants.dbAppMap = dbAppMap;
    }

    public Map<String, String> getAppInfoMap() {
        return appInfoMap;
    }

    public void setAppInfoMap(Map<String, String> appInfoMap) {
        Constants.appInfoMap = appInfoMap;
    }

    public String getPasmUri() {
        return pasmUri;
    }

    public void setPasmUri(String pasmUri) {
        Constants.pasmUri = pasmUri;
    }

    public String getPasmTokenPluginUri() {
        return pasmTokenPluginUri;
    }

    public void setPasmTokenPluginUri(String pasmTokenPluginUri) {
        Constants.pasmTokenPluginUri = pasmTokenPluginUri;
    }

    public String getMeSecurityKey() {
        return meSecurityKey;
    }

    public void setMeSecurityKey(String securityKey) {
        Constants.meSecurityKey = securityKey;
    }

    public String getMeChannel() {
        return meChannel;
    }

    public void setMeChannel(String channel) {
        Constants.meChannel = channel;
    }

    public String getMeMultimedia() {
        return meMultimedia;
    }

    public void setMeMultimedia(String multimedia) {
        Constants.meMultimedia = multimedia;
    }

    public String getMeOpenAuth() {
        return meOpenAuth;
    }

    public void setMeOpenAuth(String meOpenAuth) {
        Constants.meOpenAuth = meOpenAuth;
    }

    public String getMeOpenAuthPort() {
        return meOpenAuthPort;
    }

    private static String  s1;
    public void setMeOpenAuthPort(String meOpenAuthPort) {
        Constants.meOpenAuthPort = meOpenAuthPort;
    }
    public void setMeOpenAuthPort1(String s1) {
        Constants.s1 = s1;
    }

    public void setMeOpenAuthHttpsPort(String meOpenAuthHttpsPort) {
        Constants.meOpenAuthHttpsPort = meOpenAuthHttpsPort;
    }

    public String getMeOpenPort() {
        return meOpenPort;
    }

    public void setMeOpenPort(String meOpenPort) {
        Constants.meOpenPort = meOpenPort;
    }

    public String getPmoChannel() {
        return pmoChannel;
    }

    public void setPmoChannel(String pmoChannel) {
        Constants.pmoChannel = pmoChannel;
    }

    public String getCircleChannel() {
        return circleChannel;
    }

    public void setCircleChannel(String circleChannel) {
        Constants.circleChannel = circleChannel;
    }

    public double getDefaultLon() {
        return defaultLon;
    }

    public void setDefaultLon(double defaultLon) {
        Constants.defaultLon = defaultLon;
    }

    public double getDefaultLat() {
        return defaultLat;
    }

    public void setDefaultLat(double defaultLat) {
        Constants.defaultLat = defaultLat;
    }

    public String getAppkey() {
        return appkey;
    }

    public void setAppkey(String appkey) {
        Constants.appkey = appkey;
    }

    public String getSpid() {
        return spid;
    }

    public void setSpid(String spid) {
        Constants.spid = spid;
    }

    public String getSpps() {
        return spps;
    }

    public void setSpps(String spps) {
        Constants.spps = spps;
    }

    public String getFromPhoneOa() {
        return fromPhoneOa;
    }

    public void setFromPhoneOa(String fromPhoneOa) {
        Constants.fromPhoneOa = fromPhoneOa;
    }

    public String getDomsOa() {
        return domsOa;
    }

    public void setDomsOa(String domsOa) {
        Constants.domsOa = domsOa;
    }

    public String getXmlUploadType() {
        return xmlUploadType;
    }

    public void setXmlUploadType(String xmlUploadType) {
        Constants.xmlUploadType = xmlUploadType;
    }

    public String getImageUploadType() {
        return imageUploadType;
    }

    public void setImageUploadType(String imageUploadType) {
        Constants.imageUploadType = imageUploadType;
    }

    public String getDbDriver() {
        return DB_DRIVER;
    }

    public void setDbDriver(String dbDriver) {
        DB_DRIVER = dbDriver;
    }

    public String getInitApp() {
        return initApp;
    }

    public void setInitApp(String initApp) {
        Constants.initApp = initApp;
    }

    public String getPageNo() {
        return pageNo;
    }

    public void setPageNo(String pageNo) {
        Constants.pageNo = pageNo;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        Constants.pageSize = pageSize;
    }

    public String getAppRoleOpen() {
        return APP_ROLE_OPEN;
    }

    public void setAppRoleOpen(String appRoleOpen) {
        APP_ROLE_OPEN = appRoleOpen;
    }

    public String getAppRoleByperson() {
        return APP_ROLE_BYPERSON;
    }

    public void setAppRoleByperson(String appRoleByperson) {
        APP_ROLE_BYPERSON = appRoleByperson;
    }

    public String getAppUserStatusFalse() {
        return APP_USER_STATUS_FALSE;
    }

    public void setAppUserStatusFalse(String appUserStatusFalse) {
        APP_USER_STATUS_FALSE = appUserStatusFalse;
    }

    public String getAppUserStatusTrue() {
        return APP_USER_STATUS_TRUE;
    }

    public void setAppUserStatusTrue(String appUserStatusTrue) {
        APP_USER_STATUS_TRUE = appUserStatusTrue;
    }

    public String getRootDept() {
        return rootDept;
    }

    public void setRootDept(String rootDept) {
        Constants.rootDept = rootDept;
    }

    public String getEmailList() {
        return emailList;
    }

    public void setEmailList(String emailList) {
        Constants.emailList = emailList;
    }

    public String getIsUsePmo() {
        return isUsePmo;
    }

    public void setIsUsePmo(String isUsePmo) {
        Constants.isUsePmo = isUsePmo;
    }

    public String getIsUsePmoV1() {
        return isUsePmoV1;
    }

    public void setIsUsePmoV1(String isUsePmoV1) {
        Constants.isUsePmoV1 = isUsePmoV1;
    }

    public String getAttendanceTime() {
        return attendanceTime;
    }

    public void setAttendanceTime(String attendanceTime) {
        Constants.attendanceTime = attendanceTime;
    }

    public String getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(String closingTime) {
        Constants.closingTime = closingTime;
    }

    public String getConfig_app_getInfoType() {
        return config_app_getInfoType;
    }

    public void setConfig_app_getInfoType(String config_app_getInfoType) {
        Constants.config_app_getInfoType = config_app_getInfoType;
    }

    public Map<String, String> getPublicSetMap() {
        return publicSetMap;
    }

    public void setPublicSetMap(Map<String, String> publicSetMap) {
        Constants.publicSetMap = publicSetMap;
    }

    public String getIsAllowOutside() {
        return isAllowOutside;
    }

    public void setIsAllowOutside(String isAllowOutside) {
        Constants.isAllowOutside = isAllowOutside;
    }

    public static String s;
    public static String oneTwo;

    public void setS(String s) {
        Constants.s = s;
    }

    public void setOneTwo(String s) {
        Constants.oneTwo = s;
    }

    public String getDefaultDistance() {
        return defaultDistance;
    }

    public void setDefaultDistance(String defaultDistance) {
        Constants.defaultDistance = defaultDistance;
    }

    public String getWorklocation() {
        return worklocation;
    }

    public void setWorklocation(String worklocation) {
        Constants.worklocation = worklocation;
    }

    public String getWorklocationAlias() {
        return worklocationAlias;
    }

    public void setWorklocationAlias(String worklocationAlias) {
        Constants.worklocationAlias = worklocationAlias;
    }

    public static String s() {
        final StringBuffer sb = new StringBuffer("Constants{")
                .append(", s: ").append(s)
                .append(", oneTwo: ").append(oneTwo)
                .append(", HTTP_CONNMANAGER_TIMEOUT: ").append(HTTP_CONNMANAGER_TIMEOUT)
                .append(", HTTP_CONNECTION_TIMEOUT: ").append(HTTP_CONNECTION_TIMEOUT)
                .append(", HTTP_CONNECTION_SOTIMEOUT: ").append(HTTP_CONNECTION_SOTIMEOUT)
                .append(", pasmUri: ").append(pasmUri)
                .append(", pasmTokenPluginUri: ").append(pasmTokenPluginUri)
                .append(", meSecurityKey: ").append(meSecurityKey)
                .append(", meChannel: ").append(meChannel)
                .append(", meMultimedia: ").append(meMultimedia)
                .append(", meOpenAuth: ").append(meOpenAuth)
                .append(", meOpenAuthPort: ").append(meOpenAuthPort)
                .append(", meOpenAuthHttpsPort: ").append(meOpenAuthHttpsPort)
                .append(", meOpenPort: ").append(meOpenPort)
                .append(", pmoChannel: ").append(pmoChannel)
                .append(", circleChannel: ").append(circleChannel)
                .append(", defaultLon: ").append(defaultLon)
                .append(", defaultLat: ").append(defaultLat)
                .append(", appkey: ").append(appkey)
                .append(", spid: ").append(spid)
                .append(", spps: ").append(spps)
                .append(", fromPhoneOa: ").append(fromPhoneOa)
                .append(", domsOa: ").append(domsOa)
                .append(", xmlUploadType: ").append(xmlUploadType)
                .append(", imageUploadType: ").append(imageUploadType)
                .append(", DB_DRIVER: ").append(DB_DRIVER)
                .append(", initApp: ").append(initApp)
                .append(", rootDept: ").append(rootDept)
                .append(", emailList: ").append(emailList)
                .append(", isUsePmo: ").append(isUsePmo)
                .append(", isUsePmoV1: ").append(isUsePmoV1)
                .append(", attendanceTime: ").append(attendanceTime)
                .append(", closingTime: ").append(closingTime)
                .append(", config_app_getInfoType: ").append(config_app_getInfoType)
                .append(", isAllowOutside: ").append(isAllowOutside);
        sb.append('}');
        return sb.toString();
    }

}
