package view;

import controller.KillController;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		KillController kControl = new KillController();
		Scanner input = new Scanner(System.in);
		String os = kControl.os();
		
		//lista processos
		if(os.contains("W") == true) {
			String process = "TASKLIST /FO TABLE";
			kControl.listaProcessos(process);
		}else {
			String process = "ps -ef";
			kControl.listaProcessos(process);
		}
		
		//mataNome
		System.out.print("\nDigite o nome do processo para encerra-lo: ");
		String processNome = input.next();
		
		String param = processNome;
		kControl.mataNome(param, os);
		
		//mataPID
		System.out.print("\nDigite o PID do processo para encerra-lo: ");
		String processPID = input.next();
		
		String paramPID = processPID;
		kControl.mataPid(paramPID, os);
		
	}

}
