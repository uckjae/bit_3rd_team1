package concrete;

import java.util.Date;

import framework.Item;
import framework.ItemCreator;

public class HpCreator extends ItemCreator {

	@Override
	protected void requestItemInfo() {
		System.out.println("������ ���̽����� ü�� ������ ������ �����ɴϴ�");
	}

	@Override
	protected void createItemLog() {
		System.out.println("ȸ�� ������ ���� �����߽��ϴ�" + new Date());
		
	}

	@Override
	protected Item createItem() {
		
		return new HpPotion();
	}

}
