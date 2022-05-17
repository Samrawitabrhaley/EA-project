package ea.badge.service;



import ea.badge.domain.Member;
import ea.badge.repository.MemberRepository;
import org.junit.Rule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.Assertions.assertThat;



import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class MemberServiceTest {
    List<Member> memberlist=new ArrayList<>();
    @Mock
    private MemberRepository memberRepository;

    @InjectMocks
    private MemberServiceImpl memberService;


    @BeforeEach
    public void setup() {

    Member member1=new Member(1L,"samri","Abrha","samri@gmail.com");
    Member member2=new Member(2L,"Bisr","Abrha","samri@gmail.com");
        memberlist.add(member1);
        memberlist.add(member2);

    }

    @Test
    public void getAllMembersTest(){

        Mockito.when(memberRepository.findAll()).thenReturn(memberlist);
        Collection<Member> actual = memberService.getAllMembers();
        assertThat(actual).isEqualTo(memberlist);
    }

    @Test
    public void getMemberByIdTest(){
       Mockito.when(memberRepository.getById(1L)).thenReturn(memberlist.get(0));
        Long id=1L;
        Member actual=memberService.getMemberById(id);
        assertThat(actual.getFirstName()).isEqualTo("samri");

    }

    @Test
    public void createMemberTest(){
        Member member3=new Member(1L,"samri","Abrha","samri@gmail.com");
        Mockito.when(memberRepository.save(member3)).thenReturn(member3);
        Member actual=memberService.createMember(member3);
        assertThat(actual).isEqualTo(member3);

    }
    @Test
    public void deleteByIdTest(){
        memberService.deleteById(1L);
        verify(memberRepository, times(1)).deleteById(1L);
    }
    @Test
    public void updateByIdTest(){
        Member member4=new Member(1L,"James","Abrha","samri@gmail.com");
        Mockito.when(memberRepository.findById(1L)).thenReturn(Optional.of(member4));
        Mockito.when(memberRepository.save(member4)).thenReturn(member4);
        Member actual=memberService.updateById(member4,1L);
        assertThat(actual).isEqualTo(member4);
        verify(memberRepository, times(1)).save(member4);

    }


}