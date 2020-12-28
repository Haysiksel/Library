package io.github.haysiksel;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

import org.jetbrains.annotations.NotNull;

public class MongoHandler implements DatabaseHandler<MongoClient> {

    private final MongoClient client;

    public MongoHandler()  {
        this.client = new MongoClient(new MongoClientURI(LibraryMain.getInstance().getConfig().getString("database.mongo-db.uri")));
    }

    @Override
    public @NotNull MongoClient get() {
        return client;
    }

    @Override
    public boolean isConnected() {
        return client.getAddress() == null;
    }

    @Override
    public @NotNull String getName() {
        return "Mongo Database";
    }

    @Override
    public void shutdown() {
        client.close();
    }
}
