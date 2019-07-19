package teste.supero.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import teste.supero.util.RegistroPaginado;
import teste.supero.util.ParametroPaginacao;

import java.lang.reflect.ParameterizedType;
import java.sql.SQLException;
import java.util.List;

public class GenericDao <T> {

    private  QueryRunner queryRunner;

    public GenericDao() {
        this.queryRunner = new QueryRunner(DataSourceFactory.getMySQLDataSource());;
    }

    protected RegistroPaginado<T> buscarRegistros(String filtro, ParametroPaginacao parametroPaginacao){
        BeanListHandler<T> h = new BeanListHandler<T>(getTypeClass());
        RegistroPaginado retorno = new RegistroPaginado(parametroPaginacao);

        try {
            List<T> registros = queryRunner.query(getQueryPaginada(filtro, parametroPaginacao), h);
            retorno.setRegistros(registros);
            retorno.setTotalRegistros(buscarTotalRegistro(filtro));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return retorno;
    }

    private Integer buscarTotalRegistro(String filtro){
        try {
            return ((Number) this.queryRunner
                    .query(getQueryTotal(filtro), new ScalarHandler<>(1)))
                    .intValue();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private String getQueryPaginada(String filtro, ParametroPaginacao parametroPaginacao){
        String query = "SELECT * FROM " + getTypeClass().getSimpleName().toLowerCase() + " where "+filtro;
        query+= " LIMIT "+parametroPaginacao.getInicio() + ", "+parametroPaginacao.getRegistrosPorPagina();
        return query;
    }

    private String getQueryTotal(String filtro){
        return "SELECT count(*) FROM " + getTypeClass().getSimpleName().toLowerCase() + " where "+filtro;
    }

    private Class getTypeClass() {
        Class<?> clazz = (Class<?>) ((ParameterizedType) this.getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
        return clazz;
    }

}
