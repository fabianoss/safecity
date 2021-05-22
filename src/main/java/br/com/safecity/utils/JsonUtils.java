package br.com.safecity.utils;

import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {
	
	private static final Logger logger = LoggerFactory.getLogger(JsonUtils.class);
	
	public static String writeValueAsString(Object value) {
		String json = Strings.EMPTY;
		if(value == null) {
			return json;
		}
		try {			
			ObjectMapper mapper = new ObjectMapper();
			json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(value);
		}catch (Exception e) {
			logger.error("Erro JsonUtils.ObjectToString ",e);
		}
		return json;
	}

}
