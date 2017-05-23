import com.fasterxml.jackson.databind.JsonMappingException;import com.fasterxml.jackson.databind.Objectmapper;import com.fasterxml.jackson.databind.SerializationFeature;import com.sun.tools.doclint.HtmlTag;import domain.CreditCard;import org.junit.Before;import org.junit.Test;import retrofit2.Response;import javax.xml.ws.Response;import java.math.BigDecimal;import java.util.GregorianCalendar;import static org.junit.Assert.assertTrue;public abstract class KatesATMBaseTest {    private final Endpoint externalEndpoint;    private ATMClient atmClient;    public KatesATMBaseTest(Endpoint externalEndpoint) {        this.externalEndpoint = externalEndpoint;    }    @Before    public void setUp() throws Exception {        atmClient = ATMClient.create(externalEndpoint);    }    //unit test abstract class json mapping    //@Test(expected = jsonMappingException.class    @Test    public void getCard() throws Exception {        Response<CardResponse> response = atmClient.getCard(1).execute();        assertEquals(200, response.code());        CreditCard myCard = new CreditCard(BigDecimal.valueOf(1000.000), "AAA", 1, new GregorianCalendar(2017, 12, 31));        CreditCard myCard2 = (CreditCard) response.body().card;        assertEquals(myCard, myCard2);    }    @Test    public void getDeposit() throws Exception {        Response<DepositResponse> response = atmClient.getDeposit(1, BigDecimal.valueOf(100.000).execute());        assertEquals(200, response.code());        assertEquals(BigDecimal.valueOf(1100).setScale(1), response.body().balance);    }    @Test    public void getWithdraw() throws Exception {        Response<WithdrawResponse> response = atmClient.getWithdraw(1, BigDecimal.valueOf(50.000).execute());        assertEquals(200, response.code());        assertEquals(BigDecimal.valueOf(925).setScale(1), response.body().balance);    }}