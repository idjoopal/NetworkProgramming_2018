import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.logging.*;
import com.google.gson.*;
import static java.util.logging.Level.*;

public class MultiChatController implements Runnable{

    // 뷰 클래스 참조 객체
    private final MultiChatUI v;

    // 데이터 클래스 참조 객체
    private final MultiChatData chatData;

    // 소켓 연결을 위한 변수 선언
    private String ip = "203.252.148.148";
    private Socket socket;
    private BufferedReader inMsg = null;
    private PrintWriter outMsg = null;

    // 메시지 파싱을 위한 객체 생성
    Gson gson = new Gson();
    Message m;

    // 상태 플래그
    boolean status;

    // 로거 객체
    Logger logger;

    // 메시지 수신 스레드
    Thread thread;

    /**
     * 모델과 뷰 객체를 파라미터로 하는 생성자
     * @param chatData
     * @param v
     */
    public MultiChatController(MultiChatData chatData, MultiChatUI v) {
        // 로거 객체 초기화
    	logger = Logger.getLogger(this.getClass().getName());
    	
        // MultiChatData, MultiChatUI 객체 초기화
    	this.chatData = chatData;
    	this.v = v;
    }

    /**
     * 어플리케이션 메인 실행 메서드
     */
    public void appMain() {
        // 데이터 객체(chatData)에서 (채팅내용 출력창의) 데이터 변화를 처리할 UI 객체 추가
        chatData.addObj(v.msgOut);

        v.addButtonActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object obj = e.getSource();

                // 종료버튼, 로그인버튼, 로그아웃버튼, 메시지전송버튼(엔터) 처리
                if (obj == v.exitButton) {
                	System.exit(0);
                	
                } else if (obj == v.loginButton) {
                	v.id = v.idInput.getText();
					v.outLabel.setText(" 대화명 : " + v.id);
					v.cardLayout.show(v.tab, "logout");
                	connectServer();
                	
                } else if (obj == v.logoutButton) {
                    // 로그아웃 메시지 전송
                    outMsg.println(gson.toJson(new Message(v.id, "", "", "logout")));
                    
                    // 대화창 클리어
                    chatData.refreshData("");
                    
                    // 로그인 패널로 전환 및 소켓/스트림 닫기 + status 업데이트
                    v.cardLayout.show(v.tab, "login");
                    outMsg.close();
                    
                    try {
                    	inMsg.close();
                    	socket.close();
                    } catch (IOException e1) {
                    	e1.printStackTrace();
                    }
                    status=false;
                    
                } else if (obj == v.msgInput) {
                    // 입력된 메시지 전송 (위의 로그아웃 메시지 전송코드와 Message 생성자 참고)
                	outMsg.println(gson.toJson(new Message(v.id, "", v.msgInput.getText(), "")));
                  
                    // 입력창 클리어
                	v.msgInput.setText("");
                }
            }
        });
    }

    /**
     * 서버 접속을 위한 메서드 (멤버필드를 적극 활용하기 바람; 이 메서드 안에서 새롭게 선언이 필요한 변수는 없음)
     */
    public void connectServer() {
        try {
            // 소켓 생성 (ip, port는 임의로 설정하되 나중에 서버에서 듣게될 포트와 동일해야함)
        	socket = new Socket(ip, 8888);
        	// INFO 레벨 로깅 (서버 연결에 성공했다는 메시지 화면에 출력)

            // 입출력(inMsg, outMsg) 스트림 생성
        	inMsg = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        	outMsg = new PrintWriter(socket.getOutputStream(),true);
        	
            // 서버에 로그인 메시지 전달
        	outMsg.println(gson.toJson(new Message(v.id, "", "", "login")));
        	
            // 메시지 수신을 위한 스레드(thread) 생성 및 스타트
        	thread = new Thread(this);
        	thread.start();
        }
        catch(Exception e) {
            logger.log(WARNING, "[MultiChatUI]connectServer() Exception 발생!!");
            e.printStackTrace();
        }
    }

    /**
     * 메시지 수신을 독립적으로 처리하기 위한 스레드 실행
     */
    public void run() {
        // 수신 메시지 처리를 위한 변수
        String msg;

        //status 업데이트
        status = true;
        
        while(status) {
            try{
                // 메시지 수신
            	msg = inMsg.readLine();
                
                //메시지 파싱
                m = gson.fromJson(msg, Message.class);

                // MultiChatData 객체를 통해 데이터 갱신
                chatData.refreshData(m.getId() + ">" + m.getMsg() + "\n");

                // 커서를 현재 대화 메시지에 보여줌
                v.msgOut.setCaretPosition(v.msgOut.getDocument().getLength());
            }
            catch(IOException e) {
                logger.log(WARNING,"[MultiChatUI]메시지 스트림 종료!!");
            }
        }
        logger.info("[MultiChatUI]" + thread.getName()+ " 메시지 수신 스레드 종료됨!!");
    }


    // 프로그램 시작을 위한 메인 메서드
    public static void main(String[] args) {
    	//MultiChatController 객체생성 및 appMain() 실행
    	MultiChatController multichatcontroller = new MultiChatController(new MultiChatData(), new MultiChatUI());
    	multichatcontroller.appMain();
    }
}
