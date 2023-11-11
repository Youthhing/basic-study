package youth.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import youth.study.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
