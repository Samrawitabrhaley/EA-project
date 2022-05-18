package ea.badge.service;

import ea.badge.domain.Location;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface LocationService {
    public Location save(Location location);
    public List<Location> findAll();
    public Location findById(Long id);
    public boolean existsById(Long id);
    public void deleteById(Long id);
    public Location update(Location location, Long id);


}
