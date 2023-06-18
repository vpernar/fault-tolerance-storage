package rs.raf;

import lombok.AllArgsConstructor;
import lombok.Data;
import rs.raf.exceptions.SerializationException;

import java.io.*;

@Data
@AllArgsConstructor
public class Connection implements Serializable{
    private String ipAddress;
    private Integer port;

    public static byte[] serialize(Connection rpcConnection) {
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
             ObjectOutputStream out = new ObjectOutputStream(bos)) {
            out.writeObject(rpcConnection);
            return bos.toByteArray();
        } catch (IOException e) {
            throw new SerializationException(e.getMessage());
        }
    }

    public static Connection deserialize(byte[] data) {
        try (ByteArrayInputStream bis = new ByteArrayInputStream(data);
             ObjectInputStream in = new ObjectInputStream(bis)) {
            return (Connection) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new SerializationException(e.getMessage());
        }
    }
}
