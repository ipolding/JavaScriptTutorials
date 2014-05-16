package uk.co.ipolding.whsmapper.resources;
import com.google.common.base.Optional;
import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import uk.co.ipolding.helloworld.core.Saying;
import uk.co.ipolding.whsmapper.core.WhsDao;
import uk.co.ipolding.whsmapper.core.WorldHeritageSite;

import java.util.concurrent.atomic.AtomicLong;

@Path("/hello-world")
@Produces(MediaType.APPLICATION_JSON)
public class WhsResource {
	
	private final String template;
	private final String defaultName;
	private final AtomicLong counter;
	private final WhsDao dao;
	
	public WhsMapperResource(String template, String defaultName, WhsDao dao){
		this.dao = dao;
		this.template = template;
		this.defaultName = defaultName;
		this.counter = new AtomicLong();
	}
	
	@GET
	@Timed // Dropwizard automatically records the duration and rate of its invocations as a Metrics Timer.
	public WorldHeritageSite getName(@QueryParam("name") int id) {
        dao.findNameById(id);

        final String value = String.format(template, name.or(defaultName));
		return new WorldHeritageSite(id, value);
		
	}
	
	

}
