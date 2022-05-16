package ea.badge.repository;

import ea.badge.domain.Rule;
import lombok.NoArgsConstructor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RuleRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private RuleRepository ruleRepository;

    @Test
    public void whenFindById_thenReturnRule(){
        //given
        Rule rule1 = new Rule(1L,7,21 );
        entityManager.persist(rule1);
        entityManager.flush();
        //when
        Rule found = ruleRepository.getById(rule1.getId());
        //then
        assertThat(found.getId()).isEqualTo(rule1.getId());

    }
}