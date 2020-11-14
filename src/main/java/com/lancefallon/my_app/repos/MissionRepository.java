package com.lancefallon.my_app.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lancefallon.my_app.domain.Mission;


public interface MissionRepository extends JpaRepository<Mission, Long> {
    // add custom queries here
}
