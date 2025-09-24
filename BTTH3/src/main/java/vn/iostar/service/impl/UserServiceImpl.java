package vn.iostar.service.impl;

import vn.iostar.dao.UserDao;
import vn.iostar.dao.impl.UserDaoImpl;
import vn.iostar.model.User;
import vn.iostar.service.UserService;
import org.mindrot.jbcrypt.BCrypt;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
//import java.util.UUID;

public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();

    @Override
    public User login(String username, String password) {
        User user = userDao.get(username);
        if (user != null) {
            try {
                System.out.println("Input password: " + password);
                System.out.println("Stored hash: " + user.getPassWord());
                if (BCrypt.checkpw(password, user.getPassWord())) {
                    System.out.println("Đăng nhập thành công cho user: " + username);
                    return user;
                } else {
                    System.out.println("Mật khẩu không khớp cho user: " + username);
                }
            } catch (IllegalArgumentException e) {
                System.err.println("Lỗi hash mật khẩu cho user: " + username + ". Error: " + e.getMessage());
            }
        } else {
            System.out.println("Không tìm thấy user: " + username);
        }
        return null;
    }
    
    @Override
    public User get(String username) {
        return userDao.get(username);
    }

    @Override
    public boolean register(String username, String password, String email, String fullname, String phone) {
        if (userDao.checkExistUsername(username)) {
            return false;
        }
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        // Mã hóa mật khẩu trước khi lưu
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        userDao.insert(new User(0, email, username, fullname, hashedPassword, null, 5, phone, date));
        return true;
    }

    @Override
    public boolean checkExistEmail(String email) {
        return userDao.checkExistEmail(email);
    }

    @Override
    public boolean checkExistUsername(String username) {
        return userDao.checkExistUsername(username);
    }

    @Override
    public boolean checkExistPhone(String phone) {
        return userDao.checkExistPhone(phone);
    }

    @Override
    public void insert(User user) {
        userDao.insert(user);
    }

    @Override
    public User findByEmail(String email) {
        return userDao.findByEmail(email);
    }

    @Override
    public void saveResetToken(String email, String token, long expiryTimeInMinutes) {
        userDao.saveResetToken(email, token, Timestamp.valueOf(LocalDateTime.now().plus(expiryTimeInMinutes, ChronoUnit.MINUTES)));
    }

    @Override
    public boolean isValidResetToken(String token) {
        Timestamp expiryDate = userDao.getTokenExpiryDate(token);
        if (expiryDate != null) {
            return expiryDate.after(Timestamp.valueOf(LocalDateTime.now()));
        }
        return false;
    }

    @Override
    public void updatePassword(String email, String newPassword) {
        // Mã hóa mật khẩu mới trước khi lưu
        String hashedPassword = BCrypt.hashpw(newPassword, BCrypt.gensalt());
        userDao.updatePassword(email, hashedPassword);
    }

    @Override
    public String getEmailByToken(String token) {
        return userDao.getEmailByToken(token);
    }
    
    @Override
    public User getById(int id) {
        return userDao.getById(id); // Gọi UserDao
    }
    
    
}