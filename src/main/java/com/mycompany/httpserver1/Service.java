package com.mycompany.httpserver1;


public interface Service {
    public String invoke(HttpResponse res, HttpRequest req);
}
