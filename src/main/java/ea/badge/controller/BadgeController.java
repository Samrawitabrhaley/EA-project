package ea.badge.controller;

import ea.badge.domain.Transaction;
import ea.badge.dto.BadgeDto;
import ea.badge.dto.TransactionDto;
import ea.badge.service.BadgeScanService;
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
    private BadgeScanService badgeScanService;

    @Autowired
    private ModelMapper mapper;

//    @RolesAllowed("admin")
    @PostMapping("/{id}/scan/{location_id}")
    private ResponseEntity<TransactionDto> scanBadge(@PathVariable("id") Long badgeId, @PathVariable("location_id") Long locationId) {
        Transaction transaction = badgeScanService.scan(badgeId, locationId);
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

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        badgeService.deleteById(id);
    }
}
