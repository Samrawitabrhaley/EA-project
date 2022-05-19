package ea.badge.dto;

import ea.badge.domain.Badge;
import ea.badge.domain.Location;
import lombok.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Getter@Setter
public class TransactionDto {
    private BadgeDto badge;
//    private LocationDto location;
    private LocationDto location;
    private LocalDateTime datetime;
    private Boolean succeed;
}
