package UMC.study.service.memberService;

import UMC.study.domain.Member;
import UMC.study.domain.Mission;
import UMC.study.domain.Review;
import UMC.study.web.dto.MemberRequestDTO;
import org.springframework.data.domain.Page;

public interface MemberCommandService {

    Member joinMember(MemberRequestDTO.JoinDto request);

    Member createMemberMission(Long missionId, Long memberId);
}
