package com.mergen.vtys.vtysdatabaseap.Model;

import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name ="department",schema = "public")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Column
    private String department_name;

    @Column
    private Long branch_id;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "department_id",cascade = CascadeType.ALL)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Title> title=new ArrayList<>();

}

    