package com.ahn.springboot.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString
@Entity
@Table(name="tb_wide_admin")
@EqualsAndHashCode(of="wide_admin_no")
public class WideAdmin {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long wide_admin_no;

    private String wide_admin_email;
    private String wide_admin_password;
    private String wide_admin_name;
    private String wide_admin_roleCode;
    private Date wide_admin_contractFinishDate;
    private String wide_admin_contractStatusCode;
}
