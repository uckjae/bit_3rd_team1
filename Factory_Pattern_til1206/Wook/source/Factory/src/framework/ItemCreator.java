package framework;

public abstract class ItemCreator {
	public Item create() {
		Item item;
		
		requestItemInfo();
		item = createItem();
		createItemLog();
		return item;
	}
	
	//�������� �����ϱ� ���� ������ ���̽����� ������ ������ ��û�մϴ�.
	abstract protected void requestItemInfo();
	//�������� ���� �� ������ ���� ���� �ҹ��� �����ϱ� ���� ������ ���̽��� ������ ����
	abstract protected void createItemLog();
	//�������� �����ϴ� �˰���
	abstract protected Item createItem();
}
