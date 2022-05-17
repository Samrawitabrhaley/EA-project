package ea.badge.dto;

import ea.badge.domain.Badge;
import ea.badge.domain.Membership;
import ea.badge.domain.Role;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;


@Component
@NoArgsConstructor
@Data
@Getter@Setter
public class MemberDto {
    private String firstName;
    private String lastName;
    private String emailAddress;
    private Collection<Role> role = new ArrayList<>();
    private Collection<Membership> membership = new ArrayList<>();
    private Collection<Badge> badge = new ArrayList<>();

}
