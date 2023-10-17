public class Node {
    private Object chave;
    private int id;
    private String matricula;

    public Node(int id, String matricula) {
        this.id = id;
        this.matricula = matricula;
        this.chave = id;
    }

    public Node(String chave, String matricula) {
        this.matricula = matricula;
        this.chave = chave;
    }

    public Object getChave() {
        return chave;
    }
}