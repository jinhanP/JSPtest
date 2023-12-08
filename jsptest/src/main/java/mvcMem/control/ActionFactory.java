package mvcMem.control;
//명령어에 해당하는 실제 액션을 생성해줄 Factory
public class ActionFactory {
	
	private static ActionFactory factory;
	
	private ActionFactory() {
		
	}
	
	//synchronized 데이터 불일치를 방지하기 위한 동기화
	//getinstance() 최초에 할당된 하나의 메모리를 계속 쓰는 방식이다.
	public static synchronized ActionFactory getinstance() {
		return factory;
	}
}	
