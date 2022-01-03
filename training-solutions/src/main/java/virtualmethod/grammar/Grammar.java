package virtualmethod.grammar;

public class Grammar {

    public static void main(String[] args) {
        Verb verbPhrasalVerb = new PhrasalVerb("mászik", "le");
        Verb verbPhrasalVerbWithSuffix = new PhrasalVerbWithSuffix("fut", "el", "ott");
        Preposition prepositionPhrasalVerb = new PhrasalVerb("ugrik", "le");
        Preposition prepositionPhrasalVerbWithSuffix = new PhrasalVerbWithSuffix("énekel", "el", "ne");
        PhrasalVerb phrasalVerb = new PhrasalVerb("merít", "ki");
        PhrasalVerb phrasalVerbPhrasalVerbWithSuffix = new PhrasalVerbWithSuffix("rajzol", "meg", "hat");
        Suffix suffixPhrasalVerbWithSuffix = new PhrasalVerbWithSuffix("vándorol", "ki", "na");
        PhrasalVerbWithSuffix phrasalVerbWithSuffix = new PhrasalVerbWithSuffix("bérel", "fel", "t");

        System.out.println(verbPhrasalVerb.getWord());
        System.out.println(verbPhrasalVerbWithSuffix.getWord());
        System.out.println(prepositionPhrasalVerb.getPreposition());
        System.out.println(prepositionPhrasalVerb.getWholeWord());
        System.out.println(prepositionPhrasalVerbWithSuffix.getPreposition());
        System.out.println(prepositionPhrasalVerbWithSuffix.getWholeWord());
        System.out.println(phrasalVerb.getPreposition());
        System.out.println(phrasalVerb.getWord());
        System.out.println(phrasalVerb.getWholeWord());
        System.out.println(phrasalVerbPhrasalVerbWithSuffix.getPreposition());
        System.out.println(phrasalVerbPhrasalVerbWithSuffix.getWord());
        System.out.println(phrasalVerbPhrasalVerbWithSuffix.getWholeWord());
        System.out.println(suffixPhrasalVerbWithSuffix.getSuffix());
        System.out.println(phrasalVerbWithSuffix.getPreposition());
        System.out.println(phrasalVerbWithSuffix.getWord());
        System.out.println(phrasalVerbWithSuffix.getSuffix());
        System.out.println(phrasalVerbWithSuffix.getWholeWord());
    }


}
