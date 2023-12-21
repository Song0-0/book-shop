package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository //@ComponentScan의 대상이 되어서 스프링 빈으로 등록이 된다.
@RequiredArgsConstructor
public class MemberRepository {
    //    @PersistenceContext //스프링에 의해서 엔티티 매니저를 주입받는다.
    private final EntityManager em;

    public void save(Member member) {
        em.persist(member);
    }

    public Member findOne(Long id) {
        return em.find(Member.class, id);
    }

    public List<Member> findAll() { //JPQL사용. from의 대상이 테이블이 아니라 엔티티라고 보면 된다.
        return em.createQuery("select m from Member m", Member.class).getResultList();
    }

    public List<Member> findByName(String name) {
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }
}
