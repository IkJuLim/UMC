package UMC.study.service.memberService;

import UMC.study.domain.Member;
import UMC.study.domain.Mission;
import UMC.study.domain.Review;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface MemberQueryService {

    Optional<Member> findMember(Long id);

    Page<Review> getReviewList(Long memberId, Integer page);

    Page<Mission> getChallengingMissionList(Long memberId, Integer page);
}
