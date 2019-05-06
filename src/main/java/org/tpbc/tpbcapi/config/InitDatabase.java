package org.tpbc.tpbcapi.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.tpbc.tpbcapi.entity.Attendance;
import org.tpbc.tpbcapi.entity.Member;
import org.tpbc.tpbcapi.repository.AttendanceRepository;
import org.tpbc.tpbcapi.repository.MemberRepository;

import java.time.OffsetDateTime;

@Profile("dev")
@Configuration
public class InitDatabase implements CommandLineRunner {

    private MemberRepository memberRepository;
    private AttendanceRepository attendanceRepository;

    public InitDatabase(MemberRepository memberRepository, AttendanceRepository attendanceRepository) {
        this.memberRepository = memberRepository;
        this.attendanceRepository = attendanceRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Member m1 = new Member();
        m1.setName("Tess Ting");
        memberRepository.save(m1);
        Member m2 = new Member();
        m2.setName("Sam Perl");
        memberRepository.save(m2);

        attendanceRepository.save(new Attendance(m1, OffsetDateTime.now()));
        attendanceRepository.save(new Attendance(m1, OffsetDateTime.now().plusDays(1)));
        attendanceRepository.save(new Attendance(m2, OffsetDateTime.now()));
        attendanceRepository.save(new Attendance(m2, OffsetDateTime.now().plusDays(1)));
    }
}
