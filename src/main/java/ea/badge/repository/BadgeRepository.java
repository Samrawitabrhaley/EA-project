package ea.badge.repository;

import ea.badge.domain.Badge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;


@Repository
public interface BadgeRepository extends JpaRepository<Badge, Integer> {
    @Query("FROM Badge b WHERE b.member.id = :id")
    Collection<Badge> findByMemberId(Integer id);

    @Modifying
    @Query("UPDATE Badge b SET b.active = false WHERE b.id = :id")
    Badge deactivateById(Integer id);
    @Modifying
    @Query("UPDATE Badge b SET b.active = false WHERE b.member.id = :id")
    Badge deactivateByMemberId(Integer id);
}
