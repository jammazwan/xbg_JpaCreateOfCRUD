package jammazwan.xbg;

import org.apache.camel.test.spring.CamelSpringTestSupport;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractXmlApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import jammazwan.entity.City;

public class XbgTest extends CamelSpringTestSupport {

	@Override
	protected AbstractXmlApplicationContext createApplicationContext() {
		return new ClassPathXmlApplicationContext("META-INF/spring/camel-context.xml");
	}

	@Test
	public void testXbg() throws Exception {
		City city = new City(27, "Austin, TX", "USA", 8765432, 987, 1234);
		template.requestBody("direct:create", city, City.class);
		

		//query for validation purposes only. See xbh for more realistic queries
		City returnCity = (City)template.requestBody("direct:query", city);
		assertEquals("USA", returnCity.getCountry());
		assertEquals("Austin, TX", returnCity.getCity());
	}

}
