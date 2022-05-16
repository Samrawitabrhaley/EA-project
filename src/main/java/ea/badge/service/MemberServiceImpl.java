package ea.badge.service;

import ea.badge.domain.Member;
import ea.badge.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
@Service
public class MemberServiceImpl implements MemberService{
    @Autowired
    private MemberRepository memberRepository;

    @Override
    public Member createMember(Member member) {
       return memberRepository.save(member);
    }

    @Override
    public Collection<Member> getAllMembers() {
        return memberRepository.findAll();
    }


    @Override
    public Member getMemberById(Long id) {
        return memberRepository.getById(id);
    }

    @Override
    public void deleteById(Long id) {
        memberRepository.deleteById(id);

    }

    @Override
    public Member updateById(Member member,Long id) {
       return memberRepository.save(member);

    }
}
