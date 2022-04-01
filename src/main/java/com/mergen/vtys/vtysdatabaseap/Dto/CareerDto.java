package com.mergen.vtys.vtysdatabaseap.Dto;

import com.mergen.vtys.vtysdatabaseap.Model.Company;
import lombok.Data;
import java.util.List;

@Data
public class CareerDto {

    private Long id;
    private String admin_tc_no;
    private String admin_name;
    private String unit_company;
    private String unit_branch;
    private String unit_department;
    private String unit_title;
    private Long user_detail_id;
    private List<Company> companies;

}