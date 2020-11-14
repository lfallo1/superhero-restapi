package com.lancefallon.my_app.domain;

import javax.persistence.*;
import com.lancefallon.my_app.model.PersonType;
import java.time.OffsetDateTime;
import java.util.Set;


@Entity
public class Person {

    @Id
    @Column(nullable = false, updatable = false)
    @SequenceGenerator(name = "primary_sequence", sequenceName = "primary_sequence",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "primary_sequence")
    private Long id;

    @Column(nullable = false)
    private String alias;

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String lastname;

    @Column(nullable = false)
    private Long power;

    @Column
    @Enumerated(EnumType.STRING)
    private PersonType type;

    @OneToMany(mappedBy = "personMissionPersonXref", targetEntity = MissionPersonXref.class,
            fetch = FetchType.LAZY)
    private Set<MissionPersonXref> missionPersonXrefPersonMissionPersonXrefs;

    @OneToMany(mappedBy = "personImage", targetEntity = Image.class,
            fetch = FetchType.LAZY)
    private Set<Image> imagePersonImages;

    @Column(nullable = false, updatable = false)
    protected OffsetDateTime dateCreated;

    @Column(nullable = false)
    protected OffsetDateTime lastUpdated;

    @PrePersist
    public void prePersist() {
        dateCreated = OffsetDateTime.now();
        lastUpdated = dateCreated;
    }

    @PreUpdate
    public void preUpdate() {
        lastUpdated = OffsetDateTime.now();
    }

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

    public Set<MissionPersonXref> getMissionPersonXrefPersonMissionPersonXrefs() {
        return missionPersonXrefPersonMissionPersonXrefs;
    }

    public void setMissionPersonXrefPersonMissionPersonXrefs(final Set<MissionPersonXref> missionPersonXrefPersonMissionPersonXrefs) {
        this.missionPersonXrefPersonMissionPersonXrefs = missionPersonXrefPersonMissionPersonXrefs;
    }

    public Set<Image> getImagePersonImages() {
        return imagePersonImages;
    }

    public void setImagePersonImages(final Set<Image> imagePersonImages) {
        this.imagePersonImages = imagePersonImages;
    }

    public OffsetDateTime getDateCreated() {
        return dateCreated;
    }

    public OffsetDateTime getLastUpdated() {
        return lastUpdated;
    }

}
