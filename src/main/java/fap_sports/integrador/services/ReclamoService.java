package fap_sports.integrador.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fap_sports.integrador.models.Reclamo;

@Service
public class ReclamoService {

    private static final Logger logger = LoggerFactory.getLogger(ReclamoService.class);

    private final JdbcTemplate jdbcTemplate;

    public ReclamoService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Transactional
    public void registrarReclamo(Reclamo reclamo) {
        try {
            String sql = "INSERT INTO reclamos (rec_motivo, rec_descripcion, rec_solicitud) VALUES (?, ?, ?) RETURNING rec_id";
            logger.info("Ejecutando consulta SQL: {}", sql);
            logger.info("Valores: motivo={}, descripcion={}, solicitud{}",
                    reclamo.getRecMotivo(), reclamo.getRecDescripcion(), reclamo.getRecSolicitud());

            @SuppressWarnings("deprecation")
            Long reclamoId = jdbcTemplate.queryForObject(sql, new Object[]{
                            reclamo.getRecMotivo(), 
                            reclamo.getRecDescripcion(), 
                            reclamo.getRecSolicitud()
                    },
                    Long.class);

                    logger.info("Valores: reclamoId={}, RecId={}", reclamoId, reclamo.getRecId());

        logger.info("Reclamo registrado con exito: {}", reclamo.getRecMotivo());

        } catch (DataAccessException e) {
            logger.error("Error al insertar el reclamo", e);
            logger.error("Error al insertar el reclamo: " + e.getMessage(), e); 
            System.err.println("Error al insertar reclamo: " + e.getMessage());
            throw new RuntimeException("Error al registrar el reclamo", e);
        }
    }
    public List<Reclamo> listarReclamos() {
        String sql = "SELECT rec_id, rec_motivo, rec_descripcion, rec_solicitud FROM reclamos";

        logger.info("Ejecutando consulta SQL para listar reclamos: {}", sql);

        return jdbcTemplate.query(sql, new RowMapper<Reclamo>() {
            @Override
            public Reclamo mapRow(ResultSet rs, int rowNum) throws SQLException {
                Reclamo reclamo = new Reclamo();
                reclamo.setRecId(rs.getLong("rec_id"));
                reclamo.setRecMotivo(rs.getString("rec_motivo"));
                reclamo.setRecDescripcion(rs.getString("rec_descripcion"));
                reclamo.setRecSolicitud(rs.getString("rec_solicitud"));
                return reclamo;
            }
        });
    }
}