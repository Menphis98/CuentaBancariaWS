package cuentabancariaws;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "cuenta", path = "cuenta")
public interface CuentaRepository extends PagingAndSortingRepository<Cuenta, Long> {

    List<Cuenta> findByTitular(@Param("titular") String titular);

}

