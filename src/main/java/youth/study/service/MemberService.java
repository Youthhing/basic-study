package youth.study.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import youth.study.dto.MemberRequestDto;
import youth.study.dto.MemberResponseDto;
import youth.study.entity.Member;
import youth.study.exception.MemberNotFoundException;
import youth.study.repository.MemberRepository;

import java.util.List;
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

    public MemberResponseDto getMemberInfo(Long memberId) {
        return memberRepository.findById(memberId)
                .map(member -> MemberResponseDto.builder()
                        .email(member.getEmail())
                        .name(member.getName())
                        .build())
                .orElseThrow(() -> new MemberNotFoundException("Member not found with id: " + memberId));
    }
}
