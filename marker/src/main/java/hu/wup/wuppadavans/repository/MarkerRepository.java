package hu.wup.wuppadavans.repository;

import hu.wup.wuppadavans.entity.MarkerEntity;
import hu.wup.wuppadavans.model.Marker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MarkerRepository extends JpaRepository<Marker, Long> {


}
