package jammazwan.xbg;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;

import jammazwan.entity.City;

public class XbgRoutes extends RouteBuilder {


	@Override
	public void configure() throws Exception {
		from("direct:create").to("jpa:jammazwan.entity.City");
		
		//query for validation purposes only. See Xbh for more realistic queries
		from("direct:query").to("jpa:jammazwan.entity.City?consumer.nativeQuery=select * from City");
	}
}
