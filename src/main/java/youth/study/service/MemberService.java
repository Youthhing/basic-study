package youth.study.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import youth.study.dto.MemberDto;
import youth.study.entity.Member;
import youth.study.repository.MemberRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public void signUp(MemberDto memberDto) {
        Member member = new Member();
        member.setEmail(memberDto.getEmail());
        member.setName(memberDto.getName());
        member.setPassword(memberDto.getPassword());
        memberRepository.save(member);
    }

    public List<String> getMemberNames() {
        return memberRepository.findAll().stream()
                .map(Member::getName)
                .collect(Collectors.toList());
    }

    public MemberDto getMemberInfo(Long memberId) {
        Optional<Member> optionalMember = memberRepository.findById(memberId);
        if (optionalMember.isPresent()) {
            Member member = optionalMember.get();
            MemberDto memberDto = new MemberDto();
            memberDto.setEmail(member.getEmail());
            memberDto.setName(member.getName());
            return memberDto;
        }
        return null;
    }
}
