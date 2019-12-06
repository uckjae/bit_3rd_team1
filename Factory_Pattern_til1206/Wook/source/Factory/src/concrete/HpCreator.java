package concrete;

import java.util.Date;

import framework.Item;
import framework.ItemCreator;

public class HpCreator extends ItemCreator {

	@Override
	protected void requestItemInfo() {
		System.out.println("데이터 베이스에서 체력 물약의 정보를 가져옵니다");
	}

	@Override
	protected void createItemLog() {
		System.out.println("회복 뭉약을 새로 생성했습니다" + new Date());
		
	}

	@Override
	protected Item createItem() {
		
		return new HpPotion();
	}

}
