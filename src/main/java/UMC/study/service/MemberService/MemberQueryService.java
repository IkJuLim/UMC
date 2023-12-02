package UMC.study.service.MemberService;

import UMC.study.domain.Member;

import java.util.Optional;

public interface MemberQueryService {

    Optional<Member> findMember(Long id);

}
