package com.mycompany.httpserver1;

import java.util.HashMap;
import java.util.Map;

/**
 * Clase que representa una respuesta HTTP
 */
public class HttpResponse {
    private int status = 200;
    private String body = "";
    private Map<String, String> headers = new HashMap<>();

    public HttpResponse(){
        headers.put("Content-Type", "text/html");
    }

    public void setStatus(int status){
        this.status = status;
    }

    public void setBody(String body){
        this.body = body;
    }

    public void setHeader(String key, String value){
        headers.put(key, value);
    }

    /**
     *
     * Construye la respuesta final en formato HTTP
     */
    public String buildResponse(){
        StringBuilder response = new StringBuilder("HTTP/1.1 " + status + " OK\r\n");
        headers.forEach((k,v) -> response.append(k + ": " + v + "\r\n"));
        response.append("\r\n");
        response.append(body);
        return response.toString();
    }
}
