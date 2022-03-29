package com.mergen.vtys.vtysdatabaseap.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "payments",schema = "public")
@Data
public class Payments {
    @Id
    @SequenceGenerator(name="identifier", sequenceName="mytable_id_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="identifier")
    @Column(name ="id",nullable = false,updatable = false)
    private Long id;

    @Column
    private String salary;

    @Column
    private String currency;

    @Column
    private String salary_type;

    @Column
    private String payment_scheme;

    @Column
    private String commute_support_fee;

    @Column
    private String food_support_fee;

    @Column
    private Long user_detail_id;



}

    