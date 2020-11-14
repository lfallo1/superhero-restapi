package com.lancefallon.my_app.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.lancefallon.my_app.model.ImageDTO;
import com.lancefallon.my_app.service.ImageService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;


@RestController
@RequestMapping(value = "/api/images", produces = MediaType.APPLICATION_JSON_VALUE)
public class ImageController {

    private final ImageService imageService;

    @Autowired
    public ImageController(final ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping
    public List<ImageDTO> getAllImages() {
        return imageService.findAll();
    }

    @GetMapping("/{id}")
    public ImageDTO getImage(@PathVariable final Long id) {
        return imageService.get(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Long createImage(@RequestBody @Valid final ImageDTO imageDTO) {
        return imageService.create(imageDTO);
    }

    @PutMapping("/{id}")
    public void updateImage(@PathVariable final Long id, @RequestBody @Valid final ImageDTO imageDTO) {
        imageService.update(id, imageDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteImage(@PathVariable final Long id) {
        imageService.delete(id);
    }

}
