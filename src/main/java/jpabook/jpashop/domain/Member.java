package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Member {
    @Id
    @GeneratedValue
    @Column(name="member_id")
    private Long id;
    private String name;
    @Embedded
    private Address address;
    @OneToMany(mappedBy = "member") //order 테이블에 있는 member 필드에 의해서 매핑이 된 것. 읽기 전용이 되는 것이다.
    private List<Order> orders = new ArrayList<>();

}
