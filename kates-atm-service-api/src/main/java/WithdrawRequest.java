import com.sun.istack.internal.NotNull;import javax.validation.constrains.Min;import javax.validation.constrains.NotNull;import javax.ws.rs.PathParam;import javax.ws.rs.QueryParam;import java.math.BigDecimal;public class WithdrawRequest extends TransportObject {    @PathParam("cardNumber")    @NotNull    @Min(1)    public Integer cardNumber;    @QueryParam("amount")    @NotNull    @Min(1)    public BigDecimal amount;}