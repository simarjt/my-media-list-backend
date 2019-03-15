package mediathek.mymedialist.backend.repository;

import mediathek.mymedialist.backend.model.Media;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MediaRepository extends JpaRepository<Media, Integer> {
    Page<Media> findAllBy(Pageable pageable);
    Page<Media> findAllByList(Pageable pageable, String list);
}
