package ea.badge.service;

import ea.badge.domain.Member;

import java.util.List;

public interface MemberService {
    public void addMember(Member member);

    public List<Member> getMembers();

}
