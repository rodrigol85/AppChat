import java.io.Serializable;

public class PaccoDaInviare implements Serializable{
	
	private String nick;
	private String ip;
	private String messaggio;
	
	
	
	
	
	
	
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getMessaggio() {
		return messaggio;
	}
	public void setMessaggio(String messaggio) {
		this.messaggio = messaggio;
	}
	
	
	
	
	

}
