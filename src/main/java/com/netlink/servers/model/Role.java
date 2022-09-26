package com.netlink.servers.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    private String description;

    private Boolean status;

   /* @ManyToMany(mappedBy = "roleList")
    @JsonIgnoreProperties(value = "roleList")
    private List<Employee> employeeList;
    */
    @OneToMany(mappedBy = "role")
    private List<EmployeeRole> employeeRoleList;



}
