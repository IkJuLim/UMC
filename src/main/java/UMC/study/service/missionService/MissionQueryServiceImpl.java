package UMC.study.service.missionService;


import UMC.study.domain.Mission;
import UMC.study.repository.MissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionQueryServiceImpl implements MissionQueryService {
    private final MissionRepository missionRepository;

    @Override
    public Optional<Mission> findMission(Long id){
        return missionRepository.findById(id);
    }
}
