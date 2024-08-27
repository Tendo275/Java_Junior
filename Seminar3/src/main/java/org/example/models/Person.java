package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Person implements Externalizable {
    private int id;
    private String name;
    private int age;

    @Override
    public String toString() {
        return id + " " + name + " " + age;
    }

    // region implementation Externalizable
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(id);
        out.writeUTF(name);
        out.writeInt(age);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        id = in.readInt();
        name = in.readUTF();
        age = in.readInt();
    }
    // endregion
}
