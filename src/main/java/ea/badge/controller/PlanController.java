package ea.badge.controller;

import ea.badge.domain.Plan;
import ea.badge.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/plans")
public class PlanController {
    @Autowired
    private PlanService planService;

    @PostMapping
    public void addPlan(Plan plan){
        planService.addPlan(plan);
    }

    @GetMapping
    public List<Plan> list(){
        return planService.findAll();
    }

    @GetMapping("/{id}")
    public Plan getById(@PathVariable Integer id){
        return planService.getById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Plan> update(@RequestBody Plan plan, @PathVariable Integer id){
        try{
            Plan existPlan = planService.getById(id);
            planService.addPlan(plan);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch(NoSuchElementException r){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        planService.removePlan(id);
    }

}
