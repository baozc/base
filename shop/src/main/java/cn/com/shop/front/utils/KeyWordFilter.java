/** 
 * @autor linwk 2015年12月28日
 * 
 */
package cn.com.shop.front.utils;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class KeyWordFilter {
 
    private static Pattern pattern = null;
    private static int keywordsCount = 0;
 
    // 从words.properties初始化正则表达式字符串
    private static void initPattern() {
        StringBuffer patternBuffer = new StringBuffer();
        try {
            //words.properties
            InputStream in = KeyWordFilter.class.getClassLoader().getResourceAsStream("keywords.properties");
            Properties property = new Properties();
            property.load(in);
            Enumeration<?> enu = property.propertyNames();
            patternBuffer.append("(");
            while (enu.hasMoreElements()) {
                String scontent = (String) enu.nextElement();
                patternBuffer.append(scontent + "|");
                //System.out.println(scontent);
                keywordsCount ++;
            }
            patternBuffer.deleteCharAt(patternBuffer.length() - 1);
            patternBuffer.append(")");
            //System.out.println(patternBuffer);
            // unix换成UTF-8
            // pattern = Pattern.compile(new
            // String(patternBuf.toString().getBytes("ISO-8859-1"), "UTF-8"));
            // win下换成gb2312
            // pattern = Pattern.compile(new String(patternBuf.toString()
            // .getBytes("ISO-8859-1"), "gb2312"));
            // 装换编码
            pattern = Pattern.compile(patternBuffer.toString());
        } catch (IOException ioEx) {
            ioEx.printStackTrace();
        }
    }
 
    private static String doFilter(String str) {
        Matcher m = pattern.matcher(str);
//      while (m.find()) {// 查找符合pattern的字符串
//          System.out.println("The result is here :" + m.group());
//      }
        // 选择替换方式，这里以* 号代替
        str = m.replaceAll("*");
        return str;
    }
 
    public static String main(String str) {
        long startNumer = System.currentTimeMillis(); 
        initPattern();
        str = doFilter(str);
        return str;
    }
}