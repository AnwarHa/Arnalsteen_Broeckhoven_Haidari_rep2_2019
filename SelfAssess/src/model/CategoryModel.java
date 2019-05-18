package model;

public class CategoryModel {
    private String name, description;

    public String getName() {
        return name;
    }

    protected void setName(String name) {
        if(name.isEmpty()||name.equals("")){
            throw new DomainException("name can't be empty");
        }
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    protected void setDescription(String description) {
        this.description = description;
    }
}
