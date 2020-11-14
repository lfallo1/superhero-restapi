package com.lancefallon.my_app.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lancefallon.my_app.domain.Image;


public interface ImageRepository extends JpaRepository<Image, Long> {
    // add custom queries here
}
