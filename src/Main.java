import java.util.Random;

public class Main {
    public static void main(String[] args) {
        TesteFuncoes();
        //TesteEficiencia();
    }

    private static void TesteFuncoes() {
        HashTable hashTable = new HashTable(10);

        Node no1 = new Node(10, "matricula1");
        Node no2 = new Node(20,"matricula2");
        Node no3 = new Node(30, "matricula3");
//        Node no4 = new Node("key4","matricula4");

        hashTable.inserirComSondagemLinear(no1);
//        hashTable.inserirComEncadeamentoSeparado(no2);
//        hashTable.inserirComEncadeamentoSeparado(no2);
//        hashTable.inserirComEncadeamentoSeparado(no3);
        hashTable.inserirComSondagemLinear(no2);
        hashTable.inserirComSondagemLinear(no3);


        // Exemplo de busca
        Node buscaNo1 = hashTable.buscar(10);
//        Node buscaNo2 = hashTable.buscar("key2");

        if (buscaNo1 != null) {
            System.out.println("Node encontrado com a chave " + buscaNo1.getChave() + ": "+ buscaNo1);
        } else {
            System.out.println("Nenhum nó encontrado com a chave 1.");
        }

//        if (buscaNo2 != null) {
//            System.out.println("Node encontrado com a chave " + buscaNo2.getChave() + ": "+ buscaNo2);
//        } else {
//            System.out.println("Nenhum nó encontrado com a chave 'key3'.");
//        }

        Node removerNo1 = hashTable.remover(10);
        if (removerNo1 != null) {
            System.out.println("Nó removido com sucesso: " + removerNo1);
        } else {
            System.out.println("Nenhum nó encontrado com a chave 1 para remover.");
        }

        System.out.println(hashTable.buscar(20));
    }

    private static void TesteEficiencia() {
        HashTable hashTableLinear = new HashTable(10);
        HashTable hashTableSeparada = new HashTable(10);

        Node no1 = new Node(1, "matricula1");
        Node no2 = new Node("key2", "matricula2");
        Node no3 = new Node("key3", "matricula3");
        Node no4 = new Node("key4", "matricula4");

        hashTableLinear.inserirComSondagemLinear(no1);
        hashTableSeparada.inserirComEncadeamentoSeparado(no2);
        hashTableSeparada.inserirComEncadeamentoSeparado(no2);
        hashTableSeparada.inserirComEncadeamentoSeparado(no3);
        hashTableLinear.inserirComSondagemLinear(no3);
        hashTableLinear.inserirComSondagemLinear(no4);

        Random random = new Random();
        long tempoLinear = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            int chaveRandom = random.nextInt(5) + 1;
            hashTableLinear.buscar(chaveRandom);
        }
        long fimTempoLinear = System.nanoTime();
        double duracaoLinear = (fimTempoLinear - tempoLinear) / 1_000_000_000.0;

        long tempoSeparado = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            int chaveRandom = random.nextInt(5) + 1;
            hashTableSeparada.buscar(chaveRandom);
        }
        long fimTempoSeparado = System.nanoTime();
        double duracaoSeparado = (fimTempoSeparado - tempoSeparado) / 1_000_000_000.0;

        System.out.println("Tempo de busca com sondagem linear: " + duracaoLinear + " segundos");
        System.out.println("Tempo de busca com encadeamento separado: " + duracaoSeparado + " segundos");
    }

}
