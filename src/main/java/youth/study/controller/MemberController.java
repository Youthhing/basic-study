package youth.study.controller;

import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Void> signUp(@RequestBody MemberRequestDto memberRequestDto) {
        memberService.signUp(memberRequestDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/names")
    public ResponseEntity<List<String>> getMemberNames() {
        List<String> names = memberService.getMemberNames();
        return ResponseEntity.ok(names);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MemberResponseDto> getMemberInfo(@PathVariable Long id) {
        MemberResponseDto memberInfo = memberService.getMemberInfo(id);
        return ResponseEntity.ok(memberInfo);
    }
}
