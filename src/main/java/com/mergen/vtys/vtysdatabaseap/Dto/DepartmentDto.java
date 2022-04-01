package com.mergen.vtys.vtysdatabaseap.Dto;

import com.mergen.vtys.vtysdatabaseap.Model.Title;
import lombok.Data;
import java.util.List;

@Data
public class DepartmentDto {

    private Long id;
    private String department_name;
    private Long branch_id;
    private List<Title> title;

}