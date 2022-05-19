package ea.badge.service;

import ea.badge.domain.Location;
import ea.badge.domain.Membership;
import ea.badge.domain.Plan;
import ea.badge.domain.Transaction;
import ea.badge.dto.PlanDto;
import ea.badge.exception.ResourceNotFoundException;
import ea.badge.repository.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PlanServiceImpl implements PlanService {

    @Autowired
    private PlanRepository planRepository;

    @Override
    public List<Plan> findAll() {
        return planRepository.findAll();
    }

    @Override
    public Plan findById(Long id) {
        return planRepository.findById(id).get();
    }

    @Override
    public Collection<Location> getLocationsByPlanId(Long id) {
        return planRepository.getLocationsByPlanId(id);
    }


    @Override
    public Collection<Membership> getPlansByMemberId(Long memberId) {
        return planRepository.getPlansByMemberId(memberId);
    }

    @Override
    public Plan addPlan(Plan plan) {

        return planRepository.save(plan);
    }

    @Override
    public Plan update(Plan plan, Long id) {
        return this.planRepository.findById(id) .map(Plan -> {
            plan.setPlanName(plan.getPlanName());
            plan.setPlanDescription(plan.getPlanDescription());
            plan.setRole(plan.getRole());
            plan.setRule(plan.getRule());
            plan.setActive(true);
            return planRepository.save(plan);
        }).orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public void removePlan( Long id) {
        Plan inActivePlan = planRepository.findById(id).get();
        inActivePlan.setActive(false);
        planRepository.save(inActivePlan);

    }
}
