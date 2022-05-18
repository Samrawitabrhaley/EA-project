package ea.badge.service;

import ea.badge.domain.Rule;
import ea.badge.exception.ResourceNotFoundException;
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
    public Rule findById(Long id) {
        return this.ruleRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }
    @Override
    public void deleteById(Long id){
        if(! ruleRepository.existsById(id)){
            throw new ResourceNotFoundException();
        }
        this.ruleRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return this.ruleRepository.existsById(id);
    }
    @Override
    public Rule update(Rule newRule, Long id ){
       return  this.ruleRepository.findById(id).map(rule->{
           rule.setAllowedLimit(newRule.getAllowedLimit());
           rule.setPerDurationDays(newRule.getPerDurationDays());
           return this.ruleRepository.save(rule);
       }).orElseThrow(ResourceNotFoundException::new);
    }
}
