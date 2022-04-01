package com.mergen.vtys.vtysdatabaseap.Dto;

import com.mergen.vtys.vtysdatabaseap.Model.Branch;
import lombok.Data;
import java.util.List;

@Data
public class CompanyDto {

    private Long id;
    private String company_name;
    private String company_phone;
    private String domain_name;
    private String mersis_no;
    private String sgk_company_no;
    private Long company_id_from_career;
    private List<Branch> branch;

}