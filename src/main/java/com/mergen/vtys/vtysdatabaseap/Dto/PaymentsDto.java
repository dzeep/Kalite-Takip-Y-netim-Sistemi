package com.mergen.vtys.vtysdatabaseap.Dto;

import lombok.Data;

@Data
public class PaymentsDto {

    private Long id;
    private String salary;
    private String currency;
    private String salary_type;
    private String payment_scheme;
    private String commute_support_fee;
    private String food_support_fee;
    private Long user_detail_id;
}