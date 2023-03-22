package repositories;

import entities.Estado;
import factories.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EstadoRepository {
    private final String INSERT = String.join(
            "\n",
            "insert into estados(sigla, nome)",
            "values(?, ?)"
    );

    private final String LISTAR = String.join(
            "\n",
            "select * ",
                    "from estados",
                    "order by nome"
    );

    public List<Estado> listar() {
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement comando = connection.prepareStatement(LISTAR);
             ResultSet resultado = comando.executeQuery();) {

            List<Estado> estados = new ArrayList<>();
            while (resultado.next()){
                Estado estado = new Estado();

                //resultado.get nome da coluna no banco

                estado.setCodigo(resultado.getInt("codigo"));
                estado.setSigla(resultado.getString("sigla"));
                estado.setNome(resultado.getString("nome"));

                estados.add(estado);
            }
            return estados;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void salvar(Estado estado){
        try(    Connection connection = ConnectionFactory.getConnection();
                PreparedStatement comando = connection.prepareStatement(INSERT);){

            comando.setString(1, estado.getSigla());
            comando.setString(2, estado.getNome());

            comando.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Estado estado = new Estado();
        estado.setSigla("RJ");
        estado.setNome("Rio de Janeiro");

        EstadoRepository estadoRepository = new EstadoRepository();
        estadoRepository.salvar(estado);
        estadoRepository.listar();
    }
}