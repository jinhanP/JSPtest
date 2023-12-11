package mvcMem.control2;


import mvcMem.action2.Action;
//싱글톤
public class ActionFactory {
	//싱글톤
	private static ActionFactory factory;

	private ActionFactory() {
	}

	public static synchronized ActionFactory getInstance() {
		if (factory == null) {
			factory = new ActionFactory();
		}
		return factory;
	}

		//cmd 지시를 받는 용도 그 지시를 받는걸 action 으로 설정한다.
	public Action getAction(String cmd) {
		Action action = null;
		switch (cmd) {
		case "index":
			action = new mvcMem.action2.IndexAction();
			break;
		case "login":
			action = new mvcMem.action2.LoginFormAction();
			break;
		case "loginProc":
			action = new mvcMem.action2.LoginProcAction();
			break;
		case "logout":
			action = new mvcMem.action2.LogoutAction();
			break;
		case "regForm":
			action = new mvcMem.action2.RegFormAction();
			break;
		case "regProc":
			action = new mvcMem.action2.RegProcAction();
			break;
		case "modifyForm":
			action = new mvcMem.action2.ModifyFormAction();
			break;
		case "modifyProc":
			action = new mvcMem.action2.ModifyProcAction();
			break;
		case "deleteForm":
			action = new mvcMem.action2.DeleteFormAction();
			break;
		case "deleteProc":
			action = new mvcMem.action2.DeleteProcAction();
			break;
		case "idCheck":
			action = new mvcMem.action2.IdCheckAction();
			break;
		case "zipCheck":
			action = new mvcMem.action2.ZipCheckAction();
			break;
		default:
			action = new mvcMem.action2.IndexAction();
			break;
		}
		return action;
	}
}