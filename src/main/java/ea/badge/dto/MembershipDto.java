package ea.badge.dto;
import ea.badge.domain.Location;
import ea.badge.domain.Member;
import ea.badge.domain.MembershipType;
import ea.badge.domain.Plan;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Collection;

@Component
@NoArgsConstructor
@Getter@Setter
public class MembershipDto {
    private LocalDate startDate;
    private LocalDate endDate;
    private MembershipType membershipType;
//    private MemberDto member;
//    private Collection<PlanDto> plan;
//    private LocationDto location;
}
