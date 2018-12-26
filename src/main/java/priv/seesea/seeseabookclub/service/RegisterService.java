package priv.seesea.seeseabookclub.service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

/**
 * @author http://blog.csdn.net/thewaiting
 */
public interface RegisterService {

    Integer putUser(String phone,String passward) throws NoSuchAlgorithmException;
}
