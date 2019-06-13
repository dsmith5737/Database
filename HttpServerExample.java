import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;

import java.net.InetSocketAddress;
import java.util.Map;

//javac HttpServerExample.java

public class HttpServerExample {

    public static void main(String[] args) throws IOException {
        int port = 8500;
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
            
        server.createContext("/", new RouteHandler("Hi Boss"));
        server.createContext("/student", new RouteHandler("desirae"));

        String html = "<html><body><marquee>My first webpage</marquee></body></html>";
		server.createContext("/mypage", new RouteHandler(html));

        html = Input.readFile("Me.HTML");
        server.createContext("/Me", new RouteHandler(html));

        server.start(); 
        System.out.println("Server is listening on port " + port );
        

    }    
}
