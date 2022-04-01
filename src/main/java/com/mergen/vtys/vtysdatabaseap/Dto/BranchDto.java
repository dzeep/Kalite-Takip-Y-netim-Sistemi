package com.mergen.vtys.vtysdatabaseap.Dto;

import com.mergen.vtys.vtysdatabaseap.Model.Department;
import lombok.Data;
import java.util.List;

@Data
public class BranchDto {

    private Long id;
    private String branch_name;
    private String branch_upper;
    private String rules;
    private String vacation_dates;
    private Long company_id;
    private List<Department> department;

}