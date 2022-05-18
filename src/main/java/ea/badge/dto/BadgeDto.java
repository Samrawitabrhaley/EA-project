package ea.badge.dto;


import ea.badge.domain.Member;
import lombok.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


@Component
@NoArgsConstructor
@AllArgsConstructor
@Getter@Setter
public class BadgeDto {
    private LocalDate activationDate;
    private LocalDate expirationDate;
    private Boolean active;

    private MemberDto member;
}
