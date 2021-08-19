package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class KillController {
	
	public KillController(){
		super();
	}
	
	public String os() {
		String os = System.getProperty("os.name");
		return os;
	}
	
	public void listaProcessos(String process) {
		try {
			Process p = Runtime.getRuntime().exec(process);
			InputStream fluxo = p.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			while(linha!= null) {
				System.out.println(linha);
				linha = buffer.readLine();
			}
			buffer.close();
			leitor.close();
			fluxo.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void callProcess(String process) {
		try {
		Runtime.getRuntime().exec(process);
		} catch(Exception e) {
			String msgErro = e.getMessage();
			if(msgErro.contains("740")) {
				//cmd/c caminho_do_processo
				StringBuffer buffer = new StringBuffer();
				buffer.append("cmd /c");
				buffer.append(" ");
				buffer.append(process);
			
				try {
					Runtime.getRuntime().exec(buffer.toString());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}else {
				System.err.println(msgErro);
			}
		}
	}
	
	public void mataPid(String paramPID, String os) {
		if(os.contains("W")) { //windows
			
			String cmdPid = "TASKKILL /PID";
			String cmdNome = "TASKKILL /IM";
		
			int pid = 0;
			StringBuffer buffer = new StringBuffer();

			try {
				pid = Integer.parseInt(paramPID);
				buffer.append(cmdPid);	
				buffer.append(" ");
				buffer.append(pid);
			}catch(NumberFormatException e) {
				buffer.append(cmdNome);
				buffer.append(" ");
				buffer.append(paramPID);
			}
			callProcess(buffer.toString());
		}else { //Linux
			String cmdPidLinux = "kill -9";
			String cmdNomeLinux ="pkill -f";
		
			int pid = 0;
			StringBuffer buffer = new StringBuffer();

			try {
				pid = Integer.parseInt(paramPID);
				buffer.append(cmdPidLinux);	
				buffer.append(" ");
				buffer.append(pid);
			}catch(NumberFormatException e) {
				buffer.append(cmdNomeLinux);
				buffer.append(" ");
				buffer.append(paramPID);
			}
			callProcess(buffer.toString());	
			
		}
	}
	
	public void mataNome(String param, String os) {
		if(os.contains("W")) { //windows
			
			String cmdPid = "TASKKILL /PID";
			String cmdNome = "TASKKILL /IM";
		
			int pid = 0;
			StringBuffer buffer = new StringBuffer();

			try {
				pid = Integer.parseInt(param);
				buffer.append(cmdPid);	
				buffer.append(" ");
				buffer.append(pid);
			}catch(NumberFormatException e) {
				buffer.append(cmdNome);
				buffer.append(" ");
				buffer.append(param);
			}
			callProcess(buffer.toString());
		}else { //Linux
			String cmdPidLinux = "kill -9";
			String cmdNomeLinux ="pkill -f";
		
			int pid = 0;
			StringBuffer buffer = new StringBuffer();

			try {
				pid = Integer.parseInt(param);
				buffer.append(cmdPidLinux);	
				buffer.append(" ");
				buffer.append(pid);
			}catch(NumberFormatException e) {
				buffer.append(cmdNomeLinux);
				buffer.append(" ");
				buffer.append(param);
			}
			callProcess(buffer.toString());	
			
		}
		
	}
	

}//fim
