package FunctionalInterface;

class PrototypeModel implements Cloneable {

    String modelName;
    int version;

    public PrototypeModel(String modelName, int version) {
        this.modelName = modelName;
        this.version = version;
    }

    public PrototypeModel cloneModel() {
        try {
            return (PrototypeModel) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Cloning not supported!");
        }
    }

    @Override
    public String toString() {
        return "PrototypeModel{modelName='" + modelName + "', version=" + version + "}";
    }
}

public class CloningPrototypeObjects {
    public static void main(String[] args) {

        PrototypeModel original = new PrototypeModel("CarEngine", 1);

        PrototypeModel copy = original.cloneModel();

        System.out.println("Original: " + original);
        System.out.println("Copy:     " + copy);
    }
}

