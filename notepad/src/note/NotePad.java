package note;


import java.util.Scanner;

public class NotePad {

    private int noteLength = 0;
    private final NoteEntity[] noteEntities;
    private final int NOTE_SIZE = 20;

    public NotePad() {
        this.noteEntities = new NoteEntity[NOTE_SIZE];
    }

    public void addNote() {
        System.out.println("");
        if (NOTE_SIZE == this.noteLength) {
            System.out.println("메모가 꽉찼습니다");
            System.out.println("");
            return;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("제목을 작성해주세요");
        String title = scanner.nextLine();

        System.out.println("본문을 작성해주세요");
        String content = scanner.nextLine();

        noteEntities[this.noteLength++] =
                NoteEntity.newInstance(title, content);

        System.out.println("메모가 작성되었습니다");
        System.out.println("");
    }

    public void printALLNotes() {
        System.out.println("");
        if (0 == this.noteLength) {
            System.out.println("작성된 메모가 없습니다.");
            System.out.println("");
            return;
        }
        for (int i = 0; i < this.noteLength; i++) {
            NoteEntity noteEntity = noteEntities[i];

            String headline = String.format("번호:%d 제목:%s, " +
                            "작성날짜:%s", i, noteEntity.getTitle(),
                    noteEntity.getLastUpdatedDatetime());

            System.out.println(headline);
        }
        System.out.println("");
    }

    public void printNote() {
        System.out.println("");
        Scanner scanner = new Scanner(System.in);
        System.out.println("활인할 메모의 번호를 입력해주세요");
        int selectedNumber = scanner.nextInt();
        NoteEntity noteEntity = noteEntities[selectedNumber];
        if (null == noteEntity) {
            System.out.println("작성된 메모가 없습니다.");
            System.out.println("");
            return;
        }
        System.out.println("");
        String headline = String.format("번호:%d 제목:%s",
                noteLength, noteEntity.getTitle());
        System.out.println(headline);
        System.out.println(noteEntity.getLastUpdatedDatetime());
        System.out.println(noteEntity.getContent());
        System.out.println("");
    }

    public void updateNote() {
        System.out.println("");
        Scanner scanner = new Scanner(System.in);
        System.out.println("수정하실 메모의 번호를 입력해주세요.");
        int selectedNumber = Integer.parseInt((scanner.nextLine()));

        System.out.println("본문을 작성해주세요");
        String content = scanner.nextLine();

        NoteEntity noteEntity = noteEntities[selectedNumber];
        if (null == noteEntity) {
            System.out.println("존재하지 않는 메모입니다");
            return;
        }

        noteEntity.update(content);

        System.out.println("메모가 수정되었습니다");
        System.out.println("");
    }
}
