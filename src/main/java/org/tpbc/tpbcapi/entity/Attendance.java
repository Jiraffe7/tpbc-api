package org.tpbc.tpbcapi.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "attendance-sequence")
    @SequenceGenerator(name = "attendance-sequence", sequenceName = "attendance_sequence")
    private long id;

    private OffsetDateTime date;

    @ToString.Exclude
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

}
