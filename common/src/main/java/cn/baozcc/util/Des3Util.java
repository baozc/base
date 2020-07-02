package cn.baozcc.util;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

import cn.baozcc.util.Exception.SigException;

/**
 * 3DES加密工具类
 */
public class Des3Util {
    // 密钥
    private static String secretKey = "ultrapower1@lx100$#365#$";
    // 向量
    private final static String iv = "01234567";
    // 加解密统一使用的编码方式
    private final static String encoding = "UTF-8";

    /**
     * 3DES加密
     *
     * @param plainText 普通文本
     * @return
     * @throws Exception
     */
    public static String encode(String plainText) {
        return encodeAlgorithm(plainText, secretKey);
    }

    public static String encode(String plainText, String secretKey) {
        return encodeAlgorithm(plainText, secretKey);
    }

    /**
     * 加密算法
     * @param plainText 普通文本
     * @param secretKey 密钥
     * @return 加密串
     * @author baozc
     * @date 2019年07月22日 17:43:54
     */
    private static String encodeAlgorithm(String plainText, String secretKey) {
        try {
            Key deskey;
            DESedeKeySpec spec = new DESedeKeySpec(secretKey.getBytes());
            SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("desede");
            deskey = keyfactory.generateSecret(spec);

            Cipher cipher = Cipher.getInstance("desede/CBC/PKCS5Padding");
            IvParameterSpec ips = new IvParameterSpec(iv.getBytes());
            cipher.init(Cipher.ENCRYPT_MODE, deskey, ips);
            byte[] encryptData = cipher.doFinal(plainText.getBytes(encoding));
            return Base64.getEncoder().encodeToString(encryptData);
        } catch (Exception e) {
            throw new SigException(e);
        }
    }

    // public static void main(String[] args) throws Exception {
    //     String s = encode("12345678910_123456");
    //     System.out.println(s);

//		System.out.println(encode("bao","97ced77d90ff68faf4f1a00aaccafbee"));
//		
//		String key = CipherUtil.generateDESKey("01234567");
////		String key = CipherUtil.generateDESKey("ultrapower1@lx100$#365#$");
//		System.out.println(CipherUtil.DESEncrypt("bao", key));
//		System.out.println(decode(s));
//		System.out.println("解密："+CipherUtil.DESDecrypt(s, key));

    // }

    /**
     * 3DES解密
     *
     * @param encryptText 加密文本
     * @return
     * @throws Exception
     */
    public static String decode(String encryptText) throws Exception {
        return decoceAlgorithm(encryptText, secretKey);
    }

    /**
     * 解密算法
     * @param encryptText 加密串
     * @param secretKey 密钥
     * @return 普通文本
     * @author baozc
     * @date 2019年07月22日 17:44:53
     */
    private static String decoceAlgorithm(String encryptText, String secretKey) throws InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
        Key deskey;
        DESedeKeySpec spec = new DESedeKeySpec(secretKey.getBytes());
        SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("desede");
        deskey = keyfactory.generateSecret(spec);
        Cipher cipher = Cipher.getInstance("desede/CBC/PKCS5Padding");
        IvParameterSpec ips = new IvParameterSpec(iv.getBytes());
        cipher.init(Cipher.DECRYPT_MODE, deskey, ips);

        byte[] decryptData = cipher.doFinal(Base64.getDecoder().decode(encryptText));

        return new String(decryptData, encoding);
    }

    /**
     * des3解密
     *
     * @param encryptText 解密数据
     * @param secretKey   密钥
     * @return 解密后的数据
     * @throws Exception
     * @author 包志超
     * @date 2016年10月25日下午2:40:40
     */
    public static String decode(String encryptText, String secretKey) throws Exception {
        return decoceAlgorithm(encryptText, secretKey);
    }
}
