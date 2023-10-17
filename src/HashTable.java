import java.util.LinkedList;

public class HashTable {
    private int capacidade;
    private int tamanho;
    private LinkedList<Node>[] tabela;

    public HashTable(int capacidade) {
        this.capacidade = capacidade;
        this.tamanho = 0;
        this.tabela = new LinkedList[capacidade];
        for (int i = 0; i < capacidade; i++) {
            tabela[i] = new LinkedList<>();
        }
    }

    private int hash(int chave) {
        return chave % capacidade;
    }

    private int hash(String chave) {
        int soma = 0;
        for (char c : chave.toCharArray()) {
            soma += (int) c;
        }
        return soma % capacidade;
    }

    private void encadeamentoSeparado(Node no, int index) {
        if (tabela[index] == null) {
            tabela[index] = new LinkedList<>();
        }
        tabela[index].add(no);
        tamanho++;
    }

    public void inserirComEncadeamentoSeparado(Node no) {
        int index;
        if (no.getChave() instanceof Integer) {
            index = hash((int) no.getChave());
            encadeamentoSeparado(no, index);
        } else {
            index = hash((String) no.getChave());
            encadeamentoSeparado(no, index);
        }
    }

    private int sondagemLinear(int chave, int tentativa) {
        return (hash(chave) + tentativa) % capacidade;
    }

    private int sondagemLinear(String chave, int tentativa) {
        return (hash(chave) + tentativa) % capacidade;
    }

    public void inserirComSondagemLinear(Node no) {
        int index;
        if (no.getChave() instanceof Integer) {
            index = hash((int) no.getChave());
            int tentativa = 0;
            int hashIndex = index;
            while (tabela[hashIndex] != null && !tabela[hashIndex].isEmpty() && tentativa < capacidade) {
                hashIndex = sondagemLinear((int) no.getChave(), tentativa);
                tentativa++;
            }
            if (tentativa < capacidade) {
                if (tabela[hashIndex] == null) {
                    tabela[hashIndex] = new LinkedList<>();
                }
                tabela[hashIndex].add(no);
                tamanho++;
            } else {
                System.out.println("Não foi possível inserir o nó com sondagem linear. A tabela está cheia.");
            }
        } else if (no.getChave() instanceof String) {
            index = hash((String) no.getChave());
            int tentativa = 0;
            int hashIndex = index;
            while (tabela[hashIndex] != null && !tabela[hashIndex].isEmpty() && tentativa < capacidade) {
                hashIndex = sondagemLinear((String) no.getChave(), tentativa);
                tentativa++;
            }
            if (tentativa < capacidade) {
                if (tabela[hashIndex] == null) {
                    tabela[hashIndex] = new LinkedList<>();
                }
                tabela[hashIndex].add(no);
                tamanho++;
            } else {
                System.out.println("Não foi possível inserir o nó com sondagem linear. A tabela está cheia.");
            }
        }
    }



    public Node buscar(int chave) {
        int index = hash(chave);
        for (Node node : tabela[index]) {
            if (node.getChave() instanceof Integer && (int) node.getChave() == chave) {
                return node;
            }
        }
        return null;
    }

    public Node buscar(String chave) {
        int index = hash(chave);
        for (Node node : tabela[index]) {
            if (node.getChave() instanceof String && ((String) node.getChave()).equals(chave)) {
                return node;
            }
        }
        return null;
    }

    public Node remover(int chave) {
        int index = hash(chave);
        for (Node node : tabela[index]) {
            if (node.getChave() instanceof Integer && (int) node.getChave() == chave) {
                tabela[index].remove(node);
                tamanho--;
                return node;
            }
        }
        return null;
    }

    public Node remover(String chave) {
        int index = hash(chave);
        for (Node node : tabela[index]) {
            if (node.getChave() instanceof String && ((String) node.getChave()).equals(chave)) {
                tabela[index].remove(node);
                tamanho--;
                return node;
            }
        }
        return null;
    }
}
