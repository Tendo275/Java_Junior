package org.example.servises;

import lombok.Getter;

import java.io.*;

@Getter
public class Configs implements Externalizable {
    private String url;
    private String username;
    private String password;

    private Configs() {
    }

    public static Configs getConfigs() {
        String PATH = "" +
                "src" + File.separator +
                "main" + File.separator +
                "resources" + File.separator +
                "config.json";

        return FileWorker.deserializeObject(PATH, Configs.class);
    }

    @Override
    public String toString() {
        return url + " " + username + " " + password;
    }

    // region implementation Externalizable
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(this.url);
        out.writeObject(this.username);
        out.writeObject(this.password);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        url = (String) in.readObject();
        username = (String) in.readObject();
        password = (String) in.readObject();
    }
    // endregion
}
