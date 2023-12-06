package UMC.study.repository;

import UMC.study.domain.Member;
import UMC.study.domain.Mission;
import UMC.study.domain.enums.MissionStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissionRepository extends JpaRepository<Mission, Long> {
    Page<Mission> findAllByMemberAndMissionStatus(Member member, MissionStatus missionStatus, PageRequest of);
}
