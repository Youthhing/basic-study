package youth.study.controller;

import org.springframework.web.bind.annotation.*;
import youth.study.dto.MemberRequestDto;
import youth.study.dto.MemberResponseDto;
import youth.study.service.MemberService;

import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/sign-up")
    public void signUp(@RequestBody MemberRequestDto memberRequestDto) {
        memberService.signUp(memberRequestDto);
    }

    @GetMapping("/names")
    public List<String> getMemberNames() {
        return memberService.getMemberNames();
    }

    @GetMapping("/{id}")
    public MemberResponseDto getMemberInfo(@PathVariable Long id) {
        return memberService.getMemberInfo(id);
    }
}
