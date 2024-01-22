package lab.database;

import java.util.Objects;

public class Person {
    private Integer id;
    private String jobtitle;
    private String firstnamelastname;
    private String phone;
    private String email;

    public Person() {
    }

    public Person(Integer id, String jobtitle, String firstnamelastname, String phone, String email) {
        this.id = id;
        this.jobtitle = jobtitle;
        this.firstnamelastname = firstnamelastname;
        this.phone = phone;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJobtitle() {
        return jobtitle;
    }

    public void setJobtitle(String jobtitle) {
        this.jobtitle = jobtitle;
    }

    public String getFirstnamelastname() {
        return firstnamelastname;
    }

    public void setFirstnamelastname(String firstnamelastname) {
        this.firstnamelastname = firstnamelastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id) && Objects.equals(firstnamelastname, person.firstnamelastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstnamelastname);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", jobtitle='" + jobtitle + '\'' +
                ", firstnamelastname='" + firstnamelastname + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
