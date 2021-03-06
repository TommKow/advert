package pl.tk.spring.advert.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import pl.tk.spring.advert.domain.model.Advert;
import pl.tk.spring.advert.domain.model.User;

import java.util.List;

@Repository
public interface AdvertRepository extends JpaRepository<Advert, Long> {

    List<Advert> findAllByOrderByPostedDesc();

    List<Advert> findAllByUserIdOrderByPostedDesc(Long id);

    List<Advert> findFirst10ByOrderByPostedDesc();
}
