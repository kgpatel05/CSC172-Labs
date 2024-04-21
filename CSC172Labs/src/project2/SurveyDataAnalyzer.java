package project2;

import java.util.Arrays;

public class SurveyDataAnalyzer 
{
//genderDistribution returns an array int[] of size 4 that counts the types of re- sponses to question 1.
    CustomHashTable table;
    public SurveyDataAnalyzer(CustomHashTable table)
    {
        this.table = table;
    }

    public int[] genderDistribution()
    {
        int[] genderDistribution = {0,0,0,0};
        for (int i = 0; i < table.getSize(); i++)
        {
            if(table.table[i] == null)
            {
                continue;
            }
            int gend = -1;
            switch (table.table[i].getValue().getGender()) {
                case "F":
                    gend = 1;
                    break;
                case "M":
                    gend = 2;
                    break;
                case "O":
                    gend = 3;
                    break;
                case "-":
                    gend = 4;
                    break;
                default:
                    break;
            }
            genderDistribution[gend - 1]++;
        }
        return genderDistribution;
    }

    public int[] ageGroupDistribution()
    {
        int[] ages = {0,0,0,0};
        for (int i = 0; i < table.getSize(); i++)
        {
            if(table.table[i] == null)
            {
                continue;
            }
            ages[table.table[i].getValue().getAge() - 1]++;
        }
        return ages;
    }    

    public int[] residenceDistribution()
    {
        int[] residence = {0,0,0,0};
        for (int i = 0; i < table.getSize(); i++)
        {
            if(table.table[i] == null)
            {
                continue;
            }
            residence[table.table[i].getValue().getResidence() - 1]++;
        }
        return residence;
    }    

    public int[] educationDistribution()
    {
        int[] education = {0,0,0,0};
        for (int i = 0; i < table.getSize(); i++)
        {
            if(table.table[i] == null)
            {
                continue;
            }
            education[table.table[i].getValue().getEducation() - 1]++;
        }
        return education;
    }

    public int[] incomeDistribution()
    {
        int[] income = {0,0,0,0};
        for (int i = 0; i < table.getSize(); i++)
        {
            if(table.table[i] == null)
            {
                continue;
            }
            income[table.table[i].getValue().getIncomeSource() - 1]++;
        }
        return income;
    }

    public int[] maritalDistribution()
    {
        int[] maritial = {0,0,0,0};
        for (int i = 0; i < table.getSize(); i++)
        {
            if(table.table[i] == null)
            {
                continue;
            }
            maritial[table.table[i].getValue().getMaritalStatus() - 1]++;
        }
        return maritial;
    }

    public int[] smokerDistribution()
    {
        int[] smoker = {0,0};
        for (int i = 0; i < table.getSize(); i++)
        {
            if(table.table[i] == null)
            {
                continue;
            }
            smoker[table.table[i].getValue().getSmoker()]++;
        }
        return smoker;
    }

    public double lifeQualityGeneral()
    {
        double quality = 0;
        int j = 0;
        for (int i = 0; i < table.getSize(); i++)
        {
            if(table.table[i] == null)
            {
                continue;
            }
            quality += table.table[i].getValue().getQuality();
            j++;
        }
        return quality / j;
    }


    public double[] lifeQualityGenderBased()
    {
        double[] quality = {0,0,0,0};
        int F = 0, M = 0, O = 0, unknown = 0;
        for (int i = 0; i < table.getSize(); i++)
        {
            if(table.table[i] == null)
            {
                continue;
            }
            int gend = -1;
            switch (table.table[i].getValue().getGender()) {
                case "F":
                    gend = 0;
                    F++;
                    break;
                case "M":
                    gend = 1;
                    M++;
                    break;
                case "O":
                    gend = 2;
                    O++;
                    break;
                case "-":
                    gend = 3;
                    unknown++;
                    break;
                default:
                    break;
            }
            quality[gend] += table.table[i].getValue().getQuality();
        }
        quality[0] = quality[0] / F;
        quality[1] = quality[1] / M;
        quality[2] = quality[2] / O;
        quality[3] = quality[3] / unknown;
        return quality;
    }

