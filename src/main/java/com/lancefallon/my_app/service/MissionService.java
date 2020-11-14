package com.lancefallon.my_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import com.lancefallon.my_app.config.CustomNotFoundException;
import com.lancefallon.my_app.domain.Mission;
import com.lancefallon.my_app.model.MissionDTO;
import com.lancefallon.my_app.repos.MissionRepository;


@Service
public class MissionService {

    private final MissionRepository missionRepository;

    @Autowired
    public MissionService(final MissionRepository missionRepository) {
        this.missionRepository = missionRepository;
    }

    public List<MissionDTO> findAll() {
        return missionRepository.findAll()
                .stream()
                .map(mission -> mapToDTO(mission, new MissionDTO()))
                .collect(Collectors.toList());
    }

    public MissionDTO get(final Long id) {
        return missionRepository.findById(id)
                .map(mission -> mapToDTO(mission, new MissionDTO()))
                .orElseThrow(CustomNotFoundException::new);
    }

    public Long create(final MissionDTO missionDTO) {
        final Mission mission = new Mission();
        mapToEntity(missionDTO, mission);
        return missionRepository.save(mission).getId();
    }

    public void update(final Long id, final MissionDTO missionDTO) {
        final Mission mission = missionRepository.findById(id)
                .orElseThrow(CustomNotFoundException::new);
        mapToEntity(missionDTO, mission);
        missionRepository.save(mission);
    }

    public void delete(final Long id) {
        missionRepository.deleteById(id);
    }

    private MissionDTO mapToDTO(final Mission mission, final MissionDTO missionDTO) {
        missionDTO.setId(mission.getId());
        missionDTO.setDescription(mission.getDescription());
        missionDTO.setStatus(mission.getStatus());
        return missionDTO;
    }

    private Mission mapToEntity(final MissionDTO missionDTO, final Mission mission) {
        mission.setDescription(missionDTO.getDescription());
        mission.setStatus(missionDTO.getStatus());
        return mission;
    }

}
