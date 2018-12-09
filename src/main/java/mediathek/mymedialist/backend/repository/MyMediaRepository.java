package mediathek.mymedialist.backend.repository;

import mediathek.mymedialist.backend.model.List;
import mediathek.mymedialist.backend.model.MyMedia;
import mediathek.mymedialist.backend.model.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyMediaRepository extends JpaRepository<MyMedia, Long> {
    Page<MyMedia> findAllBy(Pageable pageable);
    Page<MyMedia> findAllByList(Pageable pageable, List list);
    Page<MyMedia> findAllByType(Pageable pageable, Type type);
    Page<MyMedia> findAllByListAndType(Pageable pageable, List list, Type type);
}
