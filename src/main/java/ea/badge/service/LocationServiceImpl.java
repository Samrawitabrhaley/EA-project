package ea.badge.service;

import ea.badge.domain.Location;
import ea.badge.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class LocationServiceImpl implements LocationService{

    private Location loc;

    @Autowired
    private LocationRepository locationRepository;
    @Override
    public void addLocation(Location location) {
        this.locationRepository.save(location);
    }

    @Override
    public List<Location> getLocations() {
        return this.locationRepository.findAll();
    }

}
