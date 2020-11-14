package com.lancefallon.my_app.model;

import javax.validation.constraints.NotNull;


public class MissionPersonXrefDTO {

    private Long id;

    @NotNull
    private Long personId;

    @NotNull
    private Long missionId;

    @NotNull
    private Long personMissionPersonXref;

    private Long missionMissionPersonXref;

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

    public Long getPersonMissionPersonXref() {
        return personMissionPersonXref;
    }

    public void setPersonMissionPersonXref(final Long personMissionPersonXref) {
        this.personMissionPersonXref = personMissionPersonXref;
    }

    public Long getMissionMissionPersonXref() {
        return missionMissionPersonXref;
    }

    public void setMissionMissionPersonXref(final Long missionMissionPersonXref) {
        this.missionMissionPersonXref = missionMissionPersonXref;
    }

}
