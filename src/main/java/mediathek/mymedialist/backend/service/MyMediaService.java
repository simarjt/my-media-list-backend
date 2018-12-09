package mediathek.mymedialist.backend.service;

import mediathek.mymedialist.backend.model.List;
import mediathek.mymedialist.backend.model.Type;
import mediathek.mymedialist.backend.repository.MyMediaRepository;
import mediathek.mymedialist.backend.model.MyMedia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MyMediaService {
    private final MyMediaRepository myMediaRepository;

    public MyMediaService(MyMediaRepository myMediaRepository) {
        this.myMediaRepository = myMediaRepository;
    }

    public Page<MyMedia> getMyMediaPage(Pageable pageable, Type type, List list) {
        Page<MyMedia> page;
        if (type == null) {
            if (list == null) {
                page = myMediaRepository.findAllBy(pageable);
            } else {
                page = myMediaRepository.findAllByList(pageable, list);
            }
        } else {
            if (list == null) {
                page = myMediaRepository.findAllByType(pageable, type);
            } else {
                page = myMediaRepository.findAllByListAndType(pageable, list, type);
            }
        }
        return page;
    }

    public MyMedia postMyMedia(MyMedia myMedia) {
        return myMediaRepository.save(myMedia);
    }

    public MyMedia updateMyMedia(MyMedia myMedia) {
        return myMediaRepository.save(myMedia);
    }

}
