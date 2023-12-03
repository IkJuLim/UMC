package UMC.study.service.missionService;

import UMC.study.domain.Mission;

import java.util.Optional;

public interface MissionQueryService {
    Optional<Mission> findMission(Long id);
}
