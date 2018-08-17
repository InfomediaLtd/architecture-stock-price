package au.com.infomedia.architecture;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.util.Map;

public class StockPriceHandler implements RequestHandler<Map<String,Object>, ApiGatewayResponse<String>> {
    @Override
    public ApiGatewayResponse<String> handleRequest(Map<String, Object> input, Context context) {
        return new ApiGatewayResponse<>("hey there");
    }
}
