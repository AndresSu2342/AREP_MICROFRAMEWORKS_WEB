package com.mycompany.httpserver1;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class HttpRequest {
    private URI requri;
    private Map<String, String> queryParams = new HashMap<>();

    public HttpRequest(URI r){
        this.requri = r;
        parseQueryParams();
    }

    /**
     *
     * Metodo para extraer los parámetros de query en un mapa
     */
    private void parseQueryParams(){
        if(requri.getQuery() != null){
            String[] params = requri.getQuery().split("&");
            for(String p : params){
                String[] kv = p.split("=");
                if(kv.length == 2){
                    queryParams.put(kv[0], kv[1]);
                }
            }
        }
    }

    // Obtener un parámetro por nombre
    public String getValue(String paramName){
        return queryParams.get(paramName);
    }

    public String getPath(){
        return requri.getPath();
    }
}
