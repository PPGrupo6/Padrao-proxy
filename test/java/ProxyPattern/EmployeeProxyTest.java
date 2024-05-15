package ProxyPattern;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class EmployeeProxyTest {

    @BeforeEach
    void setUp() {
        BD.addEmployee(new Employee(1, "Gabriel", "Juiz de Fora", 8.0f));
        BD.addEmployee(new Employee(2, "Bruno", "Rio de Janeiro", 10.0f));
    }

    @Test
    void shouldReturnEmployeePersonalData() {
        EmployeeProxy aluno = new EmployeeProxy(1);
        assertEquals(Arrays.asList("Gabriel", "Juiz de Fora"), aluno.getPersonalData());
    }

    @Test
    void deveRetonarNotasAluno() {
        Boss boss = new Boss("Robertinho", true);
        EmployeeProxy aluno = new EmployeeProxy(2);

        assertEquals(Arrays.asList(10.0f), aluno.getSalary(boss));
    }

    @Test
    void deveRetonarExcecaoUsuarioNaoAutorizadoConsultarNotasAluno() {
        try {
            Boss boss = new Boss("Pablo", false);
            EmployeeProxy aluno = new EmployeeProxy(2);

            aluno.getSalary(boss);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Funcionário não autorizado", e.getMessage());
        }
    }
}