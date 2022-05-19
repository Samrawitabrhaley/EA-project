package ea.badge.service;

import ea.badge.domain.Location;
import ea.badge.exception.ResourceNotFoundException;
import ea.badge.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class LocationServiceImpl implements LocationService{

    @Autowired
    private LocationRepository locationRepository;
    @Override
    public Location save(Location location) {
        return this.locationRepository.save(location);
    }

    @Override
    public List<Location> findAll() {
        return this.locationRepository.findAll();
    }

    @Override
    public Location findById(Long id) {

        return this.locationRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }
    @Override
    public boolean existsById(Long id){
        return this.locationRepository.existsById(id);
    }

    @Override
    public void deleteById(Long id) {
        if( ! locationRepository.existsById(id))  {
            throw new ResourceNotFoundException();
        }
        locationRepository.deleteById(id);
    }

    @Override
    public Location update(Location newLocation, Long id) {
        return this.locationRepository.findById(id) .map(location -> {
            location.setName(newLocation.getName());
            location.setLocationType(newLocation.getLocationType());
            location.setCapacity(newLocation.getCapacity());
            location.setDescription(newLocation.getDescription());
            location.setMemberships(newLocation.getMemberships());
            location.setPlans(newLocation.getPlans());
            location.setTimeslots(newLocation.getTimeslots());
            return locationRepository.save(location);
        }).orElseThrow(ResourceNotFoundException::new);
    }

}
