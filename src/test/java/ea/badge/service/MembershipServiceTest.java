package ea.badge.service;

import ea.badge.domain.Member;
import ea.badge.domain.Membership;
import ea.badge.repository.MemberRepository;
import ea.badge.repository.MembershipRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class MembershipServiceTest {
    List<Membership> membershiplist=new ArrayList<>();
    @Mock
    private MembershipRepository membershipRepository;

    @InjectMocks
    private MembershipServiceImpl membershipService;

    @Test
    void addMembership() {
        Membership membership1=new Membership(1L, LocalDate.of(2022,4,3),LocalDate.of(2023,4,3));
        Mockito.when(membershipRepository.save(membership1)).thenReturn(membership1);
        Membership actual=membershipService.addMembership(membership1);
        assertThat(actual).isEqualTo(membership1);

    }

    @Test
    void removeMembership() {
        membershipService.removeMembership(1L);
        verify(membershipRepository, times(1)).deleteById(1L);
    }
}