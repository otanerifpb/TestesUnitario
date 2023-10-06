package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AlunoTest {
    private Aluno aluno1;

    @BeforeEach
    public void config(){
        aluno1 = new Aluno(1, "Renato", 35, "12345678912", "78912345689");
    }

    @Test
    public void naoDeveriaCriarMatriculaDiferente11Digitos() {
        // Configuração
        // Execuçao
        // Testes
        Assertions.assertThrows(RuntimeException.class, () -> aluno1.setMatricula("123456127890"));
    }

    @Test
    public void naoDeveriaCriarMatriculaComCaracterEspecial() {
        // Configuração
        // Execuçao
        // Testes
        Assertions.assertThrows(RuntimeException.class, () -> aluno1.setMatricula("1234jkg7890"));
    }

}
