package com.ahn.springboot.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name="tb_wide_role")
@EqualsAndHashCode(of="wide_role_code")
public class WideAdminRole {
    @Id
    private String wide_role_code;

    private String wide_role_name;
}
