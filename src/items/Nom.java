package items;

import java.util.Random;

/**
 * 
 * @author armya
 *
 */
public class Nom {

	private static final String[] NOM_POTION_SOIN = {	"Potion de soin minime",
												"Potion de soin",
												"Potion de soin majeur"};
	private static final String[] NOM_ARME = {	"Magelame du gladiateur orgueilleux", 
										"Xifeng, Lame longue du gardien titanesque", 
										"Gar’tok, force du croyant", 
										"Croissant crache-charbon", 
										"Regard d’arrogance", 
										"Lame courte de Norushen", 
										"Fendeur de crânes de Malkorok", 
										"Lame furieuse de Kil’ruk", 
										"Gar’tok, force du croyant", 
										"Xal’atoh, reflet profané de Hurlesang", 
										"Masse à cornes des très anciens", 
										"Sorcépée de tisse-arc", 
										"Mascaret sismique", 
										"Hache du gladiateur sans pitié", 
										"Faux de givre du seigneur Ahune", 
										"Masse à électrochoc de Zolvolt", 
										"Couperet cruel du Boucher", 
										"Faucheuse en arcanite", 
										"Crève-coeur équilibré", 
										"Masse de puissance amarante", 
										"Estramaçon éviscérateur sanglant"
										};
	private static final String[] NOM_CASQUE = {	"Casque impérissable du décimateur", 
											"Couronne de destruction", 
											"Casque borgne en anneaux", 
											"Coiffe en cendremailles", 
											"Casque de lumière directrice", 
											"Grand heaume trempé", 
											"Grand heaume trempé dans la lave"
											};
	private static final String[] NOM_TORSE = {"Cuirasse de paratonnerre", 
										"Cuirasse d’acier antique", 
										"Thorax du protecteur animé", 
										"Cuirasse d’insurrection", 
										"Cuirasse de fureur déferlante", 
										"Cuirasse de vaillance resplendissante", 
										"Corselet impérissable du décimateur", 
										"Corselet anti-craquelures", 
										"Tunique de randonnée", 
										"Corselet de spéléologue", 
										"Gilet des éléments mystique", 
										"Corselet de l’assiégeur"
										};
	private static final String[] NOM_JAMBE = {"Kilt de la chair ondoyante", 
										"Garde-jambes du rêve tordu", 
										"Jambières infusées d'éclairs", 
										"Jambières des charmes douteux", 
										"Jambières des aurores boréales", 
										"Kilt des rites oubliés", 
										"Cuissards de ver de lave",
										"Grèves de l’immolation", 
										"Grèves de la gloire radieuse", 
										"Cuissards des anneaux résonnants", 
										"Cuissards des ombres avisées", 
										"Cuissards de paratonnerre"
										};
	private static final String[] NOM_GANT = {	"Serres lamevent", 
										"Poignées de la panique", 
										"Gants de l’essaim écrasant", 
										"Gantelets d’insurrection", 
										"Gantelets broyeurs d’étoiles", 
										"Gantelets de lumière directrice", 
										"Poignes de sorcière du givre sanctifiées ", 
										"Garde-mains du tourmenté", 
										"Poignes des éléments déchaînés", 
										"Poignes ravivantes", 
										"Poignes de l’éruption volcanique", 
										"Gants chargés de foudre "
										};
	
	private static Random rand = new Random();

	public static String getNomPotionSoin (int valueSoin) {
		
		return Nom.NOM_POTION_SOIN[valueSoin];
	}
	public static String getNomArme () {
		int i = Nom.rand.nextInt((Nom.NOM_ARME.length));
		return Nom.NOM_ARME[i];
	}
	public static String getNomCasque () {
		int i = Nom.rand.nextInt((Nom.NOM_CASQUE.length));
		return Nom.NOM_CASQUE[i];
	}
	public static String getNomTorse () {
		int i = Nom.rand.nextInt((Nom.NOM_TORSE.length));
		return Nom.NOM_TORSE[i];
	}
	public static String getNomJambe () {
		int i = Nom.rand.nextInt((Nom.NOM_JAMBE.length));
		return Nom.NOM_JAMBE[i];
	}
	public static String getNomGant () {
		int i = Nom.rand.nextInt((Nom.NOM_GANT.length));
		return Nom.NOM_GANT[i];
	}
}
