package restFull.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import restFull.model.tbServicos;

@Repository 
public interface tbServicosRepository extends JpaRepository<tbServicos, Long> {

	// METODO DE BUSCA POR DESCRICAO DO SERVIÇOS.  
	Optional<tbServicos> findByDescricao(String descricao);
	
	/* ERRO:
		org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'tbServicosRepository' 
		defined in restFull.repository.tbServicosRepository defined in @EnableJpaRepositories declared 
		on JpaRepositoriesRegistrar.EnableJpaRepositoriesConfiguration: Could not create query for public abstract 
		java.util.Optional restFull.repository.tbServicosRepository.findByDescricao(java.lang.String); 
		Reason: Failed to create query for method public abstract java.util.Optional 
		restFull.repository.tbServicosRepository.findByDescricao(java.lang.String); 
		Unable to locate Attribute with the given name [descricao] on this ManagedType [restFull.model.tbServicos]
	
	**** o ERRO ocorreu porque as variaveis la no construtor da classe tbServicos estavam sem a palavra "this." ***
	*/
	
	
	
}
