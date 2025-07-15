package dev.java10x.cadastrodeninjas.Ninjas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface NinjaRepository extends JpaRepository<NinjaModel,Long> {

}
