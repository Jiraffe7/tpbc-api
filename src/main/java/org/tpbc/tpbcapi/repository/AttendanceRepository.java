package org.tpbc.tpbcapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.tpbc.tpbcapi.entity.Attendance;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

    @Query(
            value = "SELECT * FROM attendance WHERE MEMBER_ID = ?1 AND DATE >= ?2 AND DATE < ?3",
            nativeQuery = true
    )
    List<Attendance> findAllByMemberBetweenDate(long id, LocalDate lower, LocalDate upper);

}
