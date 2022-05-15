package ea.badge.controller;

import ea.badge.domain.Badge;
import ea.badge.service.BadgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/badges")
public class BadgeController {
    @Autowired
    private BadgeService service;

    @GetMapping
    public Collection<Badge> findAll() { return service.findAll(); }
    @GetMapping("/{id}")
    public Badge findById(@PathVariable("id") Integer id) { return service.findById(id); }

    @PostMapping
    public Badge create(@RequestBody Badge badge) { return service.create(badge); }
    @PostMapping("/{id}/replace")
    public Badge replaceWithNew(@RequestBody Badge badge) { return service.replaceWithNew(badge); }
    @PutMapping("/{id}/deactivate")
    public Badge replaceWithNew(@PathVariable("id") Integer id) { return service.deactivateById(id); }
}
