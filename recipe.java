package willschull.whattoeat;

public class recipe {

    int points;
    String cost;
    String name;
    //String difficulty; Easy, medium, hard
    //int time; Time to cook
    //boolean marinade;
    //int servingSize;
    //String[] ingredients;

    public recipe(int points, String cost, String name) {
        this.points = points;
        this.cost = cost;
        this.name = name;
    }
    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    /*
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    */
}
