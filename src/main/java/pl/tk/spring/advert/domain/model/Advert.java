package pl.tk.spring.advert.domain.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "adverts")
public class Advert {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotEmpty
    private String title;
    @NotEmpty
    @Column(columnDefinition = "TEXT")
    private String description;

    private LocalDateTime posted;
    @OneToMany(mappedBy = "advert" ,cascade = CascadeType.ALL)
    private User user;

    public Advert() {
    }
    @PrePersist
    public void onPrePersist() {
        posted = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getPosted() {
        return posted;
    }

    public void setPosted(LocalDateTime posted) {
        this.posted = posted;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Advert advert = (Advert) o;
        return Objects.equals(id, advert.id) &&
                Objects.equals(title, advert.title) &&
                Objects.equals(description, advert.description) &&
                Objects.equals(posted, advert.posted) &&
                Objects.equals(user, advert.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, posted, user);
    }

    @Override
    public String toString() {
        return this.id +
               this.title +
               this.description +
               this.posted +
               this.user;
    }
}
