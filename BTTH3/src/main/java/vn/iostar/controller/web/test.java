package vn.iostar.controller.web;

import org.mindrot.jbcrypt.BCrypt;

public class test {
    public static void main(String[] args) {
        String password = "123"; // Mật khẩu gốc
        String hashed = BCrypt.hashpw(password, BCrypt.gensalt(12));
        System.out.println(hashed); // In ra hash
    }
}
