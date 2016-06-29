package jammazwan.xbg;

import org.apache.camel.builder.RouteBuilder;

public class XbgRoutes extends RouteBuilder {


	@Override
	public void configure() throws Exception {
		from("direct:create").to("jpa:jammazwan.entity.City");
		
		//query for validation purposes only. See Xbh for more realistic queries
		from("direct:query").to("jpa:jammazwan.entity.City?consumer.nativeQuery=select * from City");
	}
}
