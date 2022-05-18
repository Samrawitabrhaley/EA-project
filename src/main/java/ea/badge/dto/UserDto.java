package ea.badge.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import ea.badge.domain.Member;
import lombok.*;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDto {

    private String username;
    private String password;
    private MemberDto member;
}
