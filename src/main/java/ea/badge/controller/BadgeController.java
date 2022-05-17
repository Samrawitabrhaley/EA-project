package ea.badge.controller;

import ea.badge.domain.Badge;
import ea.badge.dto.BadgeDto;
import ea.badge.service.BadgeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/badges")
public class BadgeController {
    @Autowired
    private BadgeService badgeService;
    private ModelMapper mapper = new ModelMapper();

    @PostMapping("/badges/{id}/scan/{location_id}")
    private void scanBadge(@PathVariable("id") Long id, @PathVariable("location_id") Long locationId) {

    }

    @GetMapping
    public Collection<BadgeDto> getAll() {
        return this.badgeService.findAll().stream()
                .map(badge -> mapper.map(badge, BadgeDto.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public BadgeDto getById(@PathVariable("id") Long id) {
        return mapper.map(badgeService.findById(id), BadgeDto.class);
    }

    @PostMapping
    @PutMapping
    public BadgeDto createOrUpdate(@RequestBody BadgeDto badge) {
        return mapper.map(badgeService.createOrUpdate(mapper.map(badge, Badge.class)),
                BadgeDto.class);
    }

    @PostMapping("/{id}/replace")
    public BadgeDto replaceWithNew(@RequestBody Badge badge) {
        return mapper.map(badgeService.replaceWithNew(badge),BadgeDto.class);
//        return badgeService.replaceWithNew(badge);
    }

    @PutMapping("/{id}/deactivate")
    public BadgeDto deactivate(@RequestBody Badge badge) {
        return mapper.map(badgeService.deactivateById(badge.getId()), BadgeDto.class);
//        return service.deactivateById(badge.getId());
    }

    @PutMapping("/{id}/activate")
    public BadgeDto activate(@RequestBody Badge badge) {
        return mapper.map(badgeService.activateById(badge.getId()), BadgeDto.class);
//        return service.activateById(badge.getId());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        badgeService.deleteById(id);
    }
}
