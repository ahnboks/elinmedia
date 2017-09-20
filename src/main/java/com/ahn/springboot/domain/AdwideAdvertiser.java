package com.ahn.springboot.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@ToString
@Entity
@Table(name="tb_adwide_advertiser")
@EqualsAndHashCode(of="advertiser_no")
public class AdwideAdvertiser {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long advertiser_no;

    @Column(length = 320, nullable = false)
    @NotNull(message="필수 입력 사항 입니다.")
    private String advertiser_email;

    @Column(length = 40, nullable = false)
    @NotNull(message="필수 입력 사항 입니다.")
    private String advertiser_name;

    @Column(length = 10, nullable = false)
    @NotNull(message="필수 입력 사항 입니다.")
    private String advertiser_contract_statusCode;


    @NotNull(message="필수 입력 사항 입니다.")
    private Date advertiser_finish_date;

}
