package pl.tk.spring.advert.domain.model;

import org.springframework.jmx.export.annotation.ManagedAttribute;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotEmpty
    @Column(unique = true)
    private String username;
    @NotEmpty
    private String password;
    @NotEmpty
    @Column(name = "first_name")
    private String firstName;
    @NotEmpty
    @Column(name = "last_name")
    private String lastName;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Advert> adverts;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Advert> getAdverts() {
        return adverts;
    }

    public void setAdverts(List<Advert> adverts) {
        this.adverts = adverts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(getId(), user.getId()) &&
                Objects.equals(getUsername(), user.getUsername()) &&
                Objects.equals(getPassword(), user.getPassword()) &&
                Objects.equals(getFirstName(), user.getFirstName())&&
                Objects.equals(getLastName(), user.getLastName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUsername(), getPassword(), getFirstName(), getLastName());
    }

    @Override
    public String toString() {
        return  this.username;
    }
}
