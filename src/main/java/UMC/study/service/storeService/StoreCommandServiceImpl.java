package UMC.study.service.storeService;

import UMC.study.converter.StoreConverter;
import UMC.study.domain.Mission;
import UMC.study.domain.Review;
import UMC.study.domain.Store;
import UMC.study.repository.MemberRepository;
import UMC.study.repository.MissionRepository;
import UMC.study.repository.ReviewRepository;
import UMC.study.repository.StoreRepository;
import UMC.study.web.dto.StoreRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService{

    private final ReviewRepository reviewRepository;

    private final MemberRepository memberRepository;

    private final StoreRepository storeRepository;

    private final MissionRepository missionRepository;

    @Override
    public Review createReview(Long memberId, Long storeId, StoreRequestDTO.ReveiwDTO request) {

        Review review = StoreConverter.toReview(request);

        review.setMember(memberRepository.findById(memberId).get());
        review.setStore(storeRepository.findById(storeId).get());

        return reviewRepository.save(review);
    }

    @Override
    public Store createStore(StoreRequestDTO.StoreDTO request) {

        Store store = StoreConverter.toStore(request);

        return storeRepository.save(store);
    }

    @Override
    public Mission createMission(Long storeId, StoreRequestDTO.MissionDTO request) {

        Mission mission = StoreConverter.toMission(request);

        mission.setStore(storeRepository.findById(storeId).get());

        return missionRepository.save(mission);
    }
}
