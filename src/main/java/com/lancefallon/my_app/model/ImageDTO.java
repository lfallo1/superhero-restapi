package com.lancefallon.my_app.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class ImageDTO {

    private Long id;

    @NotNull
    private Long personId;

    @NotNull
    @Size(max = 255)
    private String imageUrl;

    private Long personImage;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(final Long personId) {
        this.personId = personId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(final String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Long getPersonImage() {
        return personImage;
    }

    public void setPersonImage(final Long personImage) {
        this.personImage = personImage;
    }

}
