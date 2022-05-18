package ea.badge.dto;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@Data
@Getter@Setter
public class RuleDto {
    private int perDurationDays;
    private int allowedLimit;
}
