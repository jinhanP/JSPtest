package mvc.control;


import mvc.action.Action;


public class ActionFactory {
	//액션 팩토리는 싱글톤으로 만들어준다.
	//멤버참조변수 하나를 만든다
	private static ActionFactory factory = new ActionFactory();
	//생성자 함수
	private ActionFactory() {}
	public static synchronized ActionFactory getInstance() {
		return factory;
	}
	
	//어떤 액션을 진행할지 결정하는 함수를 만들어준다.
	//cmd curd중에 어떤걸 쓸지 개발자끼리 약속해서 쓴다.
	public Action getAction(String cmd) {
		//부모로부터 자식에게 상속받는다.
		Action action = null;
		
		if(cmd.equals("index")) {
			//ActionFactory가 어떤걸 찾는지 알았다
			action =  (Action) new mvcMem.action.IndexAction();
			
		}
		
		return null;
	}
}
