package vn.iotstar.dao;
import vn.iotstar.models.User;

public interface UserDao {
	User get(String username);
	User findByEmail(String email);

	void insert(User user);
    boolean checkExistEmail(String email);
    boolean checkExistUsername(String username);
    boolean checkExistPhone(String phone);
}
