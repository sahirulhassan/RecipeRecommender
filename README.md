**RecipeRecommender**

A recipe recommender application that suggests recipes based on user-entered ingredients. This project utilizes the Java Tablesaw library for data manipulation and analysis.

**Features**

- **Ingredient-Based Recommendations**: Input ingredients you have and receive a list of possible recipes you can make.
- **Data Analysis**: Leverages Tablesaw for efficient data handling and analysis.

**Installation**

**1\. Clone the Repository**

>git clone <https://github.com/sahirulhassan/RecipeRecommender.git>  
>cd RecipeRecommender  

**2\. Download the Dataset**

- Download the dataset from Google Drive: **_<https://drive.google.com/file/d/1BKDBuh5TJewQLA9vxw0W9i3y00PW2uBV/view?usp=sharing>_**
- Unzip the dataset file.
- Place the unzipped dataset into the src/main/resources folder:

**3\. Fix File Location Errors (if needed)**

If you encounter file location errors when running the application:

- Open the code file that loads the dataset (likely located in src/main/java).
- Update the dataset path to match the correct location:

**4\. Build the Project**

Ensure you have [Gradle](https://gradle.org/) installed, then run:

>gradle build

**Usage**

1. **Run the Application**:

>gradle run

1. **Input Ingredients**:
    - Follow the on-screen prompts to enter the ingredients you have.
2. **Receive Recipe Suggestions**:
    - The application will display a list of recipes you can prepare with the provided ingredients.

**Dependencies**

- **Java**: Ensure you have Java installed on your system.
- **Tablesaw**: A Java library for data manipulation and visualization.

**Contributing**

Contributions are welcome! Here's how you can help:

1. Fork the repository.
2. Create a new branch for your feature or fix.
3. Submit a pull request once your changes are ready for review.

**License**

This project is licensed under the MIT License.
