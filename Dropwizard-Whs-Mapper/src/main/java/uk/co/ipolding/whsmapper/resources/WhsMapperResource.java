package uk.co.ipolding.whsmapper.resources;
import com.google.common.base.Optional;
import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import uk.co.ipolding.helloworld.core.Saying;

import java.util.concurrent.atomic.AtomicLong;

@Path("/hello-world")
@Produces(MediaType.APPLICATION_JSON)
public class WhsMapperResource {
	private final String template;
	private final String defaultName;
	private final AtomicLong counter;
	
	public WhsMapperResource(String template, String defaultName){
		this.template = template;
		this.defaultName = defaultName;
		this.counter = new AtomicLong();
	}
	
	@GET
	@Timed // Dropwizard automatically records the duration and rate of its invocations as a Metrics Timer.
	public Saying sayHello(@QueryParam("name") Optional<String> name) {
		final String value = String.format(template, name.or(defaultName));
		return new Saying(counter.incrementAndGet(), value);
		
	}
	
	

}
