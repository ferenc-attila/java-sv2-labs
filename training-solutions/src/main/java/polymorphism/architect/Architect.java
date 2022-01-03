package polymorphism.architect;

public class Architect {

    public static void main(String[] args) {

        Plan plan = new SketchPlan(5, "Megfigyelőtorony");
        Plan planPermitPlan = new PermitPlan(14, "Látogatóközpont", "Nemzeti Park", "Zabar, 025/14");
        Plan planConstructionPlan = new ConstructionPlan(9, "Madárvárta", "Egyesület", "Pély, 045/78", 19);
        SketchPlan sketchPlan = new SketchPlan(5, "Iroda");
        SketchPlan sketchPermitPlan = new PermitPlan(11, "Gépszín", "Agrár Rt.", "Kiskunmajsa, Rigó u. 5.");
        SketchPlan sketchConstructionPlan = new ConstructionPlan(456, "Áruház", "Kereskedelmi Rt", "Budapest, Nagy körút 76", 567);
        Header headerPermitPlan = new PermitPlan(65, "Lakóház", "Mérő Tivadar", "Perbál, Golyó utca 6");
        Header headerConstructionPlan = new ConstructionPlan(124, "Műhely", "Asztalos Kft", "Hegykő, Kossuth u. 87", 45);
        PermitPlan permitPlan = new PermitPlan(25, "Istálló", "Kovács Géza", "Kaposmérő, Fő út 96");
        PermitPlan permitConstructionPlan = new ConstructionPlan(56, "Szivattyúház", "Vízmű Rt", "Dévaványa 025/78", 45);
        ConstructionPlan constructionPlan = new ConstructionPlan(23, "Mobiltorony", "Mobiltelefon Rt", "Kéked Kiskő út 45", 56);

        System.out.println(plan.getPagesOfDocumentation());
        System.out.println(planPermitPlan.getPagesOfDocumentation());
        System.out.println(planConstructionPlan.getPagesOfDocumentation());
        System.out.println(sketchPlan.getPagesOfDocumentation());
        System.out.println(sketchPlan.getTitle());
        System.out.println(sketchPermitPlan.getPagesOfDocumentation());
        System.out.println(sketchPermitPlan.getTitle());
        System.out.println(sketchConstructionPlan.getPagesOfDocumentation());
        System.out.println(sketchConstructionPlan.getTitle());
        System.out.println(headerPermitPlan.getNameOfClient());
        System.out.println(headerPermitPlan.getAddressOfBuilding());
        System.out.println(headerConstructionPlan.getNameOfClient());
        System.out.println(headerConstructionPlan.getAddressOfBuilding());
        System.out.println(permitPlan.getPagesOfDocumentation());
        System.out.println(permitPlan.getTitle());
        System.out.println(permitPlan.getNameOfClient());
        System.out.println(permitPlan.getAddressOfBuilding());
        System.out.println(permitPlan.getHeader());
        System.out.println(permitConstructionPlan.getPagesOfDocumentation());
        System.out.println(permitConstructionPlan.getTitle());
        System.out.println(permitConstructionPlan.getNameOfClient());
        System.out.println(permitConstructionPlan.getAddressOfBuilding());
        System.out.println(permitConstructionPlan.getHeader());
        System.out.println(constructionPlan.getPagesOfDocumentation());
        System.out.println(constructionPlan.getTitle());
        System.out.println(constructionPlan.getNameOfClient());
        System.out.println(constructionPlan.getAddressOfBuilding());
        System.out.println(constructionPlan.getHeader());
        System.out.println(constructionPlan.getSheetsOfConstructionDrawings());
    }
}
