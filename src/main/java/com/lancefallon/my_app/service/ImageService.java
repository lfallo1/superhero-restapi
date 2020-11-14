package com.lancefallon.my_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import com.lancefallon.my_app.config.CustomNotFoundException;
import com.lancefallon.my_app.domain.Image;
import com.lancefallon.my_app.domain.Person;
import com.lancefallon.my_app.model.ImageDTO;
import com.lancefallon.my_app.repos.ImageRepository;
import com.lancefallon.my_app.repos.PersonRepository;


@Service
public class ImageService {

    private final ImageRepository imageRepository;
    private final PersonRepository personRepository;

    @Autowired
    public ImageService(final ImageRepository imageRepository,
                        final PersonRepository personRepository) {
        this.imageRepository = imageRepository;
        this.personRepository = personRepository;
    }

    public List<ImageDTO> findAll() {
        return imageRepository.findAll()
                .stream()
                .map(image -> mapToDTO(image, new ImageDTO()))
                .collect(Collectors.toList());
    }

    public ImageDTO get(final Long id) {
        return imageRepository.findById(id)
                .map(image -> mapToDTO(image, new ImageDTO()))
                .orElseThrow(CustomNotFoundException::new);
    }

    public Long create(final ImageDTO imageDTO) {
        final Image image = new Image();
        mapToEntity(imageDTO, image);
        return imageRepository.save(image).getId();
    }

    public void update(final Long id, final ImageDTO imageDTO) {
        final Image image = imageRepository.findById(id)
                .orElseThrow(CustomNotFoundException::new);
        mapToEntity(imageDTO, image);
        imageRepository.save(image);
    }

    public void delete(final Long id) {
        imageRepository.deleteById(id);
    }

    private ImageDTO mapToDTO(final Image image, final ImageDTO imageDTO) {
        imageDTO.setId(image.getId());
        imageDTO.setPersonId(image.getPersonId());
        imageDTO.setImageUrl(image.getImageUrl());
        imageDTO.setPersonImage(image.getPersonImage() == null ? null : image.getPersonImage().getId());
        return imageDTO;
    }

    private Image mapToEntity(final ImageDTO imageDTO, final Image image) {
        image.setPersonId(imageDTO.getPersonId());
        image.setImageUrl(imageDTO.getImageUrl());
        if (imageDTO.getPersonImage() != null &&
                (image.getPersonImage() == null || image.getPersonImage().getId() != imageDTO.getPersonImage())) {
            final Person personImage = personRepository.findById(imageDTO.getPersonImage())
                    .orElseThrow(CustomNotFoundException::new);
            image.setPersonImage(personImage);
        }
        return image;
    }

}
