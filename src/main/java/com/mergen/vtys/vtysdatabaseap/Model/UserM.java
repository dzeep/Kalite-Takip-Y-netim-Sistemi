package com.mergen.vtys.vtysdatabaseap.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user_m",schema ="public")
@Data
public class UserM {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",nullable = false,updatable = false)
    private Long id;

    @Column
    private String username;
    @Email
    @Column
    private String email;
    @Column
    private String title;
    @Column
    private String cellphone;
    //@JsonIgnore
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "user_ids")
    @Fetch(value = FetchMode.SUBSELECT)
    //@JsonManagedReference(value = "user_json_managed")
    private List<ActiveToUser> activeToUsers=new ArrayList<>();


    @OneToMany(fetch = FetchType.EAGER,mappedBy = "user_id")
    @Fetch(value = FetchMode.SUBSELECT)
    //@JsonManagedReference(value = "user_json_managed")
    private List<UserDetails> userDetails=new ArrayList<>();

}

    