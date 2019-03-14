package br.com.softblue.loucademia.interfaces.aluno.web;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.softblue.loucademia.application.service.AlunoService;
import br.com.softblue.loucademia.application.util.StringUtils;
import br.com.softblue.loucademia.domain.aluno.Aluno;

@Named
@RequestScoped
public class AlunoBean implements Serializable {

	@EJB
	private AlunoService alunoService;
	
	@Inject
	private FacesContext facesContext;
	
	private Aluno aluno = new Aluno();
	
	private String matricula;
	
	private String titulo = "Novo aluno";
	
	public void carregar() {
		if (!StringUtils.isEmpty(matricula)) {
			aluno = alunoService.findByMatricula(matricula);
			titulo = "Alterar aluno";
		}
	}
	
	public String gravar() {
		alunoService.createOrUpdate(aluno);
		facesContext.addMessage(null, new FacesMessage("Dados gravados com sucesso"));
		return null;
	}
	
	public Aluno getAluno() {
		return aluno;
	}
	
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	
	public String getMatricula() {
		return matricula;
	}
	
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	public String getTitulo() {
		return titulo;
	}
}
