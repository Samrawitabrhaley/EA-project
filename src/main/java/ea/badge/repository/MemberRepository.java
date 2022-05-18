package ea.badge.repository;

import ea.badge.domain.Badge;
import ea.badge.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface MemberRepository extends JpaRepository<Member,Long> {

}
