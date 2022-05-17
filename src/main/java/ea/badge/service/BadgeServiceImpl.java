package ea.badge.service;

import ea.badge.domain.Badge;
import ea.badge.repository.BadgeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@Transactional
public class BadgeServiceImpl implements BadgeService {
    @Autowired
    private BadgeRepository repository;

    public Collection<Badge> findAll() { return repository.findAll(); }

    public Badge findById(Integer id) { return repository.findById(id).get(); }

    @Override
    public Collection<Badge> findByMemberId(Integer id) {
        return repository.findByMemberId(id);
    }

    public Badge createOrUpdate(Badge badge) { return repository.save(badge); }

    @Override
    public Badge replaceWithNew(Badge newBadge) {
        repository.deactivateByMemberId(newBadge.getId());
        return repository.save(newBadge);
    }

    @Override
    public Badge deactivateById(Integer id) { return repository.deactivateById(id); }

    @Override
    public Badge activateById(Integer id) { return repository.activateById(id); }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }


}
