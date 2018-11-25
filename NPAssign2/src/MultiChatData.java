import javax.swing.*;

public class MultiChatData {
    // 데이터 제공 객체
    JTextArea msgOut;

    /**
     * JComponent 객체를 파라미터로 받아 데이터 변화에 대응 처리
     * 현재 구현은 단일 클래스로만 되어 있으나 리스트나 맵 형태로 운영할 수 있음.
     * @param comp
     */
    public void addObj(JComponent comp) {
        this.msgOut = (JTextArea)comp;
    }

    /**
     * 데이터 변화가 발생했을때 UI 에 데이터 변경을 반영하기 위한 메서드
     * @param msg
     */
    public void refreshData(String msg) {
        // JTextArea 에 수신된 메시지 추가
        msgOut.append(msg);
    }
}
