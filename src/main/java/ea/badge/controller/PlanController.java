package ea.badge.controller;

import ea.badge.domain.Location;
import ea.badge.domain.Plan;
import ea.badge.dto.*;
import ea.badge.repository.PlanRepository;
import ea.badge.service.PlanService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.transaction.Transactional;
import javax.validation.Valid;
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
    public PlanDto getById(@PathVariable Long id) {
        return mapper.map(planService.findById(id), PlanDto.class);
    }

    @PutMapping("/{id}")
    public PlanDto update(@RequestBody Plan plan, @PathVariable Long id) {
        return mapper.map(planService.update(plan,id),PlanDto.class);

    }

    @DeleteMapping("/{id}")
    public void removePlan(@PathVariable Long id){

        planService.removePlan(id);
    }
}
