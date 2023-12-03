package UMC.study.converter;

import UMC.study.domain.Member;
import UMC.study.domain.Mission;
import UMC.study.web.dto.MissionResponseDTO;

public class MissionConverter {
    public static MissionResponseDTO.challengeMissionResultDTO toCreateMemberMissionResultDTO(Long missionId, Long memberId) {
        return MissionResponseDTO.challengeMissionResultDTO.builder()
                .memberId(memberId)
                .missionId(missionId)
                .build();
    }
}

