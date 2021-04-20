import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Author zh
 * @Date 2021/3/25 12:03
 * description :
 */
public class ShiroTest {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        SimpleHash simpleHash = new SimpleHash("MD5", "123456", "auth", 2);
        System.out.println(simpleHash.toString());
        MessageDigest digest = MessageDigest.getInstance("MD5");
        digest.reset();
        digest.update("auth".getBytes());
        byte[] hashed = digest.digest("123456".getBytes());
        byte[] result = digest.digest(hashed);
        System.out.println(byteArrayToHexString(result));
    }

    private static final String[] hexDigits = {"0", "1", "2", "3", "4", "5","6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    //将字节数组转换成16进制字符串
    private static String byteArrayToHexString(byte[] b) {
        StringBuilder resultSb = new StringBuilder();
        for (byte value : b) resultSb.append(byteToHexString(value));
        return resultSb.toString();
    }

    //单个字节转换成16进制的字符串
    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0) n += 256;
        int d1 = n / 16;   //取出高4位
        int d2 = n % 16;   //取出低4位
        return hexDigits[d1] + hexDigits[d2];
    }
}
