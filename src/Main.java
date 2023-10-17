public class Main {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable(10);

        Node no1 = new Node(1, "matricula1");
        Node no2 = new Node("key2","matricula2");
        Node no3 = new Node("key3","matricula3");
        Node no4 = new Node("key4","matricula4");

        hashTable.inserirComSondagemLinear(no1);
        hashTable.inserirComEncadeamentoSeparado(no2);
        hashTable.inserirComEncadeamentoSeparado(no2);
        hashTable.inserirComEncadeamentoSeparado(no3);
        hashTable.inserirComSondagemLinear(no3);
        hashTable.inserirComSondagemLinear(no4);


        // Exemplo de busca
        Node buscaNo1 = hashTable.buscar(1);
        Node buscaNo2 = hashTable.buscar("key2");

        if (buscaNo1 != null) {
            System.out.println("Node encontrado com a chave " + buscaNo1.getChave() + ": "+ buscaNo1);
        } else {
            System.out.println("Nenhum nó encontrado com a chave 1.");
        }

        if (buscaNo2 != null) {
            System.out.println("Node encontrado com a chave " + buscaNo2.getChave() + ": "+ buscaNo2);
        } else {
            System.out.println("Nenhum nó encontrado com a chave 'key3'.");
        }

        Node removerNo1 = hashTable.remover(1);
        if (removerNo1 != null) {
            System.out.println("Nó removido com sucesso: " + removerNo1);
        } else {
            System.out.println("Nenhum nó encontrado com a chave 1 para remover.");
        }
    }
}