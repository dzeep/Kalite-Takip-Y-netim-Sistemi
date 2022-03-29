package com.mergen.vtys.vtysdatabaseap.Model;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "title",schema = "public")
public class Title {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Column
    private String title_name;

    @Column
    private Long department_id;
}

    