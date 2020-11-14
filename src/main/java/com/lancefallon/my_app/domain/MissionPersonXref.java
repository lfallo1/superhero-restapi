package com.lancefallon.my_app.domain;

import javax.persistence.*;
import java.time.OffsetDateTime;


@Entity
public class MissionPersonXref {

    @Id
    @Column(nullable = false, updatable = false)
    @SequenceGenerator(name = "primary_sequence", sequenceName = "primary_sequence",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "primary_sequence")
    private Long id;

    @Column(nullable = false)
    private Long personId;

    @Column(nullable = false)
    private Long missionId;

    @ManyToOne
    @JoinColumn(name = "person_mission_person_xref_id", nullable = false)
    private Person personMissionPersonXref;

    @ManyToOne
    @JoinColumn(name = "mission_mission_person_xref_id")
    private Mission missionMissionPersonXref;

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

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(final Long personId) {
        this.personId = personId;
    }

    public Long getMissionId() {
        return missionId;
    }

    public void setMissionId(final Long missionId) {
        this.missionId = missionId;
    }

    public Person getPersonMissionPersonXref() {
        return personMissionPersonXref;
    }

    public void setPersonMissionPersonXref(final Person personMissionPersonXref) {
        this.personMissionPersonXref = personMissionPersonXref;
    }

    public Mission getMissionMissionPersonXref() {
        return missionMissionPersonXref;
    }

    public void setMissionMissionPersonXref(final Mission missionMissionPersonXref) {
        this.missionMissionPersonXref = missionMissionPersonXref;
    }

    public OffsetDateTime getDateCreated() {
        return dateCreated;
    }

    public OffsetDateTime getLastUpdated() {
        return lastUpdated;
    }

}
