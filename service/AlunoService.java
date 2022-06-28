package br.com.empresa.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.empresa.entity.Aluno;
import br.com.empresa.repository.AlunoRepository;

@Service
public class AlunoService {
	
	@Autowired
	private AlunoRepository alunorepo;

	public List<Aluno> listaTodosAlunos(){	
		return alunorepo.findAll();
	}
	
	public Aluno buscaPorID(Integer id) throws ObjectNotFoundException{
		Optional<Aluno> aluno = alunorepo.findById(id);
		return aluno.orElseThrow(() -> new ObjectNotFoundException(null, "Objeto não encontrado"));
	}
	public Aluno salvar(Aluno aluno) {
		return alunorepo.save(aluno);
	}
	public void excluir(Integer id) {
		alunorepo.deleteById(id);
	}
	public Aluno alterar(Aluno objAluno) {
		Aluno aluno = buscaPorID(objAluno.getId());
		aluno.setNome(objAluno.getNome());
		return salvar(aluno);
	}
}
