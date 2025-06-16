package net.fawnoculus.ntm.byEloPlsDel;

public class ElementPrinter {
    public static void main(String[] args) {

        String Element = "schrabidium";
        String Extention1 = "fuel";

        System.out.println("public static final Item RAW_"+ Element.toUpperCase() +" = register(\"raw_"+ Element.toLowerCase() +"\", Item::new, new Item.Settings());");
        System.out.println("public static final Item "+ Element.toUpperCase() +"_CRYSTALS = register(\""+ Element.toLowerCase() +"_crystals\", Item::new, new Item.Settings());");
        System.out.println("public static final Item "+ Element.toUpperCase() +"_INGOT = register(\""+ Element.toLowerCase() +"_ingot\", Item::new, new Item.Settings());");
        System.out.println("public static final Item "+ Element.toUpperCase() +"_"+ Extention1.toUpperCase() + "_INGOT = register(\""+ Element.toLowerCase() +"_"+ Extention1.toLowerCase() + "_ingot\", Item::new, new Item.Settings());");
        System.out.println("public static final Item "+ Element.toUpperCase() +"_BILLET = register(\""+ Element.toLowerCase() +"_billet\", Item::new, new Item.Settings());");
        System.out.println("public static final Item "+ Element.toUpperCase() +"_"+ Extention1.toUpperCase() + "_BILLET = register(\""+ Element.toLowerCase() +"_"+ Extention1.toLowerCase() + "_billet\", Item::new, new Item.Settings());");
        System.out.println("public static final Item "+ Element.toUpperCase() +"_NUGGET = register(\""+ Element.toLowerCase() +"_nugget\", Item::new, new Item.Settings());");
        System.out.println("public static final Item "+ Element.toUpperCase() +"_"+ Extention1.toUpperCase() + "_NUGGET = register(\""+ Element.toLowerCase() +"_"+ Extention1.toLowerCase() + "_nugget\", Item::new, new Item.Settings());");
        System.out.println("public static final Item "+ Element.toUpperCase() +"_POWDER = register(\""+ Element.toLowerCase() +"_powder\", Item::new, new Item.Settings());");






    }
}
