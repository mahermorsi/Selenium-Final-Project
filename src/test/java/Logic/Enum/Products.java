package Logic.Enum;

public enum Products{
    OIL("357141"),
    CART("164854"),
    TEA("377697"),
    FINISH("397941"),
    CHEESE("334778");
    private final String id;

    Products(String id) {
        this.id=id;
    }

    public String getId() {
        return id;
    }
}
