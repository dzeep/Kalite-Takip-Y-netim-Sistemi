package com.mergen.vtys.vtysdatabaseap.Dto;

import lombok.Data;

@Data
public class VacationRequestDto {

    private Long id;
    private String sicil_no ;
    private String start_date;
    private String work_start_date;
    private String vacation_request_status;
    private String vacation_type;
    private int permission_save_id;
    private String recognizant;
    private int working_day_number;
    private Long user_detail_id;

}
