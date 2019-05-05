package iunsuccessful.demo.base.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p/>
 *
 * @author Created by 依韵 on 2019/4/23 .
 */
public class Sha1Sign {

    public static String sign(String removed, Map<String, String> params) {
        String request = params.entrySet().stream()
                .map(input -> String.format("%s=%s", input.getKey(), input.getValue()))
                .sorted()
                .collect(Collectors.joining("&"));
        params.remove(removed);
        String sign = sha1(request);
        return sign;
    }

    public static String sha1(String text) {
        MessageDigest md = null;
        String outStr = null;
        try {
            md = MessageDigest.getInstance("SHA-1");
            byte[] digest = md.digest(text.getBytes());
            outStr = byteToString(digest);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        return outStr;
    }

    private static String byteToString(byte[] digest) {
        StringBuilder buf = new StringBuilder();
        for (int i = 0; i < digest.length; i++) {
            String tempStr = Integer.toHexString(digest[i] & 0xff);
            if (tempStr.length() == 1) {
                buf.append("0").append(tempStr);
            } else {
                buf.append(tempStr);
            }
        }
        return buf.toString().toLowerCase();
    }

}
