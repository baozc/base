package cn.baozcc.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.springframework.util.StringUtils;

/**
 * 日期工具类<br>
 * 使用jdk8 time包实现
 *
 * @author baozhichao
 * @date 2018年1月10日 下午6:27:08
 */
@SuppressWarnings("unused")
public class TimeUtils {

    /**
     * yyyy-MM-dd HH:mm:ss
     */
    public static final String PATTERN_SECOND = "yyyy-MM-dd HH:mm:ss";

    /**
     * yyyy-MM-dd hh:mm:ss.SSS
     */
    public static final String PATTERN_MILLIS = "yyyy-MM-dd HH:mm:ss.SSS";

    /**
     * yyyy-MM-dd HH:mm:ss.SSS Z
     */
    public static final String PATTERN_Z = "yyyy-MM-dd HH:mm:ss.SSS Z";

    /**
     * yyyy-MM-dd <br>
     * 获取格式化后的当前日期
     *
     * @return 格式化后的日期
     * @auth baozhichao
     * @date 2018年1月10日 下午5:49:27
     */
    public static String formateDate() {
        return LocalDate.now().toString();
    }

    /**
     * 获取格式化后的日期<br>
     * yyyy-MM-dd hh:mm:ss.SSS
     *
     * @return yyyy-MM-dd hh:mm:ss.SSS
     * @author baozc
     * @date 2018年11月11日 17:54:48
     */
    public static String formateMilli() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(PATTERN_MILLIS));
    }

    /**
     * 获取格式化后的日期<br>
     * yyyy-MM-dd hh:mm:ss
     *
     * @return yyyy-MM-dd hh:mm:ss
     * @author baozc
     * @date 2018年11月11日 17:54:48
     */
    public static String formateSecond() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(PATTERN_SECOND));
    }

    /**
     * 获取当前时间timestamp
     * @return timestamp
     * @author baozc
     * @date 2019年06月27日 19:07:57
     */
    public static Timestamp getTimestamp() {
        return new Timestamp(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
    }

    /**
     * 获取hours小时前timestamp
     * @param hours 小时
     * @return timestamp
     * @author baozc
     * @date 2019年06月27日 19:06:24
     */
    public static Timestamp getMinusHoursTimestamp(int hours) {
        return new Timestamp(LocalDateTime.now().minusHours(hours).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
    }

    /**
     * 获取hours小时前时间 yyyy-MM-dd HH:mm:ss
     * @param hours 小时
     * @return 字符串
     * @author baozc
     * @date 2019年06月27日 19:06:24
     */
    public static String formateMinusHoursSecond(int hours) {
        return LocalDateTime.now().minusHours(hours).format(DateTimeFormatter.ofPattern(PATTERN_SECOND));
    }

    /**
     * 获取格式化后的日期<br>
     * yyyy-MM-dd hh:mm:ss.SSS Z
     *
     * @return yyyy-MM-dd hh:mm:ss.SSS Z
     * @author baozc
     * @date 2018年11月11日 17:54:48
     */
    public static String formateZone() {
        return ZonedDateTime.now().format(DateTimeFormatter.ofPattern(PATTERN_Z));
    }

    /**
     * 转换时间缀
     *
     * @param time 时间缀
     * @return yyyy-MM-dd hh:mm:ss.SSS
     * @author baozc
     * @date 2018年11月11日 18:02:52
     */
    public static String parseMilli(long time) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(time), ZoneId.systemDefault())
                .format(DateTimeFormatter.ofPattern(PATTERN_MILLIS));
    }

    public static String parse(long time, String pattern) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(time), ZoneId.systemDefault())
                .format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 转换时间缀
     *
     * @param time 时间缀
     * @return yyyy-MM-dd hh:mm:ss
     * @author baozc
     * @date 2018年11月11日 18:02:52
     */
    public static String parseSecond(long time) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(time), ZoneId.systemDefault())
                .format(DateTimeFormatter.ofPattern(PATTERN_SECOND));
    }

    /**
     * 转换时间缀
     *
     * @param time 时间缀
     * @return yyyy-MM-dd hh:mm:ss.SSS Z
     * @author baozc
     * @date 2018年11月11日 18:02:52
     */
    public static String parseZone(long time) {
        return ZonedDateTime.ofInstant(Instant.ofEpochMilli(time), ZoneId.systemDefault())
                .format(DateTimeFormatter.ofPattern(PATTERN_Z));
    }

    /**
     * 转换日期为时间缀
     *
     * @param str yyyy-MM-dd hh:mm:ss.SSS
     * @return 时间缀
     * @author baozc
     * @date 2018年11月11日 18:02:52
     */
    public static Long parseMilli(String str) {
        if (StringUtils.isEmpty(str)) {
            return null;
        }

        return LocalDateTime.parse(str, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS Z"))
                .atZone(ZoneId.systemDefault())
                .toInstant()
                .toEpochMilli();
    }

    public static Long parseMilliOfSecond(String str) {
        if (StringUtils.isEmpty(str)) {
            return null;
        }

        return LocalDateTime.parse(str, DateTimeFormatter.ofPattern(PATTERN_SECOND))
                .atZone(ZoneId.systemDefault())
                .toInstant()
                .toEpochMilli();
    }

    public static Long parse(String str, String pattern) {
        if (StringUtils.isEmpty(str)) {
            return null;
        }

        return LocalDateTime.parse(str, DateTimeFormatter.ofPattern(pattern))
                .atZone(ZoneId.systemDefault())
                .toInstant()
                .toEpochMilli();
    }


    /**
     * 转换日期为时间缀
     *
     * @param str yyyy-MM-dd hh:mm:ss
     * @return 时间缀
     * @author baozc
     * @date 2018年11月11日 18:02:52
     */
    public static Long parseSecond(String str) {
        if (StringUtils.isEmpty(str)) {
            return null;
        }

        return LocalDateTime.parse(str, DateTimeFormatter.ofPattern(PATTERN_SECOND))
                .atZone(ZoneId.systemDefault())
                .toInstant()
                .toEpochMilli();
    }

    /**
     * 转换日期为时间缀
     *
     * @param str yyyy-MM-dd hh:mm:ss Z
     * @return 时间缀
     * @author baozc
     * @date 2018年11月11日 18:02:52
     */
    public static Long parseZone(String str) {
        if (StringUtils.isEmpty(str)) {
            return null;
        }

        return ZonedDateTime.parse(str, DateTimeFormatter.ofPattern(PATTERN_Z)).toInstant().toEpochMilli();
    }

    /**
     * 获取当前毫秒值
     * @author baozc
     * @date 2018年11月12日 20:33:08
     */
    public static long getMilli(){
        return Instant.now().toEpochMilli();
    }

    /**
     * 获取当前时间缀的日期毫秒值
     * @param milli 毫秒
     * @return 2019-08-05 00:00:00.000 milli
     * @author baozc
     * @date 2019年08月05日 17:55:04
     */
    public static Long getCurrentDateMilli(Long milli) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(milli), ZoneId.systemDefault())
                .toLocalDate()
                .atTime(0, 0, 0)
                .atZone(ZoneId.systemDefault())
                .toInstant()
                .toEpochMilli();
    }

    /**
     * 获取当前时间缀日期
     * @param milli 毫秒值
     * @return 日期
     * @author baozc
     * @date 2019年08月05日 17:56:49
     */
    public static String getCurrentDate(Long milli) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(milli), ZoneId.systemDefault())
                .toLocalDate().toString();
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
