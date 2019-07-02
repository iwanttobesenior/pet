package training.patterns.proxy.defensive;

public class PersonImpl implements Person {

    private String name;
    private String gender;
    private String interests;
    private int rating;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getGender() {
        return gender;
    }

    @Override
    public String getInterests() {
        return interests;
    }

    @Override
    public int getRating() {
        return rating;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public void setInterests(String interests) {
        this.interests = interests;
    }

    @Override
    public void setRating(int rating) {
        this.rating += rating;
    }
}
