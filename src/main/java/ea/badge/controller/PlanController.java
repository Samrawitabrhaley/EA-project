package ea.badge.controller;

import ea.badge.domain.Plan;
import ea.badge.dto.MembershipDto;
import ea.badge.dto.PlanDto;
import ea.badge.service.PlanService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.transaction.Transactional;
import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/members/{memberId}/plans")
public class PlanController {
    @Autowired
    private PlanService planService;
    private ModelMapper mapper = new ModelMapper();

    @GetMapping
    public Collection<MembershipDto> getPlans(@PathVariable("memberId") Long memberId) {
        return this.planService.getPlansByMemberId(memberId).stream()
                .map(membership -> mapper.map(membership, MembershipDto.class)).collect(Collectors.toList());
    }

    @PostMapping
    public PlanDto addPlan(@RequestBody PlanDto plan) {

        return mapper.map(planService.addPlan(mapper.map(plan, Plan.class)), PlanDto.class);
    }

    @GetMapping("/{id}")
    @Transactional
    public PlanDto getById(@PathVariable Integer id) {
        return mapper.map(planService.findById(id), PlanDto.class);
    }

//    @PutMapping(value = "/{id}")
////    @Transactional
////    public PlanDto updatePlan(@PathVariable PlanDto plan){
////        return mapper.map(planService.addPlan(plan), PlanDto.class);
////    }
    @DeleteMapping("/{id}")
    public void removePlan(@PathVariable Integer id){
        planService.removePlan(id);
    }
}
