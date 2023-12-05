package UMC.study.service.memberService;

import UMC.study.domain.Member;
import UMC.study.domain.Review;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface MemberQueryService {

    Optional<Member> findMember(Long id);

}
