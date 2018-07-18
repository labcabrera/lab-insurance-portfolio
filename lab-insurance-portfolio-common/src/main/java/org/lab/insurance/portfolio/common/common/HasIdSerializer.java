package org.lab.insurance.portfolio.common.common;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class HasIdSerializer extends JsonSerializer<HasId<?>> {

	@Override
	public void serialize(HasId<?> entity, JsonGenerator jsonGenerator, SerializerProvider provider)
		throws IOException, JsonProcessingException {
		if (entity == null) {
			jsonGenerator.writeNull();
		}
		else {
			String id = String.valueOf(entity.getId());
			jsonGenerator.writeStartObject();
			jsonGenerator.writeStringField("id", id);
			jsonGenerator.writeEndObject();
		}
	}
}
