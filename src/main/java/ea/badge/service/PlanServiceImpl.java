package ea.badge.service;

import ea.badge.domain.Plan;
import ea.badge.repository.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PlanServiceImpl implements PlanService {

    @Autowired
    private PlanRepository planRepository;

    @Override
    public List<Plan> findAll() {
        return planRepository.findAll();
    }

    @Override
    public Plan getById(Integer id) {
        return planRepository.findById(id).get();
    }

    @Override
    public void addPlan(Plan plan) {
        planRepository.save(plan);
    }

    @Override
    public void removePlan(Integer id) {
        planRepository.deleteById(id);
    }








}
