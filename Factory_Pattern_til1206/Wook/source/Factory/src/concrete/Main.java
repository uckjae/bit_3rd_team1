package concrete;

import framework.Item;
import framework.ItemCreator;

public class Main {
	public static void main(String[] args) {
		ItemCreator creator;
		Item item;
		
		creator = new HpCreator();
		item = creator.create();
		item.use();
		
		creator = new MpCreator();
		item = creator.create();
		item.use();
		
		//장점: 구조와 구현이 분리되어 있어서 main 변경할 필요 없이 수정가능
	}
}
