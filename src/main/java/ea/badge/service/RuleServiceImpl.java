package ea.badge.service;

import ea.badge.domain.Rule;
import ea.badge.repository.RuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RuleServiceImpl implements RuleService{
    @Autowired
    private RuleRepository ruleRepository;

    @Override
    public Rule save(Rule rule) {
        return this.ruleRepository.save(rule);
    }

    @Override
    public List<Rule> findAll() {
        return  this.ruleRepository.findAll();
    }

    @Override
    public Optional<Rule> findById(Long id) {
        return this.ruleRepository.findById(id);
    }
    @Override
    public void deleteById(Long id){
        this.ruleRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return this.ruleRepository.existsById(id);
    }
    @Override
    public Rule update(Rule rule ){
        return this.ruleRepository.save(rule);
    }
}
