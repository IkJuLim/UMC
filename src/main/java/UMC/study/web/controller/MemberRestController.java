package UMC.study.web.controller;

import UMC.study.apiPayload.ApiResponse;
import UMC.study.converter.MemberConverter;
import UMC.study.domain.Member;
import UMC.study.service.memberService.MemberCommandService;
import UMC.study.service.memberService.MemberQueryService;
import UMC.study.validation.annotation.ExistStore;
import UMC.study.web.dto.MemberRequestDTO;
import UMC.study.web.dto.MemberResponseDTO;
import UMC.study.web.dto.StoreResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/members")
public class MemberRestController {

    private final MemberCommandService memberCommandService;

    @PostMapping("/")
    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.JoinDto request){
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }
}
