package teste;

import conn.ConnectionFactory;
import dominio.Pessoa;
import repository.PessoaRepository;

import java.util.List;

public class ConnectionFactoryTest {
    public static void main(String[] args) {
        PessoaRepository pd = new PessoaRepository();
        try {
            // Incluir uma pessoa

            //Pessoa p1 =new Pessoa(1, "José", "jose@email.com");
            //Pessoa p2 =new Pessoa(2, "Maria", "maria@email.com");
            //Pessoa p3 =new Pessoa(3, "Luna", "luna@email.com");
            //pd.incluirPessoa(p1);
            //pd.incluirPessoa(p2);
            //pd.incluirPessoa(p3);


            // Alterar uma pessoa
            // - Alterar a informação desejada usando o set(Classe encapsulada)
            try {
                Pessoa pes = pd.consultarPessoaIndividual(2);

                // se o resultado da consulta retornar null é porque não encontrou a pessoa
                if(pes != null) {
                    pes.setEmail("mariaAparecida@email.com");
                    // chama o método de update
                    pd.alterarPessoa(pes);
                } else {
                    System.out.println("Pessoa não encontrada!");
                }

                //Listando todas as pessoas
                List<Pessoa> listaPessoas = pd.ListarPessoas();
                for (Pessoa p : listaPessoas ) {
                    System.out.println("Id: " + p.getIdpessoa());
                    System.out.println("Nome: " + p.getNome());
                    System.out.println("Email: " + p.getEmail());
                }

            } catch (Exception e) {
                System.out.println("Algo deu errado ao alterar pessoa.");
            }


			// Excluir uma pessoa
			// verificar se a pessoa existe por código

			//Pessoa pessoa1 = pd.consultarPessoaIndividual(1);
			// chamar o método de delete
			//pd.excluirPessoa(pessoa1);
			// Listando todas as pessoas

			/*List<Pessoa> listaPessoas = pd.ListarPessoas();
			for(Pessoa p : listaPessoas){
				System.out.println("Id.: " + p.getIdpessoa());
				System.out.println("Nome : "  +p.getNome());
				System.out.println("Email : " +p.getEmail());
			}*/


        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
