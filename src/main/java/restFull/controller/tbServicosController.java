package restFull.controller;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import restFull.model.tbServicos;
import restFull.service.tbServicosService;


@RestController 
@CrossOrigin(origins = "http://localhost:3000")
//@CrossOrigin(origins = "http://localhost:5173")

@RequestMapping("/rest/")
public class tbServicosController {

		// INJETANDO A INTERFACE  tbServicosService 
		@Autowired
		private tbServicosService servicos; 
		
		//--------------------------------------------------------------------//
		// METODO HTTP: (GET) - http://localhost:8080/rest/listaservicos
		// Lista todos os registros da tabela de servicos
		//--------------------------------------------------------------------//
		@GetMapping("/listaservicos")  
		public List<tbServicos> listatodos_Servicos(){
			return servicos.listaServicos(); // serviço em uso (tbServicosServiceImpl)
		}

		//--------------------------------------------------------------------//
		// METODO HTTP: (GET) - http://localhost:8080/rest/listaumservico/1
		// localiza e lista um registro da tabela
		//--------------------------------------------------------------------//
		@GetMapping("/listaumservico/{id}")
		public tbServicos localizaUm_servico(@PathVariable Long id) {
			return servicos.buscaServicoId(id);  // serviço em uso (tbServicosServiceImpl)
		}
		
		//--------------------------------------------------------------------//
		// METODO HTTP: (GET) - http://localhost:8080/rest/buscaservicopordescricao/descricao
		// localiza e lista um registro de acordo com a descricao informada
		//--------------------------------------------------------------------//
		@GetMapping("/buscaservicopordescricao/{Descricao}")
		public tbServicos findDescricao_Servico(@PathVariable String Descricao) {
			return servicos.buscaServicoPorDescricao(Descricao);  
		}
		
		
		
		//--------------------------------------------------------------------//
		// METODO HTTP: (POST) - http://localhost:8080/rest/adicionaservico
		// adiciona registros na tabela
		//--------------------------------------------------------------------//
		@PostMapping("/adicionaservico")
		public tbServicos gravaUm_servico(@RequestBody tbServicos tabela) {
			return servicos.salvaServico(tabela);  // serviço em uso (tbServicosServiceImpl)
		}
		
		
		//--------------------------------------------------------------------//
		// METODO HTTP: (PUT) - http://localhost:8080/rest/atualizaservico/2
		// atualiza dados dos registros na tabela
		//--------------------------------------------------------------------//
		@PutMapping("/atualizaservico/{id}")
		public ResponseEntity<tbServicos> atualizaUm_servico(@PathVariable Long id, @RequestBody tbServicos tabela){
			
			tbServicos dados = servicos.buscaServicoId(id);              // serviço em uso (tbServicosServiceImpl)
							
			dados.setDescricao(tabela.getDescricao()); 
			dados.setTipo(tabela.getTipo()); 
			dados.setDtinirenovacao(tabela.getDtinirenovacao()); 
			dados.setDtexpiracao(tabela.getDtexpiracao()); 
			dados.setInfo(tabela.getInfo()); 
			dados.setRisco(tabela.getRisco()); 
			dados.setStatus(tabela.getStatus()); 
			
			tbServicos updatetbServico = servicos.salvaServico(dados);    // serviço em uso (tbServicosServiceImpl)
			return ResponseEntity.ok(updatetbServico); 
			
		}

		//--------------------------------------------------------------------//
		// METODO HTTP: (PUT) - http://localhost:8080/rest//mudastatusservico/2
		// atualiza o campo status de um registro na tabela
		//--------------------------------------------------------------------//
		@PutMapping("/mudastatusservico/{id}")
		public ResponseEntity<tbServicos> mudaStatusdeUm_servico(@PathVariable Long id, @RequestBody tbServicos tabela){
			
			tbServicos dados = servicos.buscaServicoId(id);              // serviço em uso (tbServicosServiceImpl)
							
			dados.setStatus(tabela.getStatus()); 
			
			tbServicos updatetbServico = servicos.salvaServico(dados);    // serviço em uso (tbServicosServiceImpl)
			return ResponseEntity.ok(updatetbServico); 
			
		}

		
		//--------------------------------------------------------------------//
		// METODO HTTP: (DELETE) - http://localhost:8080/rest/deletaservico/2
		// Deleta um registros na tabela 
		//--------------------------------------------------------------------//
		@DeleteMapping("/deletaservico/{id}")
		public ResponseEntity<Map<String, Boolean>> deletaUm_servico(@PathVariable Long id){
			
			servicos.deletaServicoId(id);   // serviço em uso (tbServicosServiceImpl)
			
			Map<String, Boolean> response = new HashMap<>(); 
			response.put("deleted", Boolean.TRUE); 
			return ResponseEntity.ok(response); 
		}
		
		
	
}
