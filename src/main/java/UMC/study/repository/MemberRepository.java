package UMC.study.repository;

import UMC.study.domain.Member;
import UMC.study.domain.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
