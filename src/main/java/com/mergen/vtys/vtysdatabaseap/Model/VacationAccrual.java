package com.mergen.vtys.vtysdatabaseap.Model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "vacation_accrual",schema = "public")
public class VacationAccrual {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",nullable = false,updatable = false)
    private Long id;
    @Column
    private String sicil_no ;
    @Column
    private String year;
    @Column
    private String permission_code;
    @Column
    private Long number_of_vacation_days;
    @Column
    private LocalDateTime accrual_date;

}

