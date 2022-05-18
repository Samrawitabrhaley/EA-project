package ea.badge.repository;

import ea.badge.domain.Membership;
import ea.badge.domain.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface PlanRepository extends JpaRepository<Plan, Integer> {
    @Query("from Membership m inner join fetch m.plan where m.member.id = :memberId")
    Collection<Membership> getPlansByMemberId(Long memberId);

//    @Query("select Membership.plan from Membership m inner join fetch m.plan where m.member.id = :memberId")
//    Collection<Plan> getPlansByMemberId(Long memberId);
}
