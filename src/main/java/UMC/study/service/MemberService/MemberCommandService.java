package UMC.study.service.MemberService;

import UMC.study.domain.Member;
import UMC.study.web.dto.MemberRequestDTO;

public interface MemberCommandService {

    Member joinMember(MemberRequestDTO.JoinDto request);
}
