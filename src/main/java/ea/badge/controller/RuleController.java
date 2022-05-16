package ea.badge.controller;

import ea.badge.domain.Rule;
import ea.badge.service.RuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rules")
public class RuleController {

    @Autowired
    private RuleService ruleService;

    @GetMapping("")
    public List<Rule> findAll(){
        return this.ruleService.findAll();
    }
    @GetMapping("/{id}")
    public Optional<Rule> findById(@PathVariable(name="id") Long id){
        return this.ruleService.findById(id);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Rule> deleteById(@PathVariable(name="id") Long id){
        if(this.ruleService.existsById(id)) {
            this.ruleService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("")
    public Rule save (@RequestBody Rule rule){
        return ruleService.save(rule);
    }

    @PutMapping("/{id}")
    public Rule update(@RequestBody Rule newRule, @PathVariable(name="id") Long id) {
        System.out.println("Editing data");
        return this.ruleService.findById(id)
                .map(rule -> {
                    rule.setAllowedLimit(newRule.getAllowedLimit());
                    rule.setPerDurationDays(newRule.getPerDurationDays());
                    return ruleService.save(rule);
                }).orElseGet(() -> {
                    newRule.setId(id);
                    return ruleService.save(newRule);
                });
    }
}
