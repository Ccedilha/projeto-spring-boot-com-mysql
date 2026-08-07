package com.example.projetospringbootcommysql.controller;

import com.example.projetospringbootcommysql.entity.AlunoEntity;
import com.example.projetospringbootcommysql.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
@CrossOrigin(origins = "*")
public class AlunoController {
    @Autowired
    private AlunoRepository comandos;
    // UsuarioRepositoru comandos = new UsuarioRepository();
    @PostMapping
    private AlunoEntity salvarAluno(
            @RequestBody AlunoEntity aluno){
        return comandos.save(aluno);
        // INSERT INTO usuario_entity VALUES ("Ian", "ian@gmail.com")
    }

    @GetMapping
    public List<AlunoEntity> listarAlunos(){
        //retornar todos os valores da tabela usuario_entity
        return comandos.findAll();
        // SELECT * FROM usuario_entity;
    }

    @PutMapping("/{id}")
    public AlunoEntity atualizarUsuario(
            @PathVariable Integer id,
            @RequestBody AlunoEntity alunoAtualizado
    ){
        AlunoEntity alunoAtual = comandos.findById(id).orElseThrow();
        alunoAtual.setNome(alunoAtualizado.getNome());
        alunoAtual.setIdade(alunoAtualizado.getIdade());
        alunoAtual.setRegistroAluno(alunoAtualizado.getRegistroAluno());
        alunoAtual.setEmailInstitucional(alunoAtualizado.getEmailInstitucional());
        alunoAtual.setTurma(alunoAtualizado.getTurma());
        alunoAtual.setPeriodo(alunoAtualizado.getPeriodo());
        alunoAtual.setApresentacao(alunoAtualizado.getApresentacao());

        return comandos.save(alunoAtual);
    }

    @DeleteMapping("/{id}")
    public String apagarAluno(
            @PathVariable Integer id
    ){
        // buscando usuario na tabela
        AlunoEntity pessoa = comandos.findById(id).orElseThrow();
        String nome = pessoa.getNome();

        comandos.deleteById(id); // apagando dentro do banco

        return "Aluno "+nome+" deletado com sucesso!";
    }
}



