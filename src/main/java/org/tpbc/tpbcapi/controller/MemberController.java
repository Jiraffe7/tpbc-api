package org.tpbc.tpbcapi.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.tpbc.tpbcapi.entity.Member;
import org.tpbc.tpbcapi.service.MemberService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class MemberController {

    private MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List getMembers() {
        return memberService.getAllMembers();
    }

    @PostMapping
    public void addMember(@RequestBody Member member) {
        memberService.addMember(member);
    }

    @GetMapping("/{id}")
    public ResponseEntity getMember(@PathVariable("id") long id) {
        return memberService.getMember(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.noContent().build());
    }

    @GetMapping("/{id}/attendance")
    public List getMemberAttendance(@PathVariable("id") long id) {
        return memberService.getMemberAttendance(id);
    }
}
