package UMC.study.service.memberService;

import UMC.study.apiPayload.code.status.ErrorStatus;
import UMC.study.apiPayload.exception.handler.FoodCategoryHandler;
import UMC.study.apiPayload.exception.handler.MemberHandler;
import UMC.study.apiPayload.exception.handler.MissionHandler;
import UMC.study.converter.MemberConverter;
import UMC.study.converter.MemberPreferConverter;
import UMC.study.domain.*;
import UMC.study.domain.mapping.MemberMission;
import UMC.study.domain.mapping.MemberPrefer;
import UMC.study.repository.FoodCategoryRepository;
import UMC.study.repository.MemberRepository;
import UMC.study.repository.MissionRepository;
import UMC.study.repository.ReviewRepository;
import UMC.study.web.dto.MemberRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberCommandServiceImpl implements MemberCommandService{

    private final MemberRepository memberRepository;

    private final FoodCategoryRepository foodCategoryRepository;

    private final MissionRepository missionRepository;

    @Override
    @Transactional
    public Member joinMember(MemberRequestDTO.JoinDto request) {

        Member newMember = MemberConverter.toMember(request);
        List<FoodCategory> foodCategoryList = request.getPreferCategory().stream()
                .map(category -> {
                    return foodCategoryRepository.findById(category).orElseThrow(() ->
                            new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND)
                    );
                }).collect(Collectors.toList());

        List<MemberPrefer> memberPreferList = MemberPreferConverter.toMemberPreferList(foodCategoryList);

        memberPreferList.forEach(memberPrefer -> {memberPrefer.setMember(newMember);});

        return memberRepository.save(newMember);
    }


    @Override
    @Transactional
    public Member createMemberMission(Long missionId, Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow(() ->
                new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND)
        );

        Mission mission = missionRepository.findById(missionId).orElseThrow(() ->
                new MissionHandler(ErrorStatus.MISSION_NOT_FOUND)
        );

        MemberMission.builder()
                .mission(mission)
                .member(member)
                .build();

        return member;
    }

    @Override
    @Transactional
    public Mission completeMission(Long memberId, Long missionId){
        Member member = memberRepository.findById(memberId).get();
        Mission mission = missionRepository.findById(missionId).get();
        MemberMission memberMission = member.getMemberMissionList().stream()
                .filter(mm -> mm.getMission().equals(mission)).findFirst().get();
        memberMission.missionComplete();
        return mission;
    }
}
