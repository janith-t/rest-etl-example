package lk.janith.restetlexample.repository;

import lk.janith.restetlexample.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<PersonEntity,String> {
}
