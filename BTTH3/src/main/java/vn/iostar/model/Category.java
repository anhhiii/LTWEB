package vn.iostar.model;

import java.sql.Date;

public class Category {
    private int id;
    private String name;
    private String description;
    private int userId; // Khóa ngoại liên kết với User
    private Date createdDate;
    private String creatorName;

    // Constructor mặc định
    public Category() {}

    // Constructor đầy đủ
    public Category(int id, String name, String description, int userId, Date createdDate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.userId = userId;
        this.createdDate = createdDate;
    }

    // Getters và Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public Date getCreatedDate() { return createdDate; }
    public void setCreatedDate(Date createdDate) { this.createdDate = createdDate; }

    @Override
    public String toString() {
        return "Category [id=" + id + ", name=" + name + ", description=" + description + ", userId=" + userId + "]";
    }

	public String getCreatorName() {
		return creatorName;
	}

	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}
}