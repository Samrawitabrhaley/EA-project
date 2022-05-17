package ea.badge.service;

import ea.badge.domain.Location;
import ea.badge.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationServiceImpl implements LocationService{

    private Location loc;

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
    public Optional<Location> findById(Long id) {

        return this.locationRepository.findById(id);
    }
    @Override
    public boolean existsById(Long id){
        return this.locationRepository.existsById(id);
    }

    @Override
    public void deleteById(Long id) {
        this.locationRepository.deleteById(id);
    }

    @Override
    public Location update(Location location) {
        return this.locationRepository.save(location);
    }

}
