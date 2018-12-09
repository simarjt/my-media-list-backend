package mediathek.mymedialist.backend.controller;

import mediathek.mymedialist.backend.model.List;
import mediathek.mymedialist.backend.model.MyMedia;
import mediathek.mymedialist.backend.model.Type;
import mediathek.mymedialist.backend.service.MyMediaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import static org.springframework.data.domain.Sort.Direction.ASC;

@RestController
@CrossOrigin
@RequestMapping("/my-list")
public class MyMediaController {
    private final MyMediaService myMediaService;

    public MyMediaController(MyMediaService myMediaService) {
        this.myMediaService = myMediaService;
    }

    @GetMapping
    public Page<MyMedia> getMyMediaData(
            @PageableDefault(sort = "title", direction = ASC) Pageable pageable,
            @RequestParam(value = "type", required = false) Type type,
            @RequestParam(value = "list", required = false) List list
    ) {
        return myMediaService.getMyMediaPage(pageable, type, list);
    }

    @PostMapping
    public MyMedia postMyMediaData(@RequestBody MyMedia myMedia) {
        return myMediaService.postMyMedia(myMedia);
    }

    @PutMapping("/{id}")
    public MyMedia updateMyMediaData(@RequestBody MyMedia myMedia, @PathVariable int id) {
        if (id != myMedia.getId()) {
            throw new IllegalArgumentException("different id in object and path");
        }
        return myMediaService.updateMyMedia(myMedia);
    }

}
