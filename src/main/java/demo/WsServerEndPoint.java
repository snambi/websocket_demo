package demo;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value="/ws", configurator=WsServerEndPointConfigurer.class)
public class WsServerEndPoint {

	private Set<Session> userSessions = Collections.synchronizedSet(new HashSet<Session>());
	
	@OnOpen
	public void onOpen( Session userSession ){
		userSessions.add(userSession);
	}
	
	@OnClose
	public void close( Session session ){
		userSessions.remove(session);
	}
	
	@OnMessage
	public void onMessage( String message, Session userSession ){
		System.out.println("message received: " + message );
		for( Session s : userSessions ){
			s.getAsyncRemote().sendText(message);
		}
	}
}
