import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.net.InetSocketAddress;
import java.io.IOException;
import java.util.Map;
import java.sql.*;
//javac -cp sqlite-jdbc-3.23.1.jar; JuniorProject.java
public class JuniorProject{
	public static void main(String [] args) throws IOException{
	
		int port = 8500;
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        Database  db =  new  Database("jdbc:sqlite:Rubydes.db" ); 
		

		String query = "SELECT * FROM Movies";
		String result = db.selectData(query);
		
		String query = "SELECT * FROM Directors";
		String result = db.selectData(query);
		
		server.createContext("/movies", new RouteHandler(result));
		server.createContext("/directors", new RouteHandler(result));
        server.start(); 
		
		System.out.println("Server started at port " + port);
	}
}