    public double[] lifeQualityAgeBased()
    {
        double[] quality = {0,0,0,0};
        int youngest = 0, young = 0, older = 0, oldest = 0;
        for (int i = 0; i < table.getSize(); i++)
        {
            if(table.table[i] == null)
            {
                continue;
            }
            int ageGroup = -1;
            switch (table.table[i].getValue().getAge()) {
                case 1:
                    ageGroup = 0;
                    youngest++;
                    break;
                case 2:
                    ageGroup = 1;
                    young++;
                    break;
                case 3:
                    ageGroup = 2;
                    older++;
                    break;
                case 4:
                    ageGroup = 3;
                    oldest++;
                    break;
                default:
                    break;
            }
            quality[ageGroup] += table.table[i].getValue().getQuality();
            
        }
        quality[0] = quality[0] / youngest;
        quality[1] = quality[1] / young;
        quality[2] = quality[2] / older;
        quality[3] = quality[3] / oldest;
        return quality;
    }
    
    public double[] lifeQualityResidenceBased()
    {
        double[] quality = {0,0,0,0};
        int a = 0, b = 0, c = 0, d = 0;
        for (int i = 0; i < table.getSize(); i++)
        {
            if(table.table[i] == null)
            {
                continue;
            }
            int residence = -1;
            switch (table.table[i].getValue().getResidence()) {
                case 1:
                    residence = 0;
                    a++;
                    break;
                case 2:
                    residence = 1;
                    b++;
                    break;
                case 3:
                    residence = 2;
                    c++;
                    break;
                case 4:
                    residence = 3;
                    d++;
                    break;
                default:
                    break;
            }
            quality[residence] += table.table[i].getValue().getQuality();
            
        }
        quality[0] = quality[0] / a;
        quality[1] = quality[1] / b;
        quality[2] = quality[2] / c;
        quality[3] = quality[3] / d;
        return quality;
    }

    public double[] lifeQualityEducationBased()
    {
        double[] quality = {0,0,0,0};
        int a = 0, b = 0, c = 0, d = 0;
        for (int i = 0; i < table.getSize(); i++)
        {
            if(table.table[i] == null)
            {
                continue;
            }
            int education = -1;
            switch (table.table[i].getValue().getEducation()) {
                case 1:
                    education = 0;
                    a++;
                    break;
                case 2:
                    education = 1;
                    b++;
                    break;
                case 3:
                    education = 2;
                    c++;
                    break;
                case 4:
                    education = 3;
                    d++;
                    break;
                default:
                    break;
            }
            quality[education] += table.table[i].getValue().getQuality();
            
        }
        quality[0] = quality[0] / a;
        quality[1] = quality[1] / b;
        quality[2] = quality[2] / c;
        quality[3] = quality[3] / d;
        return quality;
    }

    public double[] lifeQualityIncomeBased()
    {
        double[] quality = {0,0,0,0};
        int a = 0, b = 0, c = 0, d = 0;
        for (int i = 0; i < table.getSize(); i++)
        {
            if(table.table[i] == null)
            {
                continue;
            }
            int income = -1;
            switch (table.table[i].getValue().getIncomeSource()) {
                case 1:
                    income = 0;
                    a++;
                    break;
                case 2:
                    income = 1;
                    b++;
                    break;
                case 3:
                    income = 2;
                    c++;
                    break;
                case 4:
                    income = 3;
                    d++;
                    break;
                default:
                    break;
            }
            quality[income] += table.table[i].getValue().getQuality();
            
        }
        quality[0] = quality[0] / a;
        quality[1] = quality[1] / b;
        quality[2] = quality[2] / c;
        quality[3] = quality[3] / d;
        return quality;
    }

    public double[] lifeQualityMaritalBased()
    {
        double[] quality = {0,0,0,0};
        int a = 0, b = 0, c = 0, d = 0;
        for (int i = 0; i < table.getSize(); i++)
        {
            if(table.table[i] == null)
            {
                continue;
            }
            int maritial = -1;
            switch (table.table[i].getValue().getMaritalStatus()) {
                case 1:
                    maritial = 0;
                    a++;
                    break;
                case 2:
                    maritial = 1;
                    b++;
                    break;
                case 3:
                    maritial = 2;
                    c++;
                    break;
                case 4:
                    maritial = 3;
                    d++;
                    break;
                default:
                    break;
            }
            quality[maritial] += table.table[i].getValue().getQuality();
            
        }
        quality[0] = quality[0] / a;
        quality[1] = quality[1] / b;
        quality[2] = quality[2] / c;
        quality[3] = quality[3] / d;
        return quality;
    }
    
