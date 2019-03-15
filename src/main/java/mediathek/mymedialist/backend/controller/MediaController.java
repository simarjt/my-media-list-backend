package mediathek.mymedialist.backend.controller;

import mediathek.mymedialist.backend.model.Media;
import mediathek.mymedialist.backend.service.MediaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import static org.springframework.data.domain.Sort.Direction.ASC;

@RestController
@CrossOrigin
@RequestMapping("/my-list")
public class MediaController {
    private final MediaService mediaService;

    public MediaController(MediaService mediaService) {
        this.mediaService = mediaService;
    }

    @GetMapping
    public Page<Media> getMediaData(
            @PageableDefault(sort = "title", direction = ASC) Pageable pageable,
            @RequestParam(required = false) String list
    ) {
        return mediaService.getMediaPage(pageable, list);
    }

    @PostMapping
    public Media postMediaData(@RequestBody Media media) {
        return mediaService.postMedia(media);
    }

    @PutMapping("/{id}")
    public Media updateMediaData(@RequestBody Media media, @PathVariable int id) {
        if (id != media.getId()) {
            throw new IllegalArgumentException("different id in object and path");
        }
        return mediaService.updateMedia(media);
    }

}
