package vn.iostar.dao;

import vn.iostar.model.User;
import java.sql.Timestamp;

public interface UserDao {
	User get(String username);
	User findByEmail(String email);
	User getById(int id); // Thêm mới

	void insert(User user);
    boolean checkExistEmail(String email);
    boolean checkExistUsername(String username);
    boolean checkExistPhone(String phone);
    
    void saveResetToken(String email, String token, Timestamp expiryDate);
    Timestamp getTokenExpiryDate(String token);
    void updatePassword(String email, String newPassword);
    String getEmailByToken(String token);
}
