package com.mycompany.httpserver1;

/**
 *
 * @author
 */
import static com.mycompany.httpserver1.Httpserverasync.get;
import static com.mycompany.httpserver1.Httpserverasync.staticfiles;
import static com.mycompany.httpserver1.Httpserverasync.start;

public class WebApplication {
    public static void main(String[] args){
        staticfiles("/webroot");
        get("/hello", (res, req) -> req.getValue("name"));
        get("/pi", ((res, req) -> {
            return String.valueOf(Math.PI);
        }));
        start(args);
    }
}
