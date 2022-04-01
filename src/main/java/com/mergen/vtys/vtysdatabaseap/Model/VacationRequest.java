package com.mergen.vtys.vtysdatabaseap.Model;

import lombok.Data;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.persistence.*;
import java.util.Optional;

@Data
@Entity
@Table(name = "vacation_request",schema = "public")
public class VacationRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",nullable = false,updatable = false)
    private Long id;
    @Column
    private String sicil_no ;
    @Column
    private String start_date;
    @Column
    private String work_start_date;
    @Column(columnDefinition = "varchar(50) default 'Pending for Approval'")
    private String vacation_request_status;
    @Column
    private String vacation_type;
    @Column
    private int permission_save_id;
    @Column
    private String recognizant;
    @Column
    private int working_day_number;
    @Column
    private Long user_detail_id;

//    @PreAuthorize("hasRole('ROLE_ADMIN')")
//    public void setVacation_request_status(String vacation_request_status) {
//        this.vacation_request_status = vacation_request_status;
//    }
//
//    public void setIsAuthorizedForClasifiedData(String vacation_request_status) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        Optional<? extends GrantedAuthority> role_admin = authentication.getAuthorities().stream().filter(role -> role.getAuthority().equals("ROLE_ADMIN")).findAny();
//        role_admin.orElseThrow(() -> new IllegalStateException("LIAR"));
//       this.vacation_request_status =vacation_request_status;
//    }
}

    