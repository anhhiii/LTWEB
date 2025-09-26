package vn.iotstar.entity;


import java.util.Date;
import java.util.List;


import jakarta.persistence.*;

@Entity
@Table(name = "Users")
public class User {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false, unique = true, length = 100)
	private String email;

	@Column(nullable = false, unique = true, length = 50)
	private String userName;

	@Column(length = 100)
	private String fullName;

	@Column(nullable = false, length = 100)
	private String password;

	@Column(length = 255)
	private String avatar;

	@Column(name = "roleid")
	private int roleid = 3; // default = user

	@Column(length = 15)
	private String phone;

	@Column(name = "createdDate")
	private Date createdDate;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Category> categories;
	
	// Getters & Setters
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getFullName() {
			return fullName;
		}

		public void setFullName(String fullName) {
			this.fullName = fullName;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getAvatar() {
			return avatar;
		}

		public void setAvatar(String avatar) {
			this.avatar = avatar;
		}

		public int getRoleid() {
			return roleid;
		}

		public void setRoleid(int roleid) {
			this.roleid = roleid;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public Date getCreatedDate() {
			return createdDate;
		}

		public void setCreatedDate(Date createdDate) {
			this.createdDate = createdDate;
		}

		public List<Category> getCategories() {
			return categories;
		}

		public void setCategories(List<Category> categories) {
			this.categories = categories;
		}
		
		public User() {
	    }

		public User(int id, String email, String userName, String fullName, String password, String avatar, int roleid,
				String phone, Date createdDate, List<Category> categories) {
			super();
			this.id = id;
			this.email = email;
			this.userName = userName;
			this.fullName = fullName;
			this.password = password;
			this.avatar = avatar;
			this.roleid = roleid;
			this.phone = phone;
			this.createdDate = createdDate;
			this.categories = categories;
		}

		public User(String email, String userName, String password) {
			super();
			this.email = email;
			this.userName = userName;
			this.password = password;
		}
}
