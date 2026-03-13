public class Diamond {
    private String id;
    private String carat;
    private String cut;
    private String color;
    private String clarity;
    private String depth;
    private String table;
    private double price;
    private String x;
    private String y;
    private String z;

    public Diamond(String id, String carat, String cut, String color, String clarity, String depth, String table, String price, String x, String y, String z) {
        this.id = id;
        this.carat = carat;
        this.cut = cut;
        this.color = color;
        this.clarity = clarity;
        this.depth = depth;
        this.table = table;
        this.price = Double.parseDouble(price);
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public String getId() {
        return id;
    }

    public String getCarat() {
        return carat;
    }

    public String getCut() {
        return cut;
    }

    public String getClarity() {
        return clarity;
    }

    public String getDepth() {
        return depth;
    }

    public String getTable() {
        return table;
    }

    public String getZ() {
        return z;
    }

    public String getY() {
        return y;
    }

    public String getX() {
        return x;
    }

    public Double getPrice() {
        return price;
    }

    public String getColor() {
        return color;
    }


}
