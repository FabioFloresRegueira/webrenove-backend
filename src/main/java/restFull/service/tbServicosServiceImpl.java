package restFull.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import restFull.exception.ResourceNotFoundException;
import restFull.model.tbServicos;
import restFull.repository.tbServicosRepository;

@Service
public class tbServicosServiceImpl implements tbServicosService {

	
	//INJETAR O REPOSITORY tbServicosRepository NA CAMADA DE IMPLEMENTAÇÃO DO SERVIÇO. 
	@Autowired  
	private tbServicosRepository tbServicosRPO; 
	
	
	@Override
	public List<tbServicos> listaServicos() {
		List<tbServicos> listadeServicos = tbServicosRPO.findAll(); 
		return listadeServicos;
	}
	
	
	@Override
	public tbServicos buscaServicoId(Long Id) {
		Optional<tbServicos> opt = tbServicosRPO.findById(Id); 
		
		if (!opt.isPresent()) {
			throw new ResourceNotFoundException("Falha!, na localização de um registro com o id : " + Id + ". Registro Inexistente."); 
		}
		
		return opt.get();
	}

			
	@Override
	public tbServicos salvaServico(tbServicos Tabela) {
		return tbServicosRPO.save(Tabela);
	}

	@Override
	public void editaServico(tbServicos Tabela) {
		tbServicosRPO.save(Tabela); 
	}

	@Override
	public void deletaServicoId(Long Id) {
		tbServicos tabela = buscaServicoId(Id); 
		tbServicosRPO.delete(tabela);
	}
	
		
	@Override
	public tbServicos buscaServicoPorDescricao(String Descricao) {
		
		Optional<tbServicos> opt = tbServicosRPO.findByDescricao(Descricao); 

		if (!opt.isPresent()) {
			throw new ResourceNotFoundException("Falha!, não localizado o serviço com a descricao : "  + Descricao + ". Registro Inexistente."); 
		}
		
		return opt.get();
	}
	 
	
	/*
	@Override
	public void editaServicoDesc(String Descricao) {
		tbServicos tabela = buscaServicoDesc(Descricao); 
		tbServicosRPO.save(tabela); 
	}
	*/ 


	/*
	@Override
	public void deletaServicoDesc(String Descricao) {
		tbServicos tabela = buscaServicoDesc(Descricao); 
		tbServicosRPO.delete(tabela);
	}
	*/ 
	

}
