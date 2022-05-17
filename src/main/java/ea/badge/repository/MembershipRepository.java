package ea.badge.repository;

import ea.badge.domain.Badge;
import ea.badge.domain.Membership;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface MembershipRepository extends JpaRepository<Membership,Long> {
    @Query("FROM Membership m WHERE m.member.id = :memberId AND m.location.id = :locationId")
    Membership getMembershipByMemberIdAndByLocationId(Long memberId, Long locationId);
    @Query("FROM Membership m WHERE m.member.id = :memberId")
    Collection<Membership> getMembershipByMemberId(Long memberId);
}
