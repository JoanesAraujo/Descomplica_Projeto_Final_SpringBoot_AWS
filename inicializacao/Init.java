package br.com.empresa.inicializacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Arrays;

import br.com.empresa.entity.Aluno;
import br.com.empresa.entity.Turma;
import br.com.empresa.repository.AlunoRepository;
import br.com.empresa.repository.TurmaRepository;


@Component
public class Init implements ApplicationListener<ContextRefreshedEvent>{
	
	
	
	@Autowired
	AlunoRepository alunorepo;
	@Autowired
	TurmaRepository turmarepo;
	
	public void onApplicationEvent(ContextRefreshedEvent event) {
		Aluno aluno1 = new Aluno();
		aluno1.setNome("Joanes");
		
		Aluno aluno2 = new Aluno();
		aluno2.setNome("Alex");
		
		Aluno aluno3 = new Aluno();
		aluno3.setNome("Caligula");
		
		
		
		// Turmas:
		Turma Descomplica = new Turma();
		Descomplica.setNome("Descomplica");
		Turma Impulsotec = new Turma();
		Impulsotec.setNome("Impulsotec");
		Turma K2_Partening = new Turma();
		K2_Partening.setNome("K2_Partening");
		
		turmarepo.saveAll(Arrays.asList(Descomplica,Impulsotec,K2_Partening));
		aluno1.setTurma(Descomplica);
		aluno2.setTurma(Impulsotec);
		aluno3.setTurma(K2_Partening);
		
		alunorepo.saveAll(Arrays.asList(aluno1,aluno2,aluno3));

	}
	

}
