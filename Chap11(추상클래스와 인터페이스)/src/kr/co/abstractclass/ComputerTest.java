package kr.co.abstractclass;

public class ComputerTest {

	public static void main(String[] args) {
		
		// 다형성 적용해서 DeskTop 객체 생성
		Computer computer = new DeskTop();
		computer.display();
		computer.turnOff();
		System.out.println();

		Computer computer2 = new MyNoteBook();
		computer2.display();
		computer2.typing();	// NoteBook typing()
		System.out.println();
		
		NoteBook computer3 = new MyNoteBook();
		computer3.display();
		computer3.typing();	// NoteBook typing()
		System.out.println();
	}
}
