package ea.badge.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@Data
@Getter
@Setter
public class UserDto {

    private String username;
    private String password;
}
