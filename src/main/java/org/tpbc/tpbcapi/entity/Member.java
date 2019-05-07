package org.tpbc.tpbcapi.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Data
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member-sequence")
    @SequenceGenerator(name = "member-sequence", sequenceName = "member_sequence")
    @ColumnDefault("nextval(member_sequence)")
    private long id;

    private String name;

    @JsonManagedReference
    @OneToMany(
            mappedBy = "member",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Attendance> attendance = new ArrayList<>();
}
