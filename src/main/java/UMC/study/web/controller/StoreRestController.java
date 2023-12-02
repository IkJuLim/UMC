package UMC.study.web.controller;

import UMC.study.apiPayload.ApiResponse;
import UMC.study.converter.StoreConverter;
import UMC.study.domain.Review;
import UMC.study.service.StoreService.StoreCommandService;
import UMC.study.validation.annotation.ExistMember;
import UMC.study.validation.annotation.ExistStore;
import UMC.study.web.dto.StoreRequestDTO;
import UMC.study.web.dto.StoreResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreRestController {

    private final StoreCommandService storeCommandService;

    @PostMapping("/{storeId}/reviews")
    public ApiResponse<StoreResponseDTO.CreateReviewResultDTO> createReview(@RequestBody @Valid StoreRequestDTO.ReveiwDTO request,
                                                                            @ExistStore @PathVariable(name = "storeId") Long storeId,
                                                                            @ExistMember @RequestParam(name = "memberId") Long memberId){
        Review review = storeCommandService.createReview(memberId, storeId, request);
        return ApiResponse.onSuccess(StoreConverter.toCreateReviewResultDTO(review));
    }
}
