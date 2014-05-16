package uk.co.ipolding.whsmapper;



import uk.co.ipolding.whsmapper.health.TemplateHealthCheck;
import uk.co.ipolding.whsmapper.resources.WhsMapperResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class WhsMapperApplication extends Application<WhsMapperConfiguration>{
	
	public static void main (String[] args) throws Exception {
		new WhsMapperApplication().run(args);
		}
	
	@Override
	public String getName() {
		return "hello-world";
	}
	
	@Override
	public void initialize(Bootstrap<HelloWorldConfiguration> bootstrap){
//		Nothing to do yet
		}
	
	public void run(HelloWorldConfiguration configuration, Environment environment){
		final WhsMapperResource resource = new WhsMapperResource(
				configuration.getTemplate(),
				configuration.getDefaultName()
		);
		final TemplateHealthCheck healthCheck =
		        new TemplateHealthCheck(configuration.getTemplate());
		    environment.healthChecks().register("template", healthCheck);
	    environment.jersey().register(resource);

	}
	

}
