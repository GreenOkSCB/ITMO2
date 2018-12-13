package patterns.builder;

public class NutritionFacts {
    private final int servings; // обязательный атрибут
    private final int calories; // дополнительный атрибут
    private final int fat; // дополнительный атрибут


    public static class Builder {
        private final int servings;// обязательный атрибут
        private int calories = 0;// дополнительный атрибут
        private int fat = 0;// дополнительный атрибут


        public Builder(int servings){
            this.servings = servings;
        }

        public Builder setCalories(int calories) {
            this.calories = calories;
            return this;

        }

        public Builder setFat(int fat) {
            this.fat = fat;
            return this;
        }

        public NutritionFacts build(){
            return new NutritionFacts(this);
        }

//        public Builder calories(int val){
//            calories = val;
//            return this;
//        }
//
//        public Builder fat(int val){
//            fat = val;
//            return this;
//        }

    }

    private NutritionFacts(Builder builder){
        servings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;
    }

    public static void main(String[] args) {
        NutritionFacts beaf = new Builder(10)
                .setCalories(898)
                .setFat(45)
                .build();
        NutritionFacts cocacola = new Builder(3)
                .setCalories(456)
                .setFat(22)
                .build();
    }
}
