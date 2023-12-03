package UMC.study.service.memberService;

import UMC.study.domain.Member;
import UMC.study.domain.Mission;
import UMC.study.web.dto.MemberRequestDTO;

public interface MemberCommandService {

    Member joinMember(MemberRequestDTO.JoinDto request);

    Member createMemberMission(Long missionId, Long memberId);
}
