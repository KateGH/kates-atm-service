import org.junit.experimental.categories.Category;import javax.xml.ws.Endpoint;@Category(RemoteIntegrationTests.class)public class KatesATMRemoteIT extends KatesATMBaseTest {    public KatesATMRemoteIT() {        super(new Endpoint(Host.httpHost("localhost", 8959), "kates-atm-service/v1/atm"));    }}