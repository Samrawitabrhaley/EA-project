package ea.badge.service;

import ea.badge.domain.Rule;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface RuleService {
    public Rule save(Rule rule);
    public List<Rule> findAll();
    public Rule findById(Long id);
    public void deleteById(Long id);
    public Rule update(Rule rule, Long id);
    public boolean existsById(Long id);
}
