package ea.badge.service;

import ea.badge.domain.Plan;
import ea.badge.repository.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PlanServiceImpl implements PlanService {

    @Autowired
    private PlanRepository planRepository;

    @Override
    public List<Plan> findAll() {
        return planRepository.findAll();
    }

    @Override
    public Plan findById(Integer id) {
        return planRepository.findById(id).get();
    }

//    @Override
//    public Plan updatePlan(Plan plan) {
//        return planRepository.save(plan);
//    }

    @Override
    public Plan addPlan(Plan plan) {
        return planRepository.save(plan);
    }

    @Override
    public void removePlan(Integer id) {
        planRepository.deleteById(id);
    }








}
