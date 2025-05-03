package dev.java10x.cadastrodeninjas.Missoes;

import org.hibernate.boot.archive.internal.JarProtocolArchiveDescriptor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissoesRepository extends JpaRepository <MissoesModel, Long> {
}
