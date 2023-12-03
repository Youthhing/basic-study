package youth.study.service;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import youth.study.dto.MemberRequestDto;
import youth.study.entity.Member;
import youth.study.repository.MemberRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public void signUp(MemberRequestDto memberRequestDto) {
        Member member = Member.builder()
                .email(memberRequestDto.getEmail())
                .name(memberRequestDto.getName())
                .password(memberRequestDto.getPassword())
                .build();
        memberRepository.save(member);
    }

    public List<String> getMemberNames() {
        return memberRepository.findAll().stream()
                .map(Member::getName)
                .collect(Collectors.toList());
    }

    public MemberRequestDto getMemberInfo(Long memberId) {
        return memberRepository.findById(memberId)
                .map(member -> MemberRequestDto.builder()
                        .email(member.getEmail())
                        .name(member.getName())
                        .build())
                .orElseThrow(() -> new IllegalArgumentException("Member not found with id: " + memberId));
    }
}
