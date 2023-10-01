package my.project.dataaccessobject.repository;

import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class DAORepository {
    private static final String scriptFile = "select_product_name.sql";
    private final String scriptFile2;
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public DAORepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.scriptFile2 = read();
    }

    private static String read() {
        try (InputStream inputStream = new ClassPathResource(DAORepository.scriptFile).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> getProductName(String name) {
        return jdbcTemplate.query(scriptFile2, Map.of("name", name),
                ((rs, rowNum) -> rs.getString("product_name")));
    }
}
