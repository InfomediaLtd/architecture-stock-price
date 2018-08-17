package au.com.infomedia.architecture;

import java.util.Collections;

import static org.junit.Assert.*;

public class StockPriceHandlerTest {

    @org.junit.Test
    public void handleRequest() {
        StockPriceHandler stockPriceHandler = new StockPriceHandler();

        ApiGatewayResponse<String> response = stockPriceHandler.handleRequest(Collections.singletonMap("queryParameters", new Object()), null);

        assertEquals("{\"architecturePrice\": 1.22}", response.getBody());
    }
}