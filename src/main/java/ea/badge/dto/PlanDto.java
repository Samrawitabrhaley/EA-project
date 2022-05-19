package ea.badge.dto;

import ea.badge.domain.Plan;
import ea.badge.domain.Role;
import ea.badge.domain.Rule;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PlanDto {

    private String planName;
    private String planDescription;
    private List<RoleDto> role;
    private RuleDto rule;

}
