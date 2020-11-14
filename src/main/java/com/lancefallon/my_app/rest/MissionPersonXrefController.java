package com.lancefallon.my_app.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.lancefallon.my_app.model.MissionPersonXrefDTO;
import com.lancefallon.my_app.service.MissionPersonXrefService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;


@RestController
@RequestMapping(value = "/api/missionPersonXrefs", produces = MediaType.APPLICATION_JSON_VALUE)
public class MissionPersonXrefController {

    private final MissionPersonXrefService missionPersonXrefService;

    @Autowired
    public MissionPersonXrefController(final MissionPersonXrefService missionPersonXrefService) {
        this.missionPersonXrefService = missionPersonXrefService;
    }

    @GetMapping
    public List<MissionPersonXrefDTO> getAllMissionPersonXrefs() {
        return missionPersonXrefService.findAll();
    }

    @GetMapping("/{id}")
    public MissionPersonXrefDTO getMissionPersonXref(@PathVariable final Long id) {
        return missionPersonXrefService.get(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Long createMissionPersonXref(@RequestBody @Valid final MissionPersonXrefDTO missionPersonXrefDTO) {
        return missionPersonXrefService.create(missionPersonXrefDTO);
    }

    @PutMapping("/{id}")
    public void updateMissionPersonXref(@PathVariable final Long id, @RequestBody @Valid final MissionPersonXrefDTO missionPersonXrefDTO) {
        missionPersonXrefService.update(id, missionPersonXrefDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMissionPersonXref(@PathVariable final Long id) {
        missionPersonXrefService.delete(id);
    }

}
