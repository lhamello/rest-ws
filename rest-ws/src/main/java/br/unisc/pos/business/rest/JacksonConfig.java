package br.unisc.pos.business.rest;

import java.text.SimpleDateFormat;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import org.codehaus.jackson.map.ObjectMapper;

/**
 * Configuração do Jackson (Json Binding do EAP).
 * 
 * O default do Jackson é converter Date/Calendar para timemillis.
 * http://wiki.fasterxml.com/JacksonFAQDateHandling
 * 
 */
@Provider
// @Produces(MediaType.APPLICATION_JSON)
// @Consumes(MediaType.APPLICATION_JSON)
public class JacksonConfig implements ContextResolver<ObjectMapper> {

    private final ObjectMapper objectMapper;

    public JacksonConfig() {
        objectMapper = new ObjectMapper();
        objectMapper.setDateFormat(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"));
        // objectMapper.configure(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS,
        // false);
    }

    public ObjectMapper getContext(Class<?> type) {
        return objectMapper;
    }
}