package org.tpbc.tpbcapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tpbc.tpbcapi.entity.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
}
