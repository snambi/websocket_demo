package demo;

import javax.websocket.server.ServerEndpointConfig.Configurator;

public class WsServerEndPointConfigurer extends Configurator{
	
	private WsServerEndPoint wsServer = new WsServerEndPoint();

	@Override
	public <T> T getEndpointInstance(Class<T> clazz) throws InstantiationException {
		//return super.getEndpointInstance(clazz);
		return (T) wsServer;
	}
	
	

}
