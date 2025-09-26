package vn.iotstar.entity;

import java.io.Serializable;
import jakarta.persistence.*;

@Entity
@Table(name ="Category")
public class Category implements Serializable{
	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increment
    @Column(name = "cate_id")
    private int cateId;

    @Column(name = "cate_name", nullable = false, length = 255)
    private String cateName;

    @Column(name = "icons", length = 255)
    private String icons;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Category() {}

    // Getters & Setters
    public int getCateId() {
        return cateId;
    }

    public void setCateId(int cateId) {
        this.cateId = cateId;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public String getIcons() {
        return icons;
    }

    public void setIcons(String icons) {
        this.icons = icons;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
