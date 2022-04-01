package com.mergen.vtys.vtysdatabaseap.Model;

import lombok.Data;

import javax.persistence.*;
@Entity
@Data
@Table(name = "usercareer",schema ="public")
public class UserCareer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Column
    private Long company_id;

    @Column
    private Long career_id;



}

    