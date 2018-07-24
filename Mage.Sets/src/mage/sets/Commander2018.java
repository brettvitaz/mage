package mage.sets;

import mage.cards.ExpansionSet;
import mage.constants.Rarity;
import mage.constants.SetType;

/**
 *
 * @author TheElk801
 */
public final class Commander2018 extends ExpansionSet {

    private static final Commander2018 instance = new Commander2018();

    public static Commander2018 getInstance() {
        return instance;
    }

    private Commander2018() {
        super("Commander 2018 Edition", "C18", ExpansionSet.buildDate(2018, 8, 10), SetType.SUPPLEMENTAL);
        this.blockName = "Command Zone";

        cards.add(new SetCardInfo("Ancient Stone Idol", 53, Rarity.RARE, mage.cards.a.AncientStoneIdol.class));
        cards.add(new SetCardInfo("Avenger of Zendikar", 129, Rarity.MYTHIC, mage.cards.a.AvengerOfZendikar.class));
        cards.add(new SetCardInfo("Bloodtracker", 14, Rarity.RARE, mage.cards.b.Bloodtracker.class));
        cards.add(new SetCardInfo("Budoka Gardener", 134, Rarity.RARE, mage.cards.b.BudokaGardener.class));
        cards.add(new SetCardInfo("Centaur Vinecrasher", 135, Rarity.RARE, mage.cards.c.CentaurVinecrasher.class));
        cards.add(new SetCardInfo("Chain Reaction", 121, Rarity.RARE, mage.cards.c.ChainReaction.class));
        cards.add(new SetCardInfo("Chaos Warp", 122, Rarity.RARE, mage.cards.c.ChaosWarp.class));
        cards.add(new SetCardInfo("Echo Storm", 7, Rarity.RARE, mage.cards.e.EchoStorm.class));
        cards.add(new SetCardInfo("Eidolon of Blossoms", 140, Rarity.RARE, mage.cards.e.EidolonOfBlossoms.class));
        cards.add(new SetCardInfo("Enchanter's Bane", 21, Rarity.RARE, mage.cards.e.EnchantersBane.class));
        cards.add(new SetCardInfo("Explosive Vegetation", 144, Rarity.UNCOMMON, mage.cards.e.ExplosiveVegetation.class));
        cards.add(new SetCardInfo("Forge of Heroes", 58, Rarity.COMMON, mage.cards.f.ForgeOfHeroes.class));
        cards.add(new SetCardInfo("Loyal Drake", 10, Rarity.UNCOMMON, mage.cards.l.LoyalDrake.class));
        cards.add(new SetCardInfo("Loyal Guardian", 31, Rarity.UNCOMMON, mage.cards.l.LoyalGuardian.class));
        cards.add(new SetCardInfo("Loyal Subordinate", 16, Rarity.UNCOMMON, mage.cards.l.LoyalSubordinate.class));
        cards.add(new SetCardInfo("Rampaging Baloths", 158, Rarity.RARE, mage.cards.r.RampagingBaloths.class));
        cards.add(new SetCardInfo("Retrofitter Foundry", 57, Rarity.RARE, mage.cards.r.RetrofitterFoundry.class));
        cards.add(new SetCardInfo("Ruinous Path", 117, Rarity.RARE, mage.cards.r.RuinousPath.class));
        cards.add(new SetCardInfo("Saheeli's Directive", 26, Rarity.RARE, mage.cards.s.SaheelisDirective.class));
        cards.add(new SetCardInfo("Scute Mob", 161, Rarity.RARE, mage.cards.s.ScuteMob.class));
        cards.add(new SetCardInfo("Tawnos, Urza's Apprentice", 45, Rarity.MYTHIC, mage.cards.t.TawnosUrzasApprentice.class));
        cards.add(new SetCardInfo("Thantis the Warweaver", 46, Rarity.MYTHIC, mage.cards.t.ThantisTheWarweaver.class));
        cards.add(new SetCardInfo("Thopter Spy Network", 107, Rarity.RARE, mage.cards.t.ThopterSpyNetwork.class));
        cards.add(new SetCardInfo("Whiptongue Hydra", 36, Rarity.RARE, mage.cards.w.WhiptongueHydra.class));
    }
}
