package project2;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile 
{
    public static CustomHashTable readResponsesFromFile(String filePath) throws FileNotFoundException
    {
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);
        CustomHashTable table = new CustomHashTable();

        // table.printHT();
        // System.out.println(table.getSize());
        // System.out.println("END OF THE THIGN\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

        while(scanner.hasNextLine())
        {
            // System.out.println("THIS IS A LINE: " + scanner.nextLine() + "\n\n\n");
            Response newRes = new Response();

            //assigning the ID
            int id = scanner.nextInt();
            newRes.setId(id);
            
            //assigning the gender
            int gender = scanner.nextInt();
            switch (gender) 
            {
                case 1:
                    newRes.setGender("F");
                    break;
                case 2:
                    newRes.setGender("M");
                    break;
                case 3:
                    newRes.setGender("O");
                    break;
                case 4:
                    newRes.setGender("-");
                    break;
                default:
                    newRes.setGender("VERY UNCLEAR");
                    break;
            }

            //assigning the age
            newRes.setAge(scanner.nextInt());

            //assigning the residence
            newRes.setResidence(scanner.nextInt());

            //assigning the education
            newRes.setEducation(scanner.nextInt());

            //assigning the IncomeSource
            newRes.setIncomeSource(scanner.nextInt());

            //assigning the MaritalStatus
            newRes.setMaritalStatus(scanner.nextInt());

            //assigning the Smoker
            newRes.setSmoker(scanner.nextInt());

            //assigning the Year
            newRes.setYear(scanner.nextInt());

            //assigning the Q9
            newRes.setQ9(scanner.next());

            //assigning the Q10
            newRes.setQ10(scanner.nextInt());

            //assigning the Q11
            newRes.setQ11(scanner.nextInt());

            //assigning the Q12
            newRes.setQ12(scanner.nextInt());

            //assigning the Q13
            newRes.setQ13(scanner.nextInt());

            //assigning the Q14
            newRes.setQ14(scanner.nextInt());

            //assigning the Q15
            newRes.setQ15(scanner.nextInt());

            //assigning the Q16
            newRes.setQ16(scanner.next());

            //assigning the Q17
            newRes.setQ17(scanner.nextInt());

            //assigning the Q18
            newRes.setQ18(scanner.nextInt());

            //assigning the Q19
            newRes.setQ19(scanner.nextInt());

            //assigning the Q20
            newRes.setQ20(scanner.nextInt());

            //assigning the Q21
            newRes.setQ21(scanner.nextInt());

            //assigning the Q22
            newRes.setQ22(scanner.nextInt());

            //assigning the Q23
            newRes.setQ23(scanner.next());

            //assigning the Q24
            newRes.setQ24(scanner.nextInt());

            //assigning the Q25
            newRes.setQ25(scanner.nextInt());

            //assigning the Q26
            newRes.setQ26(scanner.nextInt());

            //assigning the Q27
            newRes.setQ27(scanner.nextInt());

            //assigning the Q28
            newRes.setQ28(scanner.nextInt());

            // System.out.println("BEEPBEEPBEEP: " + newRes.getQ28());
            //assigning the Q29
            newRes.setQ29(scanner.nextInt());

            //assigning the Q30
            newRes.setQ30(scanner.nextInt());

            //assigning the Quality
            //TODO: hav to calculate quality!!!
            newRes.setQuality(
                newRes.getQ13() + newRes.getQ14() + newRes.getQ15() 
                + newRes.getQ17() + newRes.getQ18() + newRes.getQ19() 
                + newRes.getQ21() + newRes.getQ22()
                + newRes.getQ24() + newRes.getQ25() + newRes.getQ26()
                + newRes.getQ27() + newRes.getQ28() + newRes.getQ29()
                + newRes.getQ30()
            );

            //adding the new response to the hash table
            table.insert(newRes.getId(), newRes);
        }
        scanner.close();
        return table;
        
    }

    public static void main(String[] args)
    {
        try {
            CustomHashTable table = readResponsesFromFile("src/project2/responses.txt");
            table.printHT();
            System.out.println(table.getSize());
            SurveyDataAnalyzer analyzer = new SurveyDataAnalyzer(table);
            int[] arr = analyzer.genderDistribution();
            System.out.println(arr[0]);
            System.out.println(arr[1]);
            System.out.println(arr[2]);
            System.out.println(arr[3]);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            System.out.println("we in the error block");
            e.printStackTrace();
        }
    }
}
