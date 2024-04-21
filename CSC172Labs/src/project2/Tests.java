package project2;

import java.io.FileNotFoundException;
import java.util.Arrays;

public class Tests {

    SurveyDataAnalyzer analyzer; 

    public static void main(String[] args) throws FileNotFoundException {
        Tests testInstance = new Tests();
        testInstance.analyzer = new SurveyDataAnalyzer(ReadFile.readResponsesFromFile("src/project2/responses.txt"));
        System.out.println("Testing method 1:");
        int[] test1 = testInstance.analyzer.genderDistribution(); // Call the method to get the test results
        int[] result1 = new int[]{160, 138, 1, 1};
        boolean isEqual = Arrays.equals(test1, result1);
        System.out.println("Test result matches expected result: " + isEqual);

        System.out.println("Testing method 2:");
        int[] test2 = testInstance.analyzer.ageGroupDistribution(); // Call the method to get the test results
        int[] result2 = new int[]{38, 86, 92, 84};
        boolean isEqual2 = Arrays.equals(test2, result2);
        System.out.println("Test result matches expected result: " + isEqual2);

        System.out.println("Testing method 3:");
        int[] test3 = testInstance.analyzer.residenceDistribution(); // Call the method to get the test results
        int[] result3 = new int[]{50, 90, 112, 48};
        boolean isEqual3 = Arrays.equals(test3, result3);
        System.out.println("Test result matches expected result: " + isEqual3);

        System.out.println("Testing method 4:");
        int[] test4 = testInstance.analyzer.educationDistribution(); // Call the method to get the test results
        int[] result4 = new int[]{26, 82, 114, 78};
        boolean isEqual4 = Arrays.equals(test4, result4);
        System.out.println("Test result matches expected result: " + isEqual4);

        System.out.println("Testing method 5:");
        int[] test5 = testInstance.analyzer.incomeDistribution(); // Call the method to get the test results
        int[] result5 = new int[]{174, 56, 38, 32};
        boolean isEqual5 = Arrays.equals(test5, result5);
        System.out.println("Test result matches expected result: " + isEqual5);

        System.out.println("Testing method 6:");
        int[] test6 = testInstance.analyzer.maritalDistribution(); // Call the method to get the test results
        int[] result6 = new int[]{58, 160, 46, 36};
        boolean isEqual6 = Arrays.equals(test6, result6);
        System.out.println("Test result matches expected result: " + isEqual6);

        System.out.println("Testing method 7:");
        int[] test7 = testInstance.analyzer.smokerDistribution(); // Call the method to get the test results
        int[] result7 = new int[]{112, 188};
        boolean isEqual7 = Arrays.equals(test7, result7);
        System.out.println("Test result matches expected result: " + isEqual7);


        System.out.println("Testing method 8:");
        double test8 = testInstance.analyzer.lifeQualityGeneral(); // Call the method to get the test results
        double result8 = 29.303333333333335;
        System.out.print("Test result matches expected result: ");
        System.out.println(test8==result8);


        System.out.println("Testing method 9:");
        double[] test9 = testInstance.analyzer.lifeQualityGenderBased(); // Call the method to get the test results
        double[] result9 = new double[]{30.85625, 27.420289855072465, 37.0, 33.0};
        boolean isEqual9 = Arrays.equals(test9, result9);
        System.out.println("Test result matches expected result: " + isEqual9);

        System.out.println("Testing method 10:");
        double[] test10 = testInstance.analyzer.lifeQualityAgeBased(); // Call the method to get the test results
        double[] result10 = new double[]{19.86842105263158, 23.209302325581394, 31.77173913043478, 37.107142857142854};
        boolean isEqual10 = Arrays.equals(test10, result10);
        System.out.println("Test result matches expected result: " + isEqual10);


        System.out.println("Testing method 11:");
        double[] test11 = testInstance.analyzer.lifeQualityResidenceBased(); // Call the method to get the test results
        double[] result11 = new double[]{34.4, 29.0, 28.607142857142858, 26.1875};
        boolean isEqual11 = Arrays.equals(test11, result11);
        System.out.println("Test result matches expected result: " + isEqual11);

        System.out.println("Testing method 12:");
        double[] test12 = testInstance.analyzer.lifeQualityEducationBased(); // Call the method to get the test results
        double[] result12 = new double[]{36.46153846153846, 33.19512195121951, 28.18421052631579, 24.46153846153846};
        boolean isEqual12 = Arrays.equals(test12, result12);
        System.out.println("Test result matches expected result: " + isEqual12);

        System.out.println("Testing method 13:");
        double[] test13 = testInstance.analyzer.lifeQualityIncomeBased(); // Call the method to get the test results
        double[] result13 = new double[]{25.114942528735632, 38.55357142857143, 35.13157894736842, 28.96875};
        boolean isEqual13 = Arrays.equals(test13, result13);
        System.out.println("Test result matches expected result: " + isEqual13);

        System.out.println("Testing method 14:");
        double[] test14 = testInstance.analyzer.lifeQualityMaritalBased(); // Call the method to get the test results
        double[] result14 = new double[]{20.310344827586206, 30.875, 30.369565217391305, 35.44444444444444};
        boolean isEqual14 = Arrays.equals(test14, result14);
        System.out.println("Test result matches expected result: " + isEqual14);

        System.out.println("Testing method 15:");
        double[] test15 = testInstance.analyzer.lifeQualitySmokerBased(); // Call the method to get the test results
        double[] result15 = new double[]{31.21808510638298, 26.089285714285715};
        boolean isEqual15 = Arrays.equals(test15, result15);
        System.out.println("Test result matches expected result: " + isEqual15);


        System.out.println("Testing method 16:");
        String[] test16 = testInstance.analyzer.mostCommonTreatment(); // Call the method to get the test results
        String[] result16 = new String[]{"Chemotherapy", "Surgical","Radiotherapy", "Immunotherapy", "MolecularlyTargetedTherapy"};
        boolean isEqual16 = Arrays.equals(test16, result16);
        System.out.println("Test result matches expected result: " + isEqual16);

        System.out.println("Testing method 17:");
        String[] test17 = testInstance.analyzer.mostCommonSymptoms(); // Call the method to get the test results
        String[] result17 = new String[]{"Weakness","Cough", "None", "ShortnessOfBreath", "ChestPain", "Hoarseness", "CoughingUpBlood" };
        boolean isEqual17 = Arrays.equals(test17, result17);
        System.out.println("Test result matches expected result: " + isEqual17);

        System.out.println("Testing method 18:");
        String[] test18 = testInstance.analyzer.mostCommonLifeAspects(); // Call the method to get the test results
        String[] result18 = new String[]{"PsychologicalAspect", "PhysicalAspect", "DoesNotAffect", "ProfessionalLife", "FamilyLife", "SocialLife"};
        boolean isEqual18 = Arrays.equals(test18, result18);
        System.out.println("Test result matches expected result: " + isEqual18);


        System.out.println("Testing method 19:");
        double[] test19 = testInstance.analyzer.lifeQualityMixConditionsBased(); // Call the method to get the test results
        double[] result19 = new double[]{15.928571428571429, 33.24285714285714};
        boolean isEqual19 = Arrays.equals(test19, result19);
        System.out.println("Test result matches expected result: " + isEqual19);

        System.out.println("Testing method 20:");
        double[] test20 = testInstance.analyzer.lifeQualityResponseBased(); // Call the method to get the test results
        double[] result20 = new double[]{14.222222222222221, 20.87837837837838, 32.3739837398374, 41.07462686567164};
        boolean isEqual20 = Arrays.equals(test20, result20);
        System.out.println("Test result matches expected result: " + isEqual20);





    }
}

