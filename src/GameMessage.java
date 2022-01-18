import java.awt.event.ActionEvent;
import java.io.Serializable;

import javax.swing.JButton;



public class GameMessage implements Serializable {

	public enum MsgType {NO_ACT, LOGIN, LOGOUT, CLIENT_MSG, LOGIN_FAILURE, SERVER_MSG, LOGIN_LIST, GAME_INFO, GAME_START};
	public static final String ALL = "전체";	 // 사용자 명 중 자신을 제외한 모든 로그인되어 있는
											 // 사용자를 나타내는 식별문
	private MsgType type;
	private String sender;
	private String receiver;
	private String contents;	

	public int i,j;
	public boolean userCheck;
	
	public GameMessage() {
		this(MsgType.NO_ACT, "", "", "");
	}
	public GameMessage(MsgType t, String sID, String rID, String mesg) {
		type = t;
		sender = sID;
		receiver = rID;
		contents = mesg;
	}
	public GameMessage(MsgType t, int i, int j){
		type = t;
		this.i=i;
		this.j=j;
	}
	public GameMessage(MsgType t, boolean uk){
		type = t;
		userCheck = uk;
	}
	
	public void setType (MsgType t) {
		type = t;
	}
	public MsgType getType() {
		return type;
	}

	public void setSender (String id) {
		sender = id;
	}
	public String getSender() {
		return sender;
	}
	
	public void setReceiver (String id) {
		receiver = id;
	}
	public String getReceiver() {
		return receiver;
	}
	
	public void setContents (String mesg) {
		contents = mesg;
	}
	public String getContents() {
		return contents;
	}
	
	public String toString() {
		return ("메시지 종류 : " + type + "\n" +
				"송신자         : " + sender + "\n" +
				"수신자         : " + receiver + "\n" +
				"메시지 내용 : " + contents + "\n");
	}	

}
