package br.com.softblue.loucademia.interfaces.relatorio.web;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.RequestParameterMap;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.softblue.loucademia.application.service.AlunoService;
import br.com.softblue.loucademia.domain.aluno.Aluno;
import br.com.softblue.loucademia.domain.aluno.Aluno.Situacao;

@Named
@SessionScoped
public class RelatorioSituacoesBean implements Serializable {

	@EJB
	private AlunoService alunoService;
	
	@Inject
	@RequestParameterMap
	private Map<String, String> requestParamsMap;
	
	private Situacao situacao;
	
	private List<Aluno> alunos;
	
	public void check() {
		String clear = requestParamsMap.get("clear");
		
		if (clear != null && Boolean.valueOf(clear)) {
			situacao = null;
			alunos = null;
		}
	}
	
	public String gerarRelatorio() {
		alunos = alunoService.listSituacoesAlunos(situacao);
		return null;
	}

	public Situacao getSituacao() {
		return situacao;
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
}
