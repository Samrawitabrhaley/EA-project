package ea.badge.dto;

import ea.badge.domain.Plan;
import ea.badge.domain.Role;
import ea.badge.domain.Rule;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@NoArgsConstructor
@Data
@Getter
@Setter
public class PlanDto {

    private String planName;
    private String planDescription;
    private List<Role> role;
    private Rule rule;

}
