package ea.badge.service;

import ea.badge.domain.Badge;
import ea.badge.domain.Member;

import java.util.Collection;
import java.util.List;

public interface MemberService {
    Member createMember(Member member);
    Collection<Member> getAllMembers();
    Member getMemberById(Long id);
    void deleteById(Long id);
    Member updateById(Member member,Long id);
    Badge createOrUpdate(Badge badge);
    Badge replaceBadge(Badge badge);
    Badge deactivateBadge(Long id);

}
