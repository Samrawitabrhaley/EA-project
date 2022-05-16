package ea.badge.controller;

import ea.badge.domain.Location;
import ea.badge.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/locations")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @GetMapping("")
    public List<Location> findAll(){
        return this.locationService.findAll();
    }
    @GetMapping("/{id}")
    public Optional<Location> findById(@PathVariable(name="id") Long id){
        return this.locationService.findById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Location> deleteById(@PathVariable(name="id") Long id){
        if(this.locationService.existsById(id)) {
            this.locationService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("")
    public Location save (@RequestBody Location location){
        return locationService.save(location);
    }

    @PutMapping("/{id}")
    public Location update(@RequestBody Location newLocation, @PathVariable(name="id") Long id) {
        System.out.println("Editing data");
        return this.locationService.findById(id)
                .map(location -> {
                    location.setName(newLocation.getName());
                    location.setLocationType(newLocation.getLocationType());
                    location.setCapacity(newLocation.getCapacity());
                    location.setDescription(newLocation.getDescription());
                    location.setMembershipList(newLocation.getMembershipList());
                    location.setPlanList(newLocation.getPlanList());
                    location.setTimeSlotList(newLocation.getTimeSlotList());
                    return locationService.save(location);
                }).orElseGet(() -> {
                    newLocation.setId(id);
                    return locationService.save(newLocation);
                });
    }


}
