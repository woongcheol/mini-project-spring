import usecase.NoteService;

public class Main {

    public static void main(String[] args) {
        NoteService noteService = new NoteService();
        // TODO : run 메서드가 호출되면 메모장 프로그램이 시작된다.
        noteService.run();
    }
}
