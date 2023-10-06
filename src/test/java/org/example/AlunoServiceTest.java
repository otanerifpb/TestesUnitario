package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AlunoServiceTest {

    @InjectMocks
    private AlunoService alunoService;

    @Mock
    private AlunoDAO alunoDAO;

    @Test
    public void naoDeveriaInserirAlunoComMesmaMatricula() {
        Aluno aluno1 = new Aluno(1, "Renato", 35, "12345678901", "45612378996");

        Mockito.doReturn(true).when(alunoDAO).existeMatriculaAtiva("12345678901");
        Assertions.assertThrows(IllegalArgumentException.class, () -> alunoService.inserirAluno(aluno1));
    }

    @Test
    public void naoDeveriaInserirAlunoComMesmaCPF() {
        Aluno aluno1 = new Aluno(1, "Renato", 35, "12345678901", "45612378996");

        Mockito.doReturn(true).when(alunoDAO).existeAlunoComCPF("45612378996");
        Assertions.assertThrows(IllegalArgumentException.class, () -> alunoService.inserirAluno(aluno1));
    }

    @Test
    public void naoDeveriaInserirAlunoMenorIdade() {
        Aluno aluno1 = new Aluno(1, "Renato", 17, "12345678901", "45612378996");

        Assertions.assertThrows(IllegalArgumentException.class, () -> alunoService.inserirAluno(aluno1));
    }
}
