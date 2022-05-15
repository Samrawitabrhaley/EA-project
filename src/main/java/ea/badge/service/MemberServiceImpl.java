package ea.badge.service;

import ea.badge.domain.Member;
import ea.badge.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MemberServiceImpl implements MemberService{
    @Autowired
    private MemberRepository memberRepository;

    @Override
    public void addMember(Member member) {
       memberRepository.save(member);
    }

    @Override
    public List<Member> getMembers() {
        return memberRepository.findAll();
    }
}
