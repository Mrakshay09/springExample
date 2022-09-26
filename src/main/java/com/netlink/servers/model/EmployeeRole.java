package com.netlink.servers.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "emp_role_tbl")
public class EmployeeRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    // emp_id
    @ManyToOne
    @JoinColumn(name = "emp_id",referencedColumnName = "id")
    private Employee employee;

    // role_id
    @ManyToOne
    @JoinColumn(name = "role_id",referencedColumnName = "id")
    private Role role;


}
