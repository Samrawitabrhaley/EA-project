package ea.badge.service;

import ea.badge.domain.Plan;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface PlanService {

    public Plan addPlan(Plan plan);

    public void removePlan(Integer id);

    public List<Plan> findAll();

    public Plan findById(Integer id);

//    public Plan updatePlan(Plan plan);


}
