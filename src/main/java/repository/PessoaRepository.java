package repository;

import conn.ConnectionFactory;
import dominio.Pessoa;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PessoaRepository extends ConnectionFactory{

    public void incluirPessoa(Pessoa p) throws Exception {
        open();
        stmt = con.prepareStatement("insert into pessoa values(?,?,?)");
        stmt.setInt(1, p.getIdpessoa());
        stmt.setString(2, p.getNome());
        stmt.setString(3, p.getEmail());
        stmt.execute();
        stmt.close();
        close();
    }

    public void alterarPessoa(Pessoa p) throws Exception {
        open();
        stmt = con.prepareStatement("update pessoa set nome = ?, email = ? where idpessoa = ?");
        stmt.setString(1, p.getNome());
        stmt.setString(2, p.getEmail());
        stmt.setInt(3, p.getIdpessoa());
        stmt.execute();
        stmt.close();
        close();
    }

    public void excluirPessoa(Pessoa p) throws Exception {
        open();
        stmt = con.prepareStatement("delete from Pessoa where idpessoa = ?");
        stmt.setInt(1, p.getIdpessoa());
        stmt.execute();
        stmt.close();
        close();
    }

    // retornando um objeto
    public Pessoa consultarPessoaIndividual(int cod) throws Exception {
        open();
        stmt = con.prepareStatement("select * from pessoa where idpessoa = ?");
        stmt.setInt(1, cod);
        rs = stmt.executeQuery();
        Pessoa p = null;
        if (rs != null) {
            if (rs.next()){
                p = new Pessoa();
                p.setIdpessoa(rs.getInt("idpessoa"));
                p.setNome(rs.getString("nome"));
                p.setEmail(rs.getString("email"));
            } else {
                System.out.println("Registro não encontrado.");
            }
        }
        close();
        return p;
    }

    public List<Pessoa> ListarPessoas() {
        try {
            open();
            stmt = con.prepareStatement("select * from pessoa");
            rs = stmt.executeQuery();
            List<Pessoa> listaPessoas = new ArrayList<>();

            while (rs.next()) {
                Pessoa p = new Pessoa();
                p.setIdpessoa(rs.getInt("idpessoa"));
                p.setNome(rs.getString("nome"));
                p.setEmail(rs.getString("email"));
                listaPessoas.add(p);
            }
            close();
            return listaPessoas;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
