package dev.java10x.cadastrodeninjas.Missoes;

import org.hibernate.boot.archive.internal.JarProtocolArchiveDescriptor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MissoesRepository extends JpaRepository <MissoesModel, Long> {
}
