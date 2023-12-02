package UMC.study.service.StoreService;

import UMC.study.domain.Store;

import java.util.Optional;

public interface StoreQueryService {

    Optional<Store> findStore(Long id);
}
