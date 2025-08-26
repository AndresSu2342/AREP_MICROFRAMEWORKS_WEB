/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.httpserver1;

import java.net.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Httpserverasync {

    public static Map<String, Service> services = new HashMap();
    private static String staticFilesPath = "webroot"; // ruta por defecto

    public static void main(String[] args) throws IOException, URISyntaxException {
        start(args);
    }

    public static void get(String path, Service s){
        services.put(path, s);
    }

    private static String invokeService(URI requri){
        HttpRequest req = new HttpRequest(requri);
        HttpResponse res = new HttpResponse();
        String key="";
        Service s = services.get(key);
        return s.invoke(res, req);
        //throw new UnsupportedOperationException("Not suppoted yet");
    }

    public static void staticfiles(String localFilesPath){
        staticFilesPath = localFilesPath;
    }

    public static void start(String[] args){
        runServer(args);
    }

    private static void runServer(String[] args){
        try(ServerSocket serverSocket = new ServerSocket(35000)){
            boolean running = true;
            while(running){
                System.out.println("Listo para recibir ...");
                Socket clientSocket = serverSocket.accept();
                handleClient(clientSocket);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    private static void handleClient(Socket clientSocket){
        try(
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))
        ){
            String inputLine;
            String requestLine = in.readLine();
            if(requestLine == null) return;

            URI requri = new URI(requestLine.split(" ")[1]);
            HttpRequest req = new HttpRequest(requri);
            HttpResponse res = new HttpResponse();

            System.out.println("Path solicitado: " + req.getPath());

            String outputLine;

            // Verificar si existe un servicio registrado
            if(services.containsKey(req.getPath())){
                Service s = services.get(req.getPath());
                String result = s.invoke(res, req);
                res.setBody(result);
                outputLine = res.buildResponse();
            } else {
                // Si no es servicio, intentar servir archivo estático
                outputLine = serveStaticFile(req.getPath(), res);
            }

            out.println(outputLine);

        } catch(Exception e){
            e.printStackTrace();
        }
    }

    private static String serveStaticFile(String path, HttpResponse res){
        try {
            String filePath = "target/classes" + staticFilesPath + path;
            if(Files.exists(Paths.get(filePath))){
                String mimeType = Files.probeContentType(Paths.get(filePath));
                res.setHeader("Content-Type", mimeType != null ? mimeType : "text/plain");
                String body = new String(Files.readAllBytes(Paths.get(filePath)));
                res.setBody(body);
                return res.buildResponse();
            } else {
                res.setStatus(404);
                res.setBody("<h1>404 Not Found</h1>");
                return res.buildResponse();
            }
        } catch (IOException e){
            res.setStatus(500);
            res.setBody("<h1>500 Internal Server Error</h1>");
            return res.buildResponse();
        }
    }
}
