package ea.badge.dto;
import ea.badge.domain.Location;
import ea.badge.domain.Member;
import ea.badge.domain.MembershipType;
import ea.badge.domain.Plan;
import lombok.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Collection;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Getter@Setter
public class MembershipDto {
    private LocalDate startDate;
    private LocalDate endDate;
    private MembershipType membershipType;
    private MemberDto member;
    private Collection<PlanDto> plan;

}
