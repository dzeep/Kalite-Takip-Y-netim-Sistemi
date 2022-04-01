package com.mergen.vtys.vtysdatabaseap.Service.Impl;

import com.mergen.vtys.vtysdatabaseap.Dto.DepartmentDto;
import com.mergen.vtys.vtysdatabaseap.Model.Department;
import com.mergen.vtys.vtysdatabaseap.Repository.DepartmentRepository;
import com.mergen.vtys.vtysdatabaseap.Service.DepartmentService;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Data
public class DepartmentServiceImpl implements DepartmentService {

    private  final DepartmentRepository departmentRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<DepartmentDto> getDepartmentList(){
        List<Department> departmentList = (List<Department>) departmentRepository.findAll();
        return departmentList.stream().map(department -> modelMapper.map(department, DepartmentDto.class)).collect(Collectors.toList());
    }
    
    @Override
    public List<DepartmentDto> getDepartmentsByBranchId(@Param("branch_id") Long branch_id){
        List<Department> departmentList = departmentRepository.getBranchId(branch_id);
        return departmentList.stream().map(department -> modelMapper.map(department,DepartmentDto.class)).collect(Collectors.toList());
    }

    @Override
    public DepartmentDto getDepartmentByID(Long id) {
        Optional<Department> department = departmentRepository.findById(id);
        if (department.isPresent())
            return modelMapper.map(department.get(),DepartmentDto.class);
        throw new IllegalArgumentException("ID:" + id + " Fail" + " And Get User by ID Fail!");
    }

    @Override
    public DepartmentDto Create(DepartmentDto model) {
        Department department = modelMapper.map(model,Department.class);
        Optional<Department> _department = departmentRepository.findById(model.getId());
        if(_department.isEmpty())
            return modelMapper.map(departmentRepository.save(department),DepartmentDto.class);
        throw new IllegalArgumentException(model + " Create Option Fail!");
    }

    @Override
    public String  Update(Long id, DepartmentDto model) {
        Department department = modelMapper.map(model,Department.class);
        Optional<Department> _department = departmentRepository.findById(id);
        if(_department.isPresent()){
            if(id.equals(model.getId())) {
                departmentRepository.save(department);
                return department.getDepartment_name() + " Updated!";}}
        throw new IllegalArgumentException(model + " Update Option Fail!");
    }

    @Override
    public String Delete(Long id) {
        Optional<Department> department = departmentRepository.findById(id);
        if(department.isPresent()){
            departmentRepository.deleteById(id);
            return id.toString();}
        else throw new IllegalArgumentException(" Delete Option Fail!");
    }

}




    