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
@Table(name="tb_partner")
@EqualsAndHashCode(of="partner_no")
public class Partner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long partner_no;

    private String partner_email;
    private String partner_name;
    private String partner_contract_statusCode;
    private Date partner_finish_date;
}