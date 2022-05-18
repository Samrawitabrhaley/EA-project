package ea.badge.service;

import ea.badge.domain.Membership;
import ea.badge.domain.Plan;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
@Service
public interface PlanService {

    Collection<Membership> getPlansByMemberId(Long memberId);

    public Plan addPlan(Plan plan);

    public void removePlan(Integer id);

    public List<Plan> findAll();

    public Plan findById(Integer id);

//    public Plan updatePlan(Plan plan);


}
