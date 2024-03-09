import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import java.security.SecureRandom;

public class Main {
    private  static String pass= "password";
    private  String operator ="";
    private  String salt = "salt";
    public static void main(String[] args) {
        String temp ="";
        System.out.println("enter pass");
        temp = System.console().readLine();
        setPass(temp);
        temp="";
        System.out.println("eneter passvord to login");
        temp=System.console().readLine();
        if(temp.equals(pass)){
            System.out.println("login success");
        }else{
            System.out.println("login failed");
        }

        
 


}
public static void setPass(String pass){
    Main.pass = pass;
}

private static String get_SHA_512_SecurePassword(String passwordToHash,
String salt) {
String generatedPassword = null;
try {
MessageDigest md = MessageDigest.getInstance("SHA-512");
md.update(salt.getBytes());
byte[] bytes = md.digest(passwordToHash.getBytes());
StringBuilder sb = new StringBuilder();
for (int i = 0; i < bytes.length; i++) {
    sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16)
            .substring(1));
}
generatedPassword = sb.toString();
} catch (NoSuchAlgorithmException e) {
e.printStackTrace();
}
return generatedPassword;
}
}
