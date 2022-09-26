package com.netlink.servers.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Passport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String number;

    // constraint fk_pass_emp_id forigen key (emp_id) referneces eidmplyee();

    @OneToOne(cascade = CascadeType.ALL) // Uni-Dir
    @JoinColumn(name = "emp_id",referencedColumnName = "id")
    @JsonBackReference
    private Employee employee;

}
