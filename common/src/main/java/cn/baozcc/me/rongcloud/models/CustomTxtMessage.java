package cn.baozcc.me.rongcloud.models;

//自定义消息
public class CustomTxtMessage extends Message {

	private String content;

	public CustomTxtMessage(String content) {
		this.type = "KM:TxtMsg";
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
