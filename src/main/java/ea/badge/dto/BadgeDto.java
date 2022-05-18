package ea.badge.dto;


import ea.badge.domain.Member;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


@Component
@NoArgsConstructor

@Getter@Setter
public class BadgeDto {
    private LocalDate activationDate;
    private LocalDate expirationDate;
    private Boolean active;

    private MemberDto member;
}
