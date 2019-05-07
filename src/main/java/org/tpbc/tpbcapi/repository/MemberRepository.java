package org.tpbc.tpbcapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.tpbc.tpbcapi.entity.Member;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    @Query(
            value = "SELECT * FROM member WHERE ID NOT IN " +
                    "(SELECT MEMBER_ID FROM attendance WHERE (DATE >= ?1 AND DATE < ?2))",
            nativeQuery = true
    )
    List<Member> findAllMembersNotPresentBetween(LocalDate lower, LocalDate upper);
}
