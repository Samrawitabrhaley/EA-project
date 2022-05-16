package ea.badge.service;

import ea.badge.domain.Location;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface LocationService {
    public void addLocation(Location location);
    public List<Location> getLocations();

}
