package restFull.service;

import java.util.List;


import restFull.model.tbServicos;


public interface tbServicosService {

	/* 
	 IMPLEMENTAÇÃO DO PACOTE DE SERVIÇOS (tbServicosService):  clicar com o botão direito do mouse e escolher a opção 
	 NEW >> CLASS, informe um nome para a classe ex: (tabServicosServiceImpl) na opção INTERFACE botão ADD, selecionar
	 a classe tbServicosService para implementa-la e clicar no botão FINISHI.
	 PRONTO !, AUTOMATICAMENTE OS METODOS SERÃO IMPLEMENTADOS. 
	 */
	
	public List<tbServicos> listaServicos(); 
	public tbServicos buscaServicoId(Long Id); 
	public tbServicos salvaServico(tbServicos Tabela); 
	public void editaServico(tbServicos Tabela);
	public void deletaServicoId(Long Id); 

	public tbServicos buscaServicoPorDescricao(String Descricao); 

	
	//public void editaServicoId(Long Id); 
	//public void editaServicoDesc(String Descricao);
	//public void deletaServicoDesc(String Descricao); 

	
}
