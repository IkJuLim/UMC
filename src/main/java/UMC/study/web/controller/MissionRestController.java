package UMC.study.web.controller;

import UMC.study.apiPayload.ApiResponse;
import UMC.study.converter.MissionConverter;
import UMC.study.domain.Member;
import UMC.study.service.memberService.MemberCommandService;
import UMC.study.validation.annotation.ExistMember;
import UMC.study.validation.annotation.ExistMission;
import UMC.study.validation.annotation.NotChallengingMission;
import UMC.study.web.dto.MissionResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/missions")
public class MissionRestController {
    private final MemberCommandService memberCommandService;

    @PostMapping("/{missionId}/challenges")
    public ApiResponse<MissionResponseDTO.challengeMissionResultDTO> challengeMission(@ExistMission @NotChallengingMission @PathVariable(name = "missionId") Long missionId,
                                                                                         @ExistMember @RequestParam(name = "memberId") Long memberId){
        Member member = memberCommandService.createMemberMission(missionId, memberId);
        return ApiResponse.onSuccess(MissionConverter.toCreateMemberMissionResultDTO(missionId, memberId));
    }
}
