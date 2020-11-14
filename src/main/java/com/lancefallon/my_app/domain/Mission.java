package com.lancefallon.my_app.domain;

import javax.persistence.*;
import com.lancefallon.my_app.model.Status;
import java.time.OffsetDateTime;
import java.util.Set;


@Entity
public class Mission {

    @Id
    @Column(nullable = false, updatable = false)
    @SequenceGenerator(name = "primary_sequence", sequenceName = "primary_sequence",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "primary_sequence")
    private Long id;

    @Column
    private String description;

    @Column
    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToMany(mappedBy = "missionMissionPersonXref", targetEntity = MissionPersonXref.class,
            fetch = FetchType.LAZY)
    private Set<MissionPersonXref> missionPersonXrefMissionMissionPersonXrefs;

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

    public Set<MissionPersonXref> getMissionPersonXrefMissionMissionPersonXrefs() {
        return missionPersonXrefMissionMissionPersonXrefs;
    }

    public void setMissionPersonXrefMissionMissionPersonXrefs(final Set<MissionPersonXref> missionPersonXrefMissionMissionPersonXrefs) {
        this.missionPersonXrefMissionMissionPersonXrefs = missionPersonXrefMissionMissionPersonXrefs;
    }

    public OffsetDateTime getDateCreated() {
        return dateCreated;
    }

    public OffsetDateTime getLastUpdated() {
        return lastUpdated;
    }

}
