package cn.baozcc.util.rsa;

import java.security.KeyFactory;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;

public class RSAUtils {
	private static final String PUBLIC_KEY="MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDRdzZZ8EEb1OCxNPCYrrbAS2GE8yh6h4YVsUWFclPt/A//SppgIVRXiBGVhTHDsPRmr8BM4nmc9yQz7Ngrkuz0LgB6/hLtuT2vcybd+IpAUfji0Zmrs6yPtKrNpF2LtviddujlUyc7LFETs/3KBQKjsd8/pb7CXh3a0rRsn669MwIDAQAB";
	
	public static String RSA_android_publickey(String info) throws Exception {
		BASE64Decoder base64Decoder= new BASE64Decoder();  
        byte[] buffer= base64Decoder.decodeBuffer(PUBLIC_KEY);
        KeyFactory keyFactory= KeyFactory.getInstance("RSA"); 
        X509EncodedKeySpec keySpec= new X509EncodedKeySpec(buffer);  
        RSAPublicKey publicKey= (RSAPublicKey) keyFactory.generatePublic(keySpec);  
    	byte[] srcBytes=info.getBytes();
        //Cipher负责完成加密或解密工作，基于RSA  
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");  
        //根据公钥，对Cipher对象进行初始化  
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);  
        byte[] resultBytes = cipher.doFinal(srcBytes);  
        return bcd2Str(resultBytes);   
	}
	
	 public static String bcd2Str(byte[] bytes) {  
	        char temp[] = new char[bytes.length * 2], val;  
	  
	        for (int i = 0; i < bytes.length; i++) {  
	            val = (char) (((bytes[i] & 0xf0) >> 4) & 0x0f);  
	            temp[i * 2] = (char) (val > 9 ? val + 'A' - 10 : val + '0');  
	  
	            val = (char) (bytes[i] & 0x0f);  
	            temp[i * 2 + 1] = (char) (val > 9 ? val + 'A' - 10 : val + '0');  
	        }  
	        return new String(temp);  
	    }   
}
