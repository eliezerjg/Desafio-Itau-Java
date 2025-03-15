package br.com.itau.transacoes.infra.database.fakedb;

public class MemoryDB {
    private static MemoryDB instance = null;

    public static MemoryDB getInstance(){
        if(instance == null){
            instance = new MemoryDB();
        }
        return instance;
    }
}
