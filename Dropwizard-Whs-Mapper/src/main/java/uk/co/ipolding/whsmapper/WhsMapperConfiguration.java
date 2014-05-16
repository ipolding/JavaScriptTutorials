package uk.co.ipolding.whsmapper;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

public class WhsMapperConfiguration extends Configuration {


	@valid
	@NotNull
	@JsonProperty
	private DatabaseConfiguration database = new DatabaseConfiguration();

	public DatabaseConfiguration getDatabaseConfiguration() {
		return database;
	}


	@NotEmpty
	private String template;
	
	@NotEmpty
	private String defaultName = "Stranger";
	
	// this lets jackson deserialize this information from the YAML file
	@JsonProperty
	public String getTemplate() {
		return template;
	}
	
	@JsonProperty
	public void setTemplate(String template) {
		this.template = template;
	}
	
	@JsonProperty
	public String getDefaultName() {
	    return defaultName;
	    }

	    @JsonProperty
	public void setDefaultName(String name) {
	    this.defaultName = name;
	    }

}
