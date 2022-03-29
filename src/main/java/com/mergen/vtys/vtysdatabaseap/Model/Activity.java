package com.mergen.vtys.vtysdatabaseap.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name= "activity", schema="public")
@Data
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_one_generator")
    @SequenceGenerator(name = "sequence_one_generator", sequenceName = "sequence_one_id", allocationSize = 1)
            private Long id;

    @Column
    private String name;

    @Column
    private String place;

    @Column
    private String datetime;

    @Column
    private String organizator;

//    public List<ActiveToUser> getActiveToUsers() {
//        return activeToUsers;
//    }
//    public void setActiveToUsers(List<ActiveToUser> activeToUsers) {
//        this.activeToUsers = activeToUsers;
//    }


    @OneToMany(fetch = FetchType.EAGER,mappedBy = "activity_ids",cascade = CascadeType.ALL)
    @Fetch(value = FetchMode.SUBSELECT)
 //   @JsonManagedReference(value = "activity_json")
    private List<ActiveToUser> activity_enrolled=new ArrayList<>();



//
//    @JoinTable
//    @OneToMany(fetch = FetchType.EAGER)
//    private List<User> users=new ArrayList<>();

}
