package entity;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Students")
public class Student {
    @Id
    @Column(name = "Id")
    private Integer id;
    @Column(name = "Image")
    private String image;

    @Column(name = "Name")
    private String name;

    @Column(name = "Birthday")
    private Date birthday;

    @Column(name = "Phone")
    private String phone;

    public Student() {
    }

    public Student(Integer id, String image, String name, Date birthday, String phone) {
        this.id = id;
        this.image = image;
        this.name = name;
        this.birthday = birthday;
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}