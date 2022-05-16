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
    @Autowired
    private BadgeService badgeService;

    @Override
    public void addMembership(Membership membership) {
       membershipRepository.save(membership);
    }

    @Override
    public void removeMembership(Long id) {
        membershipRepository.deleteById(id);
    }
    @Override
    public Badge createBadge(Badge badge){
        return badgeService.create(badge);
    }
    @Override
     public Badge replaceBadge(Badge bagde){
        return badgeService.replaceWithNew(bagde);
     }
     @Override
     public Badge deactivateBadge(Integer id){
        return badgeService.deactivateById(id);
     }



}
