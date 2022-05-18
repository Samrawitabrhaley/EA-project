package ea.badge.repository;

import ea.badge.domain.Badge;
import ea.badge.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface MemberRepository extends JpaRepository<Member,Long> {
    @Query("FROM User u join u.member m where u.username=:username and u.password=:password")
    Member findByUserNamePwd(String username, String password);

}
