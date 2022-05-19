package ea.badge.service;


import ea.badge.domain.Badge;
import ea.badge.domain.Member;
import ea.badge.repository.BadgeRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class BadgeServiceTest {

    @Mock
    private BadgeRepository badgeRepository;

    @InjectMocks
    private BadgeServiceImpl badgeService;

    private List<Badge> badgesList = new ArrayList<>();

    @BeforeEach
    public void setup() {
        Badge badge1 = new Badge(1L, LocalDate.of(2022, 5, 5), LocalDate.of(2022, 6, 1), true, new Member(1L, "mem1", "mem1", "mem1@miu.edu"));
        Badge badge2 = new Badge(2L, LocalDate.of(2022, 5, 5), LocalDate.of(2022, 6, 1), true, new Member(2L, "mem2", "mem2", "mem2@miu.edu"));
        badgesList.add(badge1);
        badgesList.add(badge2);
    }

    @Test
    void findAllTest() {


        Mockito.when(badgeRepository.findAll()).thenReturn(badgesList);
        Collection<Badge> actual = badgeService.findAll();
        assertThat(actual).isEqualTo(badgesList);
    }

    @Test
    void findByIdTest() {
        Mockito.when(badgeRepository.getById(1L)).thenReturn(badgesList.get(0));
        Badge actual = badgeService.findById(1L);
        assertThat(actual.getMember().getFirstName()).isEqualTo("mem1");
    }

    @Test
    void findByMemberIdTest() {
        Collection<Badge> mem1Badges=new ArrayList<>();
        Badge badge1 = new Badge(1L, LocalDate.of(2022, 5, 5), LocalDate.of(2022, 6, 1), true, new Member(1L, "mem1", "mem1", "mem1@miu.edu"));
        mem1Badges.add(badge1);
        //TODO fix this method in BadgeController and retest
        Mockito.when(badgeRepository.findByMemberId(1L)).thenReturn(mem1Badges);
        List<Badge> actual = (List<Badge>) badgeService.findByMemberId(1L);
        assertThat(actual.get(0).getMember().getFirstName()).isEqualTo("mem1");
    }

//    @Test
//    void createOrUpdateTest() {
//        Badge badge = new Badge(1L, LocalDate.of(2022, 5, 5), LocalDate.of(2022, 6, 1), true, new Member(1L, "mem1", "mem1", "mem1@miu.edu"));
//        Mockito.when(badgeRepository.save(badge)).thenReturn(badge);
//        Badge actual = badgeService.createOrUpdate(badge);
//        assertThat(actual).isEqualTo(badge);
//    }

//    @Test
//    void replaceWithNewTest() {
//        Badge badge = new Badge(3L, LocalDate.of(2022, 5, 5), LocalDate.of(2022, 6, 1), true, new Member(1L, "mem1", "mem1", "mem1@miu.edu"));
//        Mockito.when(badgeService.replaceWithNew(badge));
//        Badge actual = badgeService.replaceWithNew(badge);
//        assertThat(actual).isEqualTo(badge);
//    }

    @Test
    void deactivateByIdTest() {
        Badge badge = new Badge(1L, LocalDate.of(2022, 5, 5), LocalDate.of(2022, 6, 1), false, new Member(1L, "mem1", "mem1", "mem1@miu.edu"));
        Mockito.when(badgeRepository.getById(1L)).thenReturn(badge);
        Badge actual = badgeService.deactivateById(1L);
        assertThat(actual).isEqualTo(badge);
    }

    @Test
    void activateByIdTest() {
        Badge badge = new Badge(1L, LocalDate.of(2022, 5, 5), LocalDate.of(2022, 6, 1), true, new Member(1L, "mem1", "mem1", "mem1@miu.edu"));
        Mockito.when(badgeRepository.getById(1L)).thenReturn(badge);
        Badge actual = badgeService.activateById(1L);
        assertThat(actual).isEqualTo(badge);
    }

    @Test
    void deleteByIdTest() {
        badgeService.deleteById(1L);
        verify(badgeRepository, times(1)).deleteById(1L);

//        Badge badge = new Badge(1L, LocalDate.of(2022, 5, 5), LocalDate.of(2022, 6, 1), true, new Member(1L, "mem1", "mem1", "mem1@miu.edu"));
//        badgeService.deleteById(1L);
//        Badge actual = null;
//        assertThat(actual).isEqualTo(badge);
    }
}