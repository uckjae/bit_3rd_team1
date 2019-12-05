package concrete;

import abs.Button;
import abs.GuiFactory;
import abs.TextArea;

public class FactoryInstance {
	public static GuiFactory getGuiFactory() {
		
		switch(getOsCode()) {
		case 0:	return new WinGuiFactory();
		case 1:	return new MacGuiFactory();
		case 2:	return new LinuxGuiFactory();
		
		}
		
		return null;
	}
}	
	


private static int getOsCode() {
	String os = System.getProperty("os.name");
	int code = -1;
	if(os.contains("Window")) {
		code = 0;
	}else if(os.contains("Mac")) {
		code = 1;
	}else if(os.contains("Linux")) {
		code = 2;
	}
	return code;
	
}

class LinuxTextArea implements TextArea {

	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return "리눅수 텍스트에리어";
	}

}

class LinuxButton implements Button {

	@Override
	public void click() {
		// TODO Auto-generated method stub
		System.out.println("리눅스 버튼");
	}

}

class LinuxGuiFactory implements GuiFactory {

	@Override
	public Button createButton() {
		return new LinuxButton();
	}

	@Override
	public TextArea createTextArea() {
		// TODO Auto-generated method stub
		return new LinuxTextArea();
	}

}

class MacButton implements Button {

	@Override
	public void click() {
		// TODO Auto-generated method stub
		System.out.println("맥 버튼 클릭");
	}

}

class MacGuiFactory implements GuiFactory {

	@Override
	public Button createButton() {
		// TODO Auto-generated method stub
		return new MacButton();
	}

	@Override
	public TextArea createTextArea() {
		// TODO Auto-generated method stub
		return new MacTextArea();
	}

}

class MacTextArea implements TextArea {

	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return "맥 텍스트 에리어";
	}

}

class WinButton implements Button {

	@Override
	public void click() {
		// TODO Auto-generated method stub
		System.out.println("윈도우 버튼 클릭");
	}

}

class WinGuiFactory implements GuiFactory {

	@Override
	public Button createButton() {
		// TODO Auto-generated method stub
		return new WinButton();
	}

	@Override
	public TextArea createTextArea() {
		// TODO Auto-generated method stub
		return new WinTextArea();
	}

}

class WinTextArea implements TextArea {

	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return "윈도우 텍스트 에리어";
	}

}

