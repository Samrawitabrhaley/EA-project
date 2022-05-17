package ea.badge.repository;

import ea.badge.domain.Badge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;


@Repository
public interface BadgeRepository extends JpaRepository<Badge, Long> {
    @Query("FROM Badge b WHERE b.member.id = :id")
    Collection<Badge> findByMemberId(Long id);

    @Modifying
    @Query("UPDATE Badge b SET b.active = false WHERE b.id = :id")
    Badge deactivateById(Long id);
    @Modifying
    @Query("UPDATE Badge b SET b.active = false WHERE b.member.id = :id")
    Badge deactivateByMemberId(Long id);
    @Modifying
    @Query("UPDATE Badge b SET b.active = true WHERE b.id = :id")
    Badge activateById(Long id);
}
