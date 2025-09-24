package vn.iostar.service;

import vn.iostar.model.User;

public interface UserService {
	User login(String username, String password);
	User get(String username);
	User findByEmail(String email);

	void insert(User user);
    boolean register(String username, String password, String email, String fullname, String phone);
    boolean checkExistEmail(String email);
    boolean checkExistUsername(String username);
    boolean checkExistPhone(String phone);

    void saveResetToken(String email, String token, long expiryTimeInMinutes);
    boolean isValidResetToken(String token);
    void updatePassword(String email, String newPassword);
    String getEmailByToken(String token);
    
    User getById(int id);
}
