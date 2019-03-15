package mediathek.mymedialist.backend.service;

import mediathek.mymedialist.backend.repository.MediaRepository;
import mediathek.mymedialist.backend.model.Media;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MediaService {
    private final MediaRepository mediaRepository;

    public MediaService(MediaRepository mediaRepository) {
        this.mediaRepository = mediaRepository;
    }

    public Page<Media> getMediaPage(Pageable pageable, String list) {
        Page<Media> page;
        if (list == null) {
            page = mediaRepository.findAllBy(pageable);
        } else {
            page = mediaRepository.findAllByList(pageable, list);
        }
        return page;
    }

    public Media postMedia(Media media) {
        return mediaRepository.save(media);
    }

    public Media updateMedia(Media media) {
        return mediaRepository.save(media);
    }

}
