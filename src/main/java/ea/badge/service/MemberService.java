package ea.badge.service;

import ea.badge.domain.Member;

import java.util.Collection;
import java.util.List;

public interface MemberService {
    public Member createMember(Member member);
    public Collection<Member> getAllMembers();
    public Member getMemberById(Long id);
    public void deleteById(Long id);
    public Member updateById(Member member,Long id);

}
