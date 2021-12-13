package echo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) throws IOException {
		
		Socket socket = new Socket();
		
		System.out.println("클라이언트 시작");
		
		System.out.println("서버연결 요청");
//		자키컴퓨터 ip넣지말것
		
//		원주니
//		serverSocket.bind(new InetSocketAddress("118.36.228.129", 10001));
		socket.connect(new InetSocketAddress("192.168.0.14", 10001));
		
//		내꺼
//		socket.connect(new InetSocketAddress("192.168.1.24", 10001));
		
		System.out.println("연결되었습니다");
		
		
//		메시지 보내기 스트림
		OutputStream os = socket.getOutputStream(); //주스트림
		OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
		BufferedWriter bw = new BufferedWriter(osw);
		
//		서버단에서 보낸 메시지 받기 스트림
		InputStream is = socket.getInputStream();
		InputStreamReader isr = new InputStreamReader(is, "UTF-8");
		BufferedReader br = new BufferedReader(isr);
		
//		메시지 보내기
//		C:\javaStudy\workspace\chapter06\bin
//		java echo.ex01.Client
		
		
//		키보드 입력 Scanner
		Scanner sc = new Scanner(System.in);
		
//		반복구간
		while (true) {
			System.out.print("메시지를 입력하세요 >>");
			
			String str = sc.nextLine();		
			if ("/q".equals(str) ) { // str == "/q" string을 바로 못넣는다 단순 주소비교
//				str.equals("/q") 비교하면 null point가 생길 수 있으니 위의 방식으로 하면 에러없음
				System.out.println("종료합니다");
				break;
			} 
			
//			String str = "안녕하니?";
			bw.write(str);
			bw.newLine();
			bw.flush(); //null 에러메시지가 나오면 비우기
			
//			메시지 받기
			String reMsg = br.readLine();
			System.out.println("서버에서 받은 메시지 : "+reMsg);

			
			
		}
		
		
		
		
		
		System.out.println("클라가 종료");
		bw.close();
		socket.close();
		sc.close();
		
	}

}
