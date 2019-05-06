package org.tpbc.tpbcapi.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tpbc.tpbcapi.entity.Attendance;
import org.tpbc.tpbcapi.entity.Member;
import org.tpbc.tpbcapi.repository.MemberRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    private MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> getMember(long id) {
        return memberRepository.findById(id);
    }

    @Transactional
    public List<Attendance> getMemberAttendance(long id) {
        return memberRepository.findById(id)
                .map(Member::getAttendance)
                .orElseGet(ArrayList::new);
    }

    public void addMember(Member member) {
        memberRepository.save(member);
    }
}
