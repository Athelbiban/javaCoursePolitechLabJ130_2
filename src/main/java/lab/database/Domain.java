package lab.database;

import java.sql.Timestamp;
import java.util.Objects;

public class Domain {
    private Integer id;
    private String webname;
    private String domainname;
    private String ip;
    private Timestamp datereg;
    private String countryreg;
    private Person person;

    public Domain() {
    }

    public Domain(Integer id, String webname, String domainname, String ip, Timestamp datereg, String countryreg) {
        this.id = id;
        this.webname = webname;
        this.domainname = domainname;
        this.ip = ip;
        this.datereg = datereg;
        this.countryreg = countryreg;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWebname() {
        return webname;
    }

    public void setWebname(String webname) {
        this.webname = webname;
    }

    public String getDomainname() {
        return domainname;
    }

    public void setDomainname(String domainname) {
        this.domainname = domainname;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Timestamp getDatereg() {
        return datereg;
    }

    public void setDatereg(Timestamp datereg) {
        this.datereg = datereg;
    }

    public String getCountryreg() {
        return countryreg;
    }

    public void setCountryreg(String countryreg) {
        this.countryreg = countryreg;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Domain domain = (Domain) o;
        return Objects.equals(id, domain.id) && Objects.equals(webname, domain.webname) && Objects.equals(domainname, domain.domainname) && Objects.equals(datereg, domain.datereg) && Objects.equals(countryreg, domain.countryreg);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, webname, domainname, datereg, countryreg);
    }

    @Override
    public String toString() {
        return "Domain{" +
                "id=" + id +
                ", webname='" + webname + '\'' +
                ", domainname='" + domainname + '\'' +
                ", ip='" + ip + '\'' +
                ", datereg=" + datereg +
                ", countryreg='" + countryreg + '\'' +
                ", person=" + person +
                '}';
    }
}
