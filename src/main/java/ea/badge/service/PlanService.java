package ea.badge.service;

import ea.badge.domain.Plan;

import java.util.List;

public interface PlanService {

    public void addPlan(Plan plan);

    public void removePlan(Integer id);

    public List<Plan> findAll();

    public Plan getById(Integer id);


}
