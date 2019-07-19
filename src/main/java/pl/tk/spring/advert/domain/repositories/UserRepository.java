package pl.tk.spring.advert.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.tk.spring.advert.domain.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}