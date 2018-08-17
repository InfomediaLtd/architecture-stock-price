package au.com.infomedia.architecture;

import java.util.HashMap;
import java.util.Map;

public class ApiGatewayResponse<T> {
    private final int statusCode;
    private final Map<String,String> headers;
    public final transient T result;
    private final String body;
    private final boolean isBase64Encoded;

    public ApiGatewayResponse(T result) {
        this.result = result;
        isBase64Encoded = false;
        if (result != null) {
            statusCode = 200;
            headers = createHeaders();
            body = result instanceof String ? (String)result : "";
        } else {
            statusCode = 404;
            headers = createHeaders();
            body = "{\"error\": \"Not found!\"}";
        }
    }

    private HashMap<String, String> createHeaders() {
        HashMap<String,String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("Access-Control-Allow-Origin", "*");
        headers.put("Access-Control-Allow-Credentials", "true");
        return headers;
    }

    public ApiGatewayResponse(Exception error) {
        result = null;
        isBase64Encoded = false;
        statusCode = 500;
        headers = createHeaders();

        String message = error.getMessage();
        body = "{\"error\": \"" + message + "\"}";
    }

    public ApiGatewayResponse(int statusCode, T body, Map<String,String> headers) {
        this.result = body;
        this.isBase64Encoded = false;
        this.statusCode = statusCode;
        this.headers = headers;
        this.body = body == null ? null : body.toString();
    }

    public ApiGatewayResponse() {
        this((T) null);
    }

    public int getStatusCode() {
        return statusCode;
    }

    public boolean isBase64Encoded() {
        return isBase64Encoded;
    }

    public String getBody() {
        return body;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    @Override
    public String toString() {
        return "ApiGatewayResponse{" +
                "statusCode=" + statusCode +
                ", headers=" + headers +
                ", body='" + body + '\'' +
                ", isBase64Encoded=" + isBase64Encoded +
                '}';
    }
}
