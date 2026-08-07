package com.example.projetospringbootcommysql.repository;

import com.example.projetospringbootcommysql.entity.AlunoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

// Nessa interface, eu vou importar os meus métodos que representam comando SQL
//Tenho que especificar a classe que eu vou usar como Exemplo de tabela
// E também especificar o tipo de dado do meu ID da classe extends
public interface AlunoRepository extends JpaRepository<AlunoEntity, Integer> {
}
