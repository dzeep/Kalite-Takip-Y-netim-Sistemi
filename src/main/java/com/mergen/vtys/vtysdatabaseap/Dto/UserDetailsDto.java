package com.mergen.vtys.vtysdatabaseap.Dto;


import lombok.Data;

@Data
public class UserDetailsDto {
    private String bank_account_number;
    private String iban;
    private String emergency_contact;
    private String relationship_emergency_contact;
}

