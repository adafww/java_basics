public class Printer {

    private String queue = "";

    private int totalPage = 0;
    private int totalDoc = 0;
    private int totalPrintPage = 0;

    public void append(String text) { append(text, "Новый документ", 1);}

    public void append(String text, String name) { append(text, name, 1); }

    public void append(String text, String name, int page) {

        queue = queue + name + " - содержание: " + text + " - " + page + " стр.\n";
        totalPage = totalPage + page;
        totalDoc = ++totalDoc;

    }

    public void print(){
        System.out.println(queue);
        totalPrintPage = totalPrintPage + totalPage;
        if (queue.isEmpty()) {
            System.out.println("Нечего печатать!");
        } else {
            System.out.println(queue);
        }
    }

    public void clear(){
        queue = "";
    }

    public void getPagesCount(){
        System.out.println("Общее количество страниц добавленных в принтер: " + totalPage);
    }

    public void getDocumentCount(){
        System.out.println("Общее количество документов добавленных в принтер: "+ totalDoc );
    }

    public void getTotalPageCount(){
        System.out.println("Общее количетсво напечатанных страниц: " + totalPrintPage);
    }
}
