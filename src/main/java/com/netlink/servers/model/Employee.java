package com.netlink.servers.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "employee_tbl")
@Data // sett gett tostring hascode equal @Setter @Getter @ToString
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    private String password;

    @Column(name = " department")
    private String dept;

    @Column(name = "dob")
    private LocalDateTime dateOfBirth;

    @Column(name = "is_active")
    private Boolean status;

    private String gender;

    private Integer salary;

    private String designation;

    private LocalDateTime createdBy;

    @OneToOne(mappedBy = "employee") // Bi-Dir
    private Passport passport;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dept_id", referencedColumnName = "id")
    @JsonBackReference
    private Department department;

  /*  @ManyToMany
    @JoinTable(name = "employee_role",
            joinColumns = @JoinColumn(name = "emp_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id",referencedColumnName = "id")
    )
    @JsonIgnoreProperties(value = "employeeList")
    private List<Role> roleList;*/


    @OneToMany(mappedBy = "employee")
    private List<EmployeeRole> employeeRoleList;

}
