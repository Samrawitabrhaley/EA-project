package ea.badge.service;

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
    public void addMembership(Membership membership) {
       membershipRepository.save(membership);
    }

    @Override
    public List<Membership> getMemberships() {
        return membershipRepository.findAll();
    }


}
