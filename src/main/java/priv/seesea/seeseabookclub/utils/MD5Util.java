package priv.seesea.seeseabookclub.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

/**
 * @author http://blog.csdn.net/thewaiting
 * @create 2018 - 06 -09 -下午 11:02
 */


public class MD5Util {

    public static String getMd5(String str) throws NoSuchAlgorithmException{

        StringBuffer buffer = new StringBuffer();
        char[] chars = new char[]{'0','1','2','3',
                '4','5','6','7','8','9','A','B','C','D','E','F'};
        byte [] bytes = str.getBytes();
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        byte[] targ = messageDigest.digest(bytes);
        for(byte b:targ) {
            buffer.append(chars[(b>>4)&0x0F]);
            buffer.append(chars[b&0x0F]);
        }
        return buffer.toString();


    }

    public static void main(String arg[]){
        try {
            String localChartSet = System.getProperty("file.encoding");
            System.out.println("localChartSet>>>>"+localChartSet);
            System.out.print( getMd5("123"));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
