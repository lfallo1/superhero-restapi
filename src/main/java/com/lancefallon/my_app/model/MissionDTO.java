package com.lancefallon.my_app.model;

import javax.validation.constraints.Size;


public class MissionDTO {

    private Long id;

    @Size(max = 255)
    private String description;

    private Status status;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(final Status status) {
        this.status = status;
    }

}
