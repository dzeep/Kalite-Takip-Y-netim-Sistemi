package com.mergen.vtys.vtysdatabaseap.Model;

import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.nio.charset.CoderMalfunctionError;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="career", schema = "public")
@Data
public class Career {

        @Id
        @SequenceGenerator(name = "identifier", sequenceName = "mytable_id_seq", allocationSize = 1)
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "identifier")
        @Column(name = "id", nullable = false, updatable = false)
        private Long id;

        @Column
        private String admin_tc_no;

        @Column
        private String admin_name;

        @Column
        private String unit_company;

        @Column
        private String unit_branch;

        @Column
        private String unit_department;

        @Column
        private String unit_title;

        @Column
        private Long user_detail_id;

       /* @OneToMany(fetch = FetchType.EAGER,mappedBy = "company_id_from_career")
        @Fetch(value = FetchMode.SUBSELECT)
        @JoinTable(name = "easy")
        private List<Company> companies=new ArrayList<>();
*/
       @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
       @JoinTable(name ="usercareer", joinColumns = @JoinColumn(name = "company_id", referencedColumnName = "id"),
               inverseJoinColumns = @JoinColumn(name = "career_id", referencedColumnName = "id"))
       private List<Company> companies = new ArrayList<>();
}
