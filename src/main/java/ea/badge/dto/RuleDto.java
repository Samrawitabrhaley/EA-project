package ea.badge.dto;
import lombok.*;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Getter@Setter
public class RuleDto {
    private int perDurationDays;
    private int allowedLimit;
}
