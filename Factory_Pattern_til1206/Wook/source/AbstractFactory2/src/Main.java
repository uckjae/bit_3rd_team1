import abs.Button;
import abs.GuiFactory;
import abs.TextArea;
import concrete.FactoryInstance;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GuiFactory factory = FactoryInstance.getGuiFactory();
								
		Button button = factory.createButton();
		TextArea textarea = factory.createTextArea();
		
		button.click();
		System.out.println(textarea.getText());
		System.out.println(System.getProperty("os.name"));
		
		
				
	}

}
