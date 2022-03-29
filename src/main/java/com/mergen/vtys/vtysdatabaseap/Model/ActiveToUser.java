package com.mergen.vtys.vtysdatabaseap.Model;
import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name= "activetouser", schema="public")
@Data
public class ActiveToUser {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_one_generator")
    @SequenceGenerator(name = "sequence_one_generator", sequenceName = "sequence_one_id", allocationSize = 1)
    private Long id;

    @Column(name = "user_ids")
    private Long user_ids;

    @Column(name = "activity_ids")
    private Long activity_ids;


//
//   // @JsonIgnore
//    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
//     @JsonBackReference(value = "activity_json")
//    Activity activity;
//    //@JsonIgnore
//    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
//    @JsonBackReference(value = "user_json_managed")
//    User user;

}





    