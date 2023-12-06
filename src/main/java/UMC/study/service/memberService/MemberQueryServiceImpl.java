package UMC.study.service.memberService;

import UMC.study.domain.Member;
import UMC.study.domain.Mission;
import UMC.study.domain.Review;
import UMC.study.domain.enums.MissionStatus;
import UMC.study.repository.MemberRepository;
import UMC.study.repository.MissionRepository;
import UMC.study.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberQueryServiceImpl implements MemberQueryService{

    private final MemberRepository memberRepository;
    private final ReviewRepository reviewRepository;
    private final MissionRepository missionRepository;

    @Override
    public Optional<Member> findMember(Long id) {
        return memberRepository.findById(id);
    }

    @Override
    public Page<Review> getReviewList(Long memberId, Integer page){
        Member member = memberRepository.findById(memberId).get();

        Page<Review> reviewPage = reviewRepository.findAllByMember(member, PageRequest.of(page, 10));
        return reviewPage;
    }



    @Override
    public Page<Mission> getChallengingMissionList(Long memberId, Integer page){
        Member member = memberRepository.findById(memberId).get();

        Page<Mission> missionPage = missionRepository.findAllByMemberAndMissionStatus(member, MissionStatus.CHALLENGING, PageRequest.of(page, 10));
        return missionPage;
    }
}
