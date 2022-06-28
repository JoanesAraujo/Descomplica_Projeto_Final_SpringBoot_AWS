package br.com.empresa.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.empresa.entity.Turma;
import br.com.empresa.repository.TurmaRepository;

@Service
public class TurmaService {
	@Autowired
	TurmaRepository Turmarepo;
	
	public List<Turma> listarTodasTurmas(){
		return Turmarepo.findAll();
	}
	
	public Turma salvaTurma(Turma turma) {
		return Turmarepo.save(turma);
	}
	public Turma buscaPorID(Integer id) throws ObjectNotFoundException{
		// TODO Auto-generated method stub
		Optional<Turma> turma = Turmarepo.findById(id);
		return turma.orElseThrow(() -> new ObjectNotFoundException(null, "Objeto não encontrado"));
	}
	public void excluirTurma(Integer Id) {
		Turmarepo.deleteById(Id);
		
	}
	public Turma alterar(Turma objTurma) {
		Turma turma = buscaPorID(objTurma.getId());
		turma.setNome(objTurma.getNome());
		return salvaTurma(turma);
	}
}
