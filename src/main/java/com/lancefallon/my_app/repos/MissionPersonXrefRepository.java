package com.lancefallon.my_app.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lancefallon.my_app.domain.MissionPersonXref;


public interface MissionPersonXrefRepository extends JpaRepository<MissionPersonXref, Long> {
    // add custom queries here
}
