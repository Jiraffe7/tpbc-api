package org.tpbc.tpbcapi.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.OffsetDateTime;

@NoArgsConstructor
@Data
@Entity
public class Attendance {

    public Attendance(Member member, OffsetDateTime date) {
        this.date = date;
        this.member = member;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private OffsetDateTime date;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

}
