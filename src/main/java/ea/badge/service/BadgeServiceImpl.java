package ea.badge.service;

import ea.badge.domain.Badge;
import ea.badge.domain.Member;
import ea.badge.repository.BadgeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Objects;

@Service
@Transactional
public class BadgeServiceImpl implements BadgeService {
    @Autowired
    private BadgeRepository repository;

    public Collection<Badge> findAll() { return repository.findAll(); }

    public Badge findById(Long id) { return repository.getById(id); }

    @Override
    public Collection<Badge> findByMemberId(Long id) {
        return repository.findByMemberId(id);
    }

    public Badge createOrUpdate(Member member, Badge badge) {
        Badge badgeToSave;
        if(Objects.nonNull(badge.getId())) {
            badgeToSave = findById(badge.getId());
            badgeToSave.setActivationDate(badge.getActivationDate());
            badgeToSave.setExpirationDate(badge.getExpirationDate());
            badgeToSave.setActive(badge.getActive());
            badgeToSave.setMember(member);
        } else {
            badgeToSave = new Badge(badge.getActivationDate(), badge.getExpirationDate(), badge.getActive(), member);
        }
        return repository.save(badgeToSave);
    }

    @Override
    public Badge replaceWithNew(Member member, Long oldBadge, Badge newBadge) {
        Badge replacementBadge = new Badge(newBadge.getActivationDate(), newBadge.getExpirationDate(), newBadge.getActive(), member);
        repository.deactivateById(oldBadge);
//        repository.deactivateByMemberId(member.getId());
        return repository.save(replacementBadge);
    }

    @Override
    public Badge deactivateById(Long id) {
        repository.deactivateById(id);
        return repository.getById(id);
    }

    @Override
    public Badge activateById(Long id) {
        repository.activateById(id);
        return repository.getById(id);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Badge findActiveBadgeByMemberId(Long id) {
        return repository.findActiveBadgeByMemberId(id);
    }

    @Override
    public Collection<Badge> findInactiveBadgeByMemberId(Long id) {
        return repository.findInactiveBadgeByMemberId(id);
    }

}
