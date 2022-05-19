package ea.badge.service;

import ea.badge.domain.Location;
import ea.badge.domain.Membership;
import ea.badge.domain.Plan;
import ea.badge.domain.Transaction;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
@Service
public interface PlanService {

    Collection<Membership> getPlansByMemberId(Long memberId);

    public Plan addPlan(Plan plan);

    public Plan update(Plan plan, Long id);

    public void removePlan(Long id);

    public List<Plan> findAll();

    public Plan findById(Long id);

    Collection<Location> getLocationsByPlanId(Long id);
//    public Plan updatePlan(Plan plan);


}
