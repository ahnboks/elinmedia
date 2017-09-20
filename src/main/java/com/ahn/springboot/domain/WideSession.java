package com.ahn.springboot.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name="tb_wide_session")
@EqualsAndHashCode(of="wide_session_id")
public class WideSession {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public String wide_session_id;

    @Column(length = 320, nullable = false)
    @NotNull(message="필수 입력 사항 입니다.")
    public String admin_email;

    @Column(length = 20, nullable = false)
    @NotNull(message="필수 입력 사항 입니다.")
    public String wide_admin_name;

    @Column(length = 20, nullable = false)
    @NotNull(message="필수 입력 사항 입니다.")
    public String wide_admin_role;

    @Column(length = 10, nullable = false)
    @NotNull(message="필수 입력 사항 입니다.")
    public int wide_login_status;

    @CreationTimestamp
    @NotNull(message="필수 입력 사항 입니다.")
    public Timestamp wide_session_regDate;

    @UpdateTimestamp
    @NotNull(message="필수 입력 사항 입니다.")
    public Timestamp wide_session_updateDate;

}