    public double[] lifeQualitySmokerBased()
    {
        double[] quality = {0,0};
        int a = 0, b = 0;
        for (int i = 0; i < table.getSize(); i++)
        {
            if(table.table[i] == null)
            {
                continue;
            }
            int smoking = -1;
            switch (table.table[i].getValue().getSmoker()) {
                case 0:
                    smoking = 1;
                    a++;
                    break;
                case 1:
                    smoking = 0;
                    b++;
                    break;
                default:
                    break;
            }
            quality[smoking] += table.table[i].getValue().getQuality();
            
        }
        quality[0] = quality[0] / b;
        quality[1] = quality[1] / a;
        System.out.println(quality[0]);
        System.out.println(quality[1]);
        return quality;
    }

    public String[] mostCommonTreatment()
    {
        int[] treatments = {0,0,0,0,0};
        for (int i = 0; i < table.getSize(); i++)
        {
            if(table.table[i] == null)
            {
                continue;
            }
            String treatment = table.table[i].getValue().getQ9();
            if(treatment.contains("Immunotherapy"))
            {
                treatments[0] += 1;
            }
            if(treatment.contains("Chemo"))
            {
                treatments[1] += 1;
            }
            if(treatment.contains("Surg"))
            {
                treatments[2] += 1;
            }
            if(treatment.contains("Mole"))
            {
                treatments[3] += 1;
            }
            if(treatment.contains("Radio"))
            {
                treatments[4] += 1;
            }
        }
        int a = treatments[0];
        int b = treatments[1];
        int c = treatments[2];
        int d = treatments[3];
        int e = treatments[4];

        Arrays.sort(treatments);
        


        String[] treatmentNames = new String[5];
        for (int i = 0; i < treatments.length; i++)
        {
            if(treatments[i] == a)
            {
                treatmentNames[Math.abs(i-5) - 1] = "Immunotherapy";
            }
            else if(treatments[i] == b)
            {
                treatmentNames[Math.abs(i-5) - 1] = "Chemotherapy";
            }
            else if(treatments[i] == c)
            {
                treatmentNames[Math.abs(i-5) - 1] = "Surgical";
            }
            else if(treatments[i] == d)
            {
                treatmentNames[Math.abs(i-5) - 1] = "MolecularlyTargetedTherapy";
            }
            else if(treatments[i] == e)
            {
                treatmentNames[Math.abs(i-5) - 1] = "Radiotherapy";
            }
        }

        return treatmentNames;
    }

    public String[] mostCommonSymptoms()
    {
        int[] treatments = {0,0,0,0,0,0,0};
        for (int i = 0; i < table.getSize(); i++)
        {
            if(table.table[i] == null)
            {
                continue;
            }
            String treatment = table.table[i].getValue().getQ16();
            if(treatment.contains("Hoarseness"))
            {
                treatments[0] += 1;
            }
            if(treatment.contains("ChestPain"))
            {
                treatments[1] += 1;
            }
            if(treatment.contains("ShortnessOfBreath"))
            {
                treatments[2] += 1;
            }
            if(treatment.contains("None"))
            {
                treatments[3] += 1;
            }
            if(treatment.contains("Weakness"))
            {
                treatments[4] += 1;
            }
            if(treatment.contains("Cough;"))
            {
                treatments[5] += 1;
            }
            if(treatment.contains("CoughingUpBlood"))
            {
                treatments[6] += 1;
            }
        }
        int a = treatments[0];
        int b = treatments[1];
        int c = treatments[2];
        int d = treatments[3];
        int e = treatments[4];
        int f = treatments[5];
        int g = treatments[6];

        Arrays.sort(treatments);
        


        String[] treatmentNames = new String[7];
        for (int i = 0; i < treatments.length; i++)
        {
            if(treatments[i] == a)
            {
                treatmentNames[Math.abs(i-7) - 1] = "Hoarseness";
            }
            else if(treatments[i] == b)
            {
                treatmentNames[Math.abs(i-7) - 1] = "ChestPain";
            }
            else if(treatments[i] == c)
            {
                treatmentNames[Math.abs(i-7) - 1] = "ShortnessOfBreath";
            }
            else if(treatments[i] == d)
            {
                treatmentNames[Math.abs(i-7) - 1] = "None";
            }
            else if(treatments[i] == e)
            {
                treatmentNames[Math.abs(i-7) - 1] = "Weakness";
            }
            else if(treatments[i] == f)
            {
                treatmentNames[Math.abs(i-7) - 1] = "Cough";
            }
            else if(treatments[i] == g)
            {
                treatmentNames[Math.abs(i-7) - 1] = "CoughingUpBlood";
            }
        }

        return treatmentNames;
    }

