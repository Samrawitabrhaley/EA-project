package ea.badge.dto;

import ea.badge.domain.Rule;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@NoArgsConstructor
@Data
@Getter@Setter
public class RuleDto {
    private int perDurationDays;
    private int allowedLimit;
    public RuleDto mapToRuleDTO(Rule rule ){
      this.setAllowedLimit(rule.getAllowedLimit());
      this.setPerDurationDays(rule.getPerDurationDays());
      return this;
    }
}
