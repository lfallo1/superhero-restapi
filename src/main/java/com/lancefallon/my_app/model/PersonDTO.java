package com.lancefallon.my_app.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class PersonDTO {

    private Long id;

    @NotNull
    @Size(max = 255)
    private String alias;

    @NotNull
    @Size(max = 255)
    private String firstname;

    @NotNull
    @Size(max = 255)
    private String lastname;

    @NotNull
    private Long power;

    private PersonType type;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(final String alias) {
        this.alias = alias;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(final String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(final String lastname) {
        this.lastname = lastname;
    }

    public Long getPower() {
        return power;
    }

    public void setPower(final Long power) {
        this.power = power;
    }

    public PersonType getType() {
        return type;
    }

    public void setType(final PersonType type) {
        this.type = type;
    }

}
