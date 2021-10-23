package mini;

public class RecipeDTO {
	private String recipeName;
	private String id;
	private String category;
	private String recipeDetail;
	private String recipeImg;
	
	public String getRecipeName() {
		return recipeName;
	}
	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getRecipeDetail() {
		return recipeDetail;
	}
	public void setRecipeDetail(String recipeDetail) {
		this.recipeDetail = recipeDetail;
	}
	public String getRecipeImg() {
		return recipeImg;
	}
	public void setRecipeImg(String recipeImg) {
		this.recipeImg = recipeImg;
	}
	
    @Override
    public String toString() {
      return recipeName;
    }

}
