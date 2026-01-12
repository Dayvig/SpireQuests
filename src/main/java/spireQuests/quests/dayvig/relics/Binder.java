package spireQuests.quests.dayvig.relics;

import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.vfx.UpgradeShineEffect;
import com.megacrit.cardcrawl.vfx.campfire.CampfireSmithEffect;
import com.megacrit.cardcrawl.vfx.cardManip.ShowCardBrieflyEffect;
import spireQuests.abstracts.AbstractSQRelic;

import java.util.ArrayList;

import static spireQuests.Anniv8Mod.makeID;

public class Binder extends AbstractSQRelic {

    public static final String ID = makeID(Binder.class.getSimpleName());

    public Binder() {
        super(ID, "dayvig", RelicTier.SPECIAL, LandingSound.FLAT);
    }

    public void onEquip() {
        ArrayList<AbstractCard> upgradableCards = new ArrayList();
        for (AbstractCard c: AbstractDungeon.player.masterDeck.group){
            if (c.canUpgrade()){ upgradableCards.add(c); }
        }
        if (upgradableCards.isEmpty()){
            return;
        }
        if (upgradableCards.size() == 1){
            upgradableCards.get(0).upgrade();
            AbstractDungeon.player.bottledCardUpgradeCheck(upgradableCards.get(0));
            AbstractDungeon.topLevelEffects.add(new ShowCardBrieflyEffect((upgradableCards.get(0)).makeStatEquivalentCopy(), (float)Settings.WIDTH / 2.0F + AbstractCard.IMG_WIDTH / 2.0F + 20.0F * Settings.scale, (float)Settings.HEIGHT / 2.0F));
            AbstractDungeon.topLevelEffects.add(new UpgradeShineEffect((float)Settings.WIDTH / 2.0F, (float)Settings.HEIGHT / 2.0F));
        }
        else {
            int upgrade1 = AbstractDungeon.miscRng.random(0, upgradableCards.size()-1);
            int upgrade2;
            do {
                upgrade2 = AbstractDungeon.miscRng.random(0, upgradableCards.size()-1);
            }
            while (upgrade2 == upgrade1);
            upgradableCards.get(upgrade1).upgrade();
            AbstractDungeon.player.bottledCardUpgradeCheck(upgradableCards.get(upgrade1));
            upgradableCards.get(upgrade2).upgrade();
            AbstractDungeon.player.bottledCardUpgradeCheck(upgradableCards.get(upgrade2));
            AbstractDungeon.topLevelEffects.add(new ShowCardBrieflyEffect((upgradableCards.get(upgrade1)).makeStatEquivalentCopy(), (float)Settings.WIDTH / 2.0F - AbstractCard.IMG_WIDTH / 2.0F - 20.0F * Settings.scale, (float)Settings.HEIGHT / 2.0F));
            AbstractDungeon.topLevelEffects.add(new ShowCardBrieflyEffect((upgradableCards.get(upgrade2)).makeStatEquivalentCopy(), (float)Settings.WIDTH / 2.0F + AbstractCard.IMG_WIDTH / 2.0F + 20.0F * Settings.scale, (float)Settings.HEIGHT / 2.0F));
            AbstractDungeon.topLevelEffects.add(new UpgradeShineEffect((float)Settings.WIDTH / 2.0F, (float)Settings.HEIGHT / 2.0F));
        }
        }
}

