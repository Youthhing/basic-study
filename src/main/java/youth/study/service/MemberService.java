package youth.study.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import youth.study.dto.MemberDto;
import youth.study.entity.Member;
import youth.study.repository.MemberRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class MemberService {
    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Long join(MemberDto memberDto) {
        validateDuplicateMember(memberDto.getEmail());
        Member member = new Member();
        member.setEmail(memberDto.getEmail());
        member.setMemberName(memberDto.getMemberName());
        member.setPassword(memberDto.getPassword());
        memberRepository.save(member);
        return member.getId();
    }

    public List<String> getAllMemberNames() {
        List<Member> members = memberRepository.findAll();
        return members.stream()
                .map(Member::getMemberName)
                .collect(Collectors.toList());
    }

    public MemberDto getMemberInfo(String email) {
        Member member = memberRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다. email=" + email));
        return new MemberDto(member.getEmail(), member.getMemberName(), member.getPassword());
    }

    private void validateDuplicateMember(String email) {
        memberRepository.findByEmail(email)
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }
}
