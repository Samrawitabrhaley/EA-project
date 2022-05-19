package ea.badge.controller;

import ea.badge.domain.Plan;
import ea.badge.dto.*;
import ea.badge.repository.PlanRepository;
import ea.badge.service.PlanService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.transaction.Transactional;
import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/plans")
public class PlanController {
    @Autowired
    private PlanService planService;

    @Autowired
    private PlanRepository planRepository;

    @Autowired
    private ModelMapper mapper;

    @PostMapping
    public PlanDto addPlan(@RequestBody Plan plan) {
        return mapper.map(planRepository.save(mapper.map(plan, Plan.class)), PlanDto.class);
    }

    @GetMapping
    public Collection<PlanDto> findAll() {
        return planService.findAll().stream().map(planService ->mapper
                .map(planService, PlanDto.class)).collect(Collectors.toList());
    }

    @GetMapping("/{planId}/locations")
    public Collection<LocationDto> getPlanLocations(@PathVariable("planId") Long id){
        return planService.getLocationsByPlanId(id).stream()
                .map(location -> mapper.map(location, LocationDto.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public PlanDto getById(@PathVariable Integer id) {
        return mapper.map(planService.findById(id), PlanDto.class);
    }

    @PutMapping(value = "/{id}")
    public PlanDto updatePlan(@PathVariable Plan plan){
        return mapper.map(planService.addPlan(plan), PlanDto.class);
    }

    @DeleteMapping("/{id}")
    public void removePlan(@PathVariable Integer id){
        planService.removePlan(id);
    }
}
