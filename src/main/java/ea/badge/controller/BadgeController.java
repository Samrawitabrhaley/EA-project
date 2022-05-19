package ea.badge.controller;

import ea.badge.domain.Badge;
import ea.badge.domain.Member;
import ea.badge.domain.Transaction;
import ea.badge.dto.BadgeDto;
import ea.badge.dto.LocationDto;
import ea.badge.dto.MemberDto;
import ea.badge.dto.TransactionDto;
import ea.badge.service.BadgeScan;
import ea.badge.service.BadgeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/badges")
public class BadgeController {
    @Autowired
    private BadgeService badgeService;

    @Autowired
    private BadgeScan badgeScan;

    @Autowired
    ModelMapper mapper;

    @GetMapping("/{id}/scan/{location_id}")
    @RolesAllowed("admin")
    private ResponseEntity<TransactionDto> scanBadge(@PathVariable("id") Long badgeId, @PathVariable("location_id") Long locationId) {
        Transaction transaction = badgeScan.scan(badgeId, locationId);
        TransactionDto transactionDto = mapper.map(transaction, TransactionDto.class);
        return ResponseEntity.ok(transactionDto);
    }

    @GetMapping()
    public Collection<BadgeDto> getAll() {
        return this.badgeService.findAll().stream()
                .map(badge -> mapper.map(badge, BadgeDto.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public BadgeDto getById(@PathVariable("id") Long id) {
        return mapper.map(badgeService.findById(id), BadgeDto.class);
    }

//    @PostMapping
//    @PutMapping
//    public BadgeDto createOrUpdate(@RequestBody BadgeDto badge) {
//        return mapper.map(badgeService.createOrUpdate(mapper.map(badge, Badge.class), BadgeDto.class),
//                BadgeDto.class);
//    }

//    @PostMapping("/{id}/replace")
//    public BadgeDto replaceWithNew(@RequestBody Badge badge) {
//        return mapper.map(badgeService.replaceWithNew(badge),BadgeDto.class);
////        return badgeService.replaceWithNew(badge);
//    }
//
//    @PostMapping("/{id}/deactivate")
//    public BadgeDto deactivate(@PathVariable("id") Long id) {
//        return mapper.map(badgeService.deactivateById(id), BadgeDto.class);
////        return service.deactivateById(badge.getId());
//    }
//
//    @PostMapping("/{id}/activate")
//    public BadgeDto activate(@PathVariable("id") Long id) {
//        return mapper.map(badgeService.activateById(id), BadgeDto.class);
////        return service.activateById(badge.getId());
//    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        badgeService.deleteById(id);
    }
}
