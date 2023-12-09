package UMC.study.repository;

import UMC.study.domain.Member;
import UMC.study.domain.mapping.MemberMission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    @Query("SELECT m FROM MemberMission m WHERE m.member.id = :memberId AND m.mission.id = :missionId")
    @Transactional
    Optional<MemberMission> findMemberMission(@Param("memberId") Long entityAId, @Param("missionId") Long entityBId);
}
