package br.unb.cic.imdb.negocio;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Scartezini on 18/11/2015.
 */
@Entity
@Table(name = "TB_Usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String login;

    @Column
    private String senha;

    @Column
    private String nome;

    @Column
    private String nascimento;

    
    @OneToMany(mappedBy = "usuario")
    private List<Avaliacao> avaliacao;
    
    public Usuario(){}
    
    public Usuario( String login, String senha, String nome, String nascimento) {
		this.login = login;
		this.senha = senha;
		this.nome = nome;
		this.nascimento = nascimento;
	}

	public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public List<Avaliacao> getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(List<Avaliacao> avaliacao) {
        this.avaliacao = avaliacao;
    }
}