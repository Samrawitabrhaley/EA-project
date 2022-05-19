package ea.badge.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import java.util.Collection;


@Component
@NoArgsConstructor
@AllArgsConstructor
@Getter@Setter
public class MemberDto {
    private String firstName;
    private String lastName;
    private String emailAddress;

    private Collection<RoleDto> role;
//    private Collection<MembershipDto> membership;
//    private Collection<BadgeDto> badge;
}
