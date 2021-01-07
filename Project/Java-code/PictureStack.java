package com.example.pateldhirspeedywords;

public class PictureStack {
    //Instance variables
    private int count;
    //Object array created
    private Picture data[] = new Picture[27];

    public PictureStack() {
        shuffle();
    }

    public void shuffle() {
        //Array created for the picnum instance variable
        int picnum[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27};
        //Array created for the categories instance variable
        String categories[] = {"PlantOrange", "PlantBlue", "PlantGreen", "ObjectOrange", "ObjectBlue", "ObjectGreen", "NameOrange", "NameBlue", "NameGreen", "MovieOrange", "MovieBlue", "MovieGreen", "FoodOrange", "FoodBlue", "FoodGreen", "FamousOrange", "FamousBlue", "FamousGreen", "CountryOrange", "CountryBlue", "CountryGreen", "CityOrange", "CityBlue", "CityGreen", "AnimalOrange", "AnimalBlue", "AnimalGreen"};
        //Randomizing the order of the arrays
        for (int i = 0; i < 100; i++) {
            int r1 = (int) (Math.random() * picnum.length);
            int r2 = (int) (Math.random() * picnum.length);
            //One swap for the picnum array
            int temp = picnum[r1];
            picnum[r1] = picnum[r2];
            picnum[r2] = temp;
            //One swap for the categories array
            String temp1 = categories[r1];
            categories[r1] = categories[r2];
            categories[r2] = temp1;
        }
        count = 0;
        //Push all (now in random order) into the Deck
        for (int i = 0; i < picnum.length; i++) {
            Picture c = new Picture(categories[i], picnum[i]);
            push(c);
        }
    }

    //This method pushes data into the deck
    public void push(Picture addMe) {
        data[count] = addMe;
        count++;
    }

    //This method gives the size fo the deck
    public int size() {
        return count;
    }

    //This method checks if the deck is full
    public boolean isFull() {
        return (count == 28);
    }

    //This pops off the top card from the deck
    public Picture pop() {
        count--;
        return data[count];
    }

    //This method looks at what the top card of the deck is
    public Picture peek() {
        return data[count--];
    }

    //This method checks if the deck is empty
    public boolean isEmpty() {
        return count == 0;
    }

    //This method clears the deck
    public void clear() {
        count = 0;
    }
}