package ea.badge.controller;

import ea.badge.domain.Rule;
import ea.badge.dto.RuleDto;
import ea.badge.service.RuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rules")
public class RuleController {

    @Autowired
    private RuleService ruleService;

    @Autowired
    private RuleDto ruleDtoObj;

    @GetMapping("")
    public List<RuleDto> findAll(){
        return this.ruleService.findAll().stream()
                .map(rule -> ruleDtoObj.mapToRuleDTO(rule)).collect(Collectors.toList());
    }
    @RolesAllowed("user")
    @GetMapping("/{id}")
    public Optional<RuleDto> findById(@PathVariable(name="id") Long id){
        return this.ruleService.findById(id).map(rule -> ruleDtoObj.mapToRuleDTO(rule));
    }
    @RolesAllowed("admin")
    @DeleteMapping("/{id}")
    public ResponseEntity<RuleDto> deleteById(@PathVariable(name="id") Long id){
        if(this.ruleService.existsById(id)) {
            this.ruleService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("")
    public RuleDto save (@RequestBody Rule rule){
        Rule savedRule = ruleService.save(rule);
        return ruleDtoObj.mapToRuleDTO(savedRule);
    }

    @PutMapping("/{id}")
    public RuleDto update(@RequestBody Rule  newRule, @PathVariable(name="id") Long id) {
        System.out.println("Editing data");
        return this.ruleService.findById(id)
                .map(rule -> {
                    return ruleDtoObj.mapToRuleDTO(ruleService.save(newRule));
                })
                .orElseGet(() -> {
                    newRule.setId(id);
                    return ruleDtoObj.mapToRuleDTO(ruleService.save(newRule));
                });
    }
}
