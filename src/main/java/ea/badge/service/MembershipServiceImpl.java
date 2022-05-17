package ea.badge.service;

import ea.badge.domain.Badge;
import ea.badge.domain.Membership;
import ea.badge.repository.MembershipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MembershipServiceImpl implements MembershipService{
    @Autowired
    private MembershipRepository membershipRepository;


    @Override
    public Membership addMembership(Membership membership) {
       return membershipRepository.save(membership);
    }

    @Override
    public void removeMembership(Long id) {
        membershipRepository.deleteById(id);
    }




}
