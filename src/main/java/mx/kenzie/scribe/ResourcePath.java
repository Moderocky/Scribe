package mx.kenzie.scribe;

public interface ResourcePath {

    static ResourcePath of(String key) {
        return new Simple("minecraft", key);
    }

    static ResourcePath of(String namespace, String key) {
        return new Simple(namespace, key);
    }

    String namespace();

    String key();

}

record Simple(String namespace, String key) implements ResourcePath {

}
