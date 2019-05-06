package org.tpbc.tpbcapi.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@NoArgsConstructor
@Data
@Entity
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private Date date;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

}
