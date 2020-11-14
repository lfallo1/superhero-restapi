package com.lancefallon.my_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import com.lancefallon.my_app.config.CustomNotFoundException;
import com.lancefallon.my_app.domain.Mission;
import com.lancefallon.my_app.domain.MissionPersonXref;
import com.lancefallon.my_app.domain.Person;
import com.lancefallon.my_app.model.MissionPersonXrefDTO;
import com.lancefallon.my_app.repos.MissionPersonXrefRepository;
import com.lancefallon.my_app.repos.MissionRepository;
import com.lancefallon.my_app.repos.PersonRepository;


@Service
public class MissionPersonXrefService {

    private final MissionPersonXrefRepository missionPersonXrefRepository;
    private final PersonRepository personRepository;
    private final MissionRepository missionRepository;

    @Autowired
    public MissionPersonXrefService(final MissionPersonXrefRepository missionPersonXrefRepository,
                                    final PersonRepository personRepository,
                                    final MissionRepository missionRepository) {
        this.missionPersonXrefRepository = missionPersonXrefRepository;
        this.personRepository = personRepository;
        this.missionRepository = missionRepository;
    }

    public List<MissionPersonXrefDTO> findAll() {
        return missionPersonXrefRepository.findAll()
                .stream()
                .map(missionPersonXref -> mapToDTO(missionPersonXref, new MissionPersonXrefDTO()))
                .collect(Collectors.toList());
    }

    public MissionPersonXrefDTO get(final Long id) {
        return missionPersonXrefRepository.findById(id)
                .map(missionPersonXref -> mapToDTO(missionPersonXref, new MissionPersonXrefDTO()))
                .orElseThrow(CustomNotFoundException::new);
    }

    public Long create(final MissionPersonXrefDTO missionPersonXrefDTO) {
        final MissionPersonXref missionPersonXref = new MissionPersonXref();
        mapToEntity(missionPersonXrefDTO, missionPersonXref);
        return missionPersonXrefRepository.save(missionPersonXref).getId();
    }

    public void update(final Long id, final MissionPersonXrefDTO missionPersonXrefDTO) {
        final MissionPersonXref missionPersonXref = missionPersonXrefRepository.findById(id)
                .orElseThrow(CustomNotFoundException::new);
        mapToEntity(missionPersonXrefDTO, missionPersonXref);
        missionPersonXrefRepository.save(missionPersonXref);
    }

    public void delete(final Long id) {
        missionPersonXrefRepository.deleteById(id);
    }

    private MissionPersonXrefDTO mapToDTO(final MissionPersonXref missionPersonXref, final MissionPersonXrefDTO missionPersonXrefDTO) {
        missionPersonXrefDTO.setId(missionPersonXref.getId());
        missionPersonXrefDTO.setPersonId(missionPersonXref.getPersonId());
        missionPersonXrefDTO.setMissionId(missionPersonXref.getMissionId());
        missionPersonXrefDTO.setPersonMissionPersonXref(missionPersonXref.getPersonMissionPersonXref() == null ? null : missionPersonXref.getPersonMissionPersonXref().getId());
        missionPersonXrefDTO.setMissionMissionPersonXref(missionPersonXref.getMissionMissionPersonXref() == null ? null : missionPersonXref.getMissionMissionPersonXref().getId());
        return missionPersonXrefDTO;
    }

    private MissionPersonXref mapToEntity(final MissionPersonXrefDTO missionPersonXrefDTO, final MissionPersonXref missionPersonXref) {
        missionPersonXref.setPersonId(missionPersonXrefDTO.getPersonId());
        missionPersonXref.setMissionId(missionPersonXrefDTO.getMissionId());
        if (missionPersonXrefDTO.getPersonMissionPersonXref() != null &&
                (missionPersonXref.getPersonMissionPersonXref() == null || missionPersonXref.getPersonMissionPersonXref().getId() != missionPersonXrefDTO.getPersonMissionPersonXref())) {
            final Person personMissionPersonXref = personRepository.findById(missionPersonXrefDTO.getPersonMissionPersonXref())
                    .orElseThrow(CustomNotFoundException::new);
            missionPersonXref.setPersonMissionPersonXref(personMissionPersonXref);
        }
        if (missionPersonXrefDTO.getMissionMissionPersonXref() != null &&
                (missionPersonXref.getMissionMissionPersonXref() == null || missionPersonXref.getMissionMissionPersonXref().getId() != missionPersonXrefDTO.getMissionMissionPersonXref())) {
            final Mission missionMissionPersonXref = missionRepository.findById(missionPersonXrefDTO.getMissionMissionPersonXref())
                    .orElseThrow(CustomNotFoundException::new);
            missionPersonXref.setMissionMissionPersonXref(missionMissionPersonXref);
        }
        return missionPersonXref;
    }

}