    public String[] mostCommonLifeAspects()
    {
        int[] treatments = {0,0,0,0,0,0};
        for (int i = 0; i < table.getSize(); i++)
        {
            if(table.table[i] == null)
            {
                continue;
            }
            String treatment = table.table[i].getValue().getQ23();
            if(treatment.contains("SocialLife"))
            {
                treatments[0] += 1;
            }
            if(treatment.contains("FamilyLife"))
            {
                treatments[1] += 1;
            }
            if(treatment.contains("ProfessionalLife"))
            {
                treatments[2] += 1;
            }
            if(treatment.contains("DoesNotAffect"))
            {
                treatments[3] += 1;
            }
            if(treatment.contains("PhysicalAspect"))
            {
                treatments[4] += 1;
            }
            if(treatment.contains("PsychologicalAspect"))
            {
                treatments[5] += 1;
            }
        }
        int a = treatments[0];
        int b = treatments[1];
        int c = treatments[2];
        int d = treatments[3];
        int e = treatments[4];
        int f = treatments[5];

        Arrays.sort(treatments);
        


        String[] lifeAspects = new String[6];
        for (int i = 0; i < treatments.length; i++)
        {
            if(treatments[i] == a)
            {
                lifeAspects[Math.abs(i-6) - 1] = "SocialLife";
            }
            else if(treatments[i] == b)
            {
                lifeAspects[Math.abs(i-6) - 1] = "FamilyLife";
            }
            else if(treatments[i] == c)
            {
                lifeAspects[Math.abs(i-6) - 1] = "ProfessionalLife";
            }
            else if(treatments[i] == d)
            {
                lifeAspects[Math.abs(i-6) - 1] = "DoesNotAffect";
            }
            else if(treatments[i] == e)
            {
                lifeAspects[Math.abs(i-6) - 1] = "PhysicalAspect";
            }
            else if(treatments[i] == f)
            {
                lifeAspects[Math.abs(i-6) - 1] = "PsychologicalAspect";
            }
        }

        return lifeAspects;
    }

    public double[] lifeQualityMixConditionsBased()
    {
        double[] quality = {0,0};
        int a = 0, b = 0;

        for (int i = 0; i < table.getSize(); i++)
        {
            if(table.table[i] == null)
            {
                continue;
            }
            if(table.table[i].getValue().getMaritalStatus() == 1 && table.table[i].getValue().getResidence() == 4)
            {
                a++;
                quality[0] += table.table[i].getValue().getQuality();
            }
            if(table.table[i].getValue().getMaritalStatus() == 2 && (table.table[i].getValue().getResidence() == 2 || table.table[i].getValue().getResidence() == 1) )
            {
                b++;
                quality[1] += table.table[i].getValue().getQuality();
            }
        }

        quality[0] = quality[0]/a;
        quality[1] = quality[1]/b;
        System.out.println(quality[0]);
        System.out.println(quality[1]);
        return quality;
    }

    public double[] lifeQualityResponseBased()
    {
        double[] quality = {0,0,0,0};
        int a = 0, b = 0, c = 0, d = 0;
        for (int i = 0; i < table.getSize(); i++)
        {
            if(table.table[i] == null)
            {
                continue;
            }
            int selfResponse = -1;
            switch (table.table[i].getValue().getQ15()) {
                case 1:
                    selfResponse = 0;
                    a++;
                    break;
                case 2:
                    selfResponse = 1;
                    b++;
                    break;
                case 3:
                    selfResponse = 2;
                    c++;
                    break;
                case 4:
                    selfResponse = 3;
                    d++;
                    break;
                default:
                    break;
            }
            quality[selfResponse] += table.table[i].getValue().getQuality();
            
        }
        quality[0] = quality[0] / a;
        quality[1] = quality[1] / b;
        quality[2] = quality[2] / c;
        quality[3] = quality[3] / d;
        return quality;
    }

    public static void main(String[] args)
    {

    }
}
