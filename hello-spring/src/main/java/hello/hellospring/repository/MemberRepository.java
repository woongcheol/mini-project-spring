package hello.hellospring.repository;

import java.util.Optional;
import java.util.List;
import hello.hellospring.domain.Member;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
