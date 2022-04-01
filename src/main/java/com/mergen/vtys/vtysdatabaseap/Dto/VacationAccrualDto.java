package com.mergen.vtys.vtysdatabaseap.Dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class VacationAccrualDto {

    private Long id;
    private String sicil_no ;
    private String year;
    private String permission_code;
    private Long number_of_vacation_days;
    private LocalDateTime accrual_date;

}
