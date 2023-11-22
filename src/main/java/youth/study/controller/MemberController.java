package youth.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import youth.study.dto.MemberDto;
import youth.study.service.MemberService;

import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/join")
    public ResponseEntity<Long> join(@RequestBody MemberDto memberDto) {
        Long memberId = memberService.join(memberDto);
        return new ResponseEntity<>(memberId, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<String>> getAllMembers() {
        List<String> allMembers = memberService.getAllMemberNames();
        return new ResponseEntity<>(allMembers, HttpStatus.OK);
    }

    @GetMapping("/{email}")
    public ResponseEntity<MemberDto> getMemberInfo(@PathVariable String email) {
        MemberDto memberInfo = memberService.getMemberInfo(email);
        return new ResponseEntity<>(memberInfo, HttpStatus.OK);
    }
}
