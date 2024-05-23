package Login;
import java.io.*;
import java.net.*;

public class Main {
	public static void main(String[] args) throws Exception
	{
		int port = 9999; // 서버 포트 번호

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("서버가 " + port + "포트에서 시작되었습니다.");

            while (true) {
                try (Socket clientSocket = serverSocket.accept()) {
                    System.out.println("클라이언트 연결됨: " + clientSocket.getInetAddress().getHostAddress());

                    DataInputStream in = new DataInputStream(clientSocket.getInputStream());
                    DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

                    String message = in.readUTF();
                    System.out.println("클라이언트가 보낸 메시지: " + message);

                    String response = "서버로부터의 응답입니다.";
                    out.writeUTF(response);
                    System.out.println("클라이언트에게 전송된 메시지: " + response);
                }
            }
        }
	}
}
