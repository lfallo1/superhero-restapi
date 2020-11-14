package com.lancefallon.my_app.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.lancefallon.my_app.model.MissionDTO;
import com.lancefallon.my_app.service.MissionService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;


@RestController
@RequestMapping(value = "/api/missions", produces = MediaType.APPLICATION_JSON_VALUE)
public class MissionController {

    private final MissionService missionService;

    @Autowired
    public MissionController(final MissionService missionService) {
        this.missionService = missionService;
    }

    @GetMapping
    public List<MissionDTO> getAllMissions() {
        return missionService.findAll();
    }

    @GetMapping("/{id}")
    public MissionDTO getMission(@PathVariable final Long id) {
        return missionService.get(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Long createMission(@RequestBody @Valid final MissionDTO missionDTO) {
        return missionService.create(missionDTO);
    }

    @PutMapping("/{id}")
    public void updateMission(@PathVariable final Long id, @RequestBody @Valid final MissionDTO missionDTO) {
        missionService.update(id, missionDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMission(@PathVariable final Long id) {
        missionService.delete(id);
    }

}
