package ypjs.project.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "refresh_entity")
@Getter
@Setter
public class RefreshEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "refresh_entity_id")
    private Long id;

    // 토큰이 어떤 유저의 토큰인지
    @Column(name = "refresh_entity_username")
    private String username;

    // 유저가 들고있는 토큰 및 만료시간
    @Column(name = "refresh_entity_refresh")
    private String refresh;

    @Column(name = "refresh_entity_expiration")
    private String expiration;

}