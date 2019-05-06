package org.tpbc.tpbcapi.service;

import org.springframework.stereotype.Service;
import org.tpbc.tpbcapi.entity.Attendance;
import org.tpbc.tpbcapi.entity.Member;
import org.tpbc.tpbcapi.repository.AttendanceRepository;
import org.tpbc.tpbcapi.repository.MemberRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    private MemberRepository memberRepository;
    private AttendanceRepository attendanceRepository;

    public MemberService(
            MemberRepository memberRepository,
            AttendanceRepository attendanceRepository
    ) {
        this.memberRepository = memberRepository;
        this.attendanceRepository = attendanceRepository;
    }

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> getMember(long id) {
        return memberRepository.findById(id);
    }

    public List<Attendance> getMemberAttendance(long id) {
        return memberRepository.findById(id)
                .map(Member::getAttendance)
                .orElseGet(ArrayList::new);
    }

    public void addMember(Member member) {
        memberRepository.save(member);
    }

    public List<Attendance> getMemberAttendanceBetween(long id, LocalDate lower, LocalDate upper) {
        return attendanceRepository.findAllByMemberBetweenDate(id, lower, upper);
    }
}
