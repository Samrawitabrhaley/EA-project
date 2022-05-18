package ea.badge.controller;

import ea.badge.domain.Member;
import ea.badge.domain.Rule;
import ea.badge.dto.BadgeDto;
import ea.badge.dto.MemberDto;
import ea.badge.dto.RuleDto;
import ea.badge.service.RuleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rules")
public class RuleController {

    @Autowired
    private RuleService ruleService;

    @Autowired
    private ModelMapper mapper;

    @GetMapping("")
    public Collection<RuleDto> findAll(){
        return this.ruleService.findAll().stream()
                .map(rule -> mapper.map(rule, RuleDto.class)).collect(Collectors.toList());
    }
    @RolesAllowed("user")
    @GetMapping("/{id}")
    public RuleDto findById(@PathVariable(name="id") Long id){
        return mapper.map(ruleService.findById(id), RuleDto.class);
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
        return mapper.map(ruleService.save(rule), RuleDto.class);
    }

    @PutMapping("/{id}")
    public RuleDto update(@RequestBody Rule  newRule, @PathVariable(name="id") Long id) {
        return this.ruleService.findById(id)
                .map(rule -> {
                    return mapper.map(ruleService.save(newRule), RuleDto.class);
                })
                .orElseGet(() -> {
                    newRule.setId(id);
                    return mapper.map(ruleService.update(newRule), RuleDto.class);
                });
    }
}
