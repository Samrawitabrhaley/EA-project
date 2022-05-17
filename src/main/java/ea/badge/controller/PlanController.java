package ea.badge.controller;

import ea.badge.domain.Plan;
import ea.badge.dto.PlanDto;
import ea.badge.service.PlanService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("plans")
public class PlanController {
    @Autowired
    private PlanService planService;
    private ModelMapper mapper = new ModelMapper();

    @PostMapping
    public PlanDto addPlan(@RequestBody PlanDto plan) {

        return mapper.map(planService.addPlan(mapper.map(plan, Plan.class)), PlanDto.class);
    }
    @GetMapping

    public List<PlanDto> list() {
        return this.planService.findAll().stream()
                .map(plan -> mapper.map(plan, PlanDto.class)).collect(Collectors.toList());
    }

    @GetMapping("{id}")
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
