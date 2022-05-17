package ea.badge.controller;

import ea.badge.domain.Location;
import ea.badge.domain.Plan;
import ea.badge.dto.LocationDto;
import ea.badge.repository.LocationRepository;
import ea.badge.service.LocationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/locations")
public class LocationController {

    @Autowired
    private LocationService locationService;
    private ModelMapper mapper = new ModelMapper();

    @GetMapping()
    public List<LocationDto> findAll(){

        return this.locationService.findAll().stream()
                .map(location -> mapper.map(location, LocationDto.class))
                .collect(Collectors.toList());
    }
    @GetMapping("{id}")
    @Transactional
    public LocationDto findById(@PathVariable Long id) {
        return mapper.map(locationService.findById(id).get(), LocationDto.class);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
         locationService.deleteById(id);
    }

    @PostMapping("")
    public LocationDto save(@RequestBody LocationDto location){

        return mapper.map(locationService.save(mapper.map(location, Location.class)), LocationDto.class);
    }

    @PutMapping("/{id}")
    public LocationDto update(@RequestBody Location newLocation, @PathVariable Long id) {

        return mapper.map(this.locationService.findById(id)
                .map(location -> {
                    location.setName(newLocation.getName());
                    location.setLocationType(newLocation.getLocationType());
                    location.setCapacity(newLocation.getCapacity());
                    location.setDescription(newLocation.getDescription());
                    location.setMemberships(newLocation.getMemberships());
                    location.setPlans(newLocation.getPlans());
                    location.setTimeslots(newLocation.getTimeslots());
                    return locationService.save(location);
                }).orElseGet(() -> {
                    return locationService.save(newLocation);
                }), LocationDto.class);
    }


}
