package youth.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import youth.study.dto.MemberDto;
import youth.study.service.MemberService;

import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping("/sign-up")
    public void signUp(@RequestBody MemberDto memberDto) {
        memberService.signUp(memberDto);
    }

    @GetMapping("/names")
    public List<String> getMemberNames() {
        return memberService.getMemberNames();
    }

    @GetMapping("/{id}")
    public MemberDto getMemberInfo(@PathVariable Long id) {
        return memberService.getMemberInfo(id);
    }
}
