package UMC.study.service.StoreService;

import UMC.study.domain.Review;
import UMC.study.web.dto.StoreRequestDTO;

public interface StoreCommandService {

    Review createReview(Long memberId, Long storeId, StoreRequestDTO.ReveiwDTO request);
}
