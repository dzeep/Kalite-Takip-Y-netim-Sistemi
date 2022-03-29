package com.mergen.vtys.vtysdatabaseap.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="branch", schema="public")
@Data
public class Branch {
    @Id
    @SequenceGenerator(name="identifier", sequenceName="mytable_id_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="identifier")
    @Column(name = "id",nullable = false,updatable = false)
    private Long id;

    @Column
    private String branch_name;

    @Column
    private String branch_upper;

    @Column
    private String rules;

    @Column
    private String vacation_dates;

    @Column
    private Long company_id;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "branch_id",cascade = CascadeType.ALL)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Department> department=new ArrayList<>();

}

    