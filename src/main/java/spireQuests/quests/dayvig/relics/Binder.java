package spireQuests.quests.dayvig.relics;

import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.vfx.RainingGoldEffect;
import spireQuests.abstracts.AbstractSQRelic;

import static spireQuests.Anniv8Mod.makeID;

public class Binder extends AbstractSQRelic {

    public static final String ID = makeID(Binder.class.getSimpleName());
    public static final int DIVISOR = 25;


    public Binder() {
        super(ID, "dayvig", RelicTier.SPECIAL, LandingSound.FLAT);
    }


    @Override
    public void onEquip() {
        int targetMaxHP = (int) Math.ceil((double)AbstractDungeon.player.maxHealth / DIVISOR) * DIVISOR;
        int targetGold = (int)Math.ceil((double)AbstractDungeon.player.gold / DIVISOR) * DIVISOR;
        AbstractDungeon.player.increaseMaxHp(targetMaxHP - AbstractDungeon.player.maxHealth, true);
        AbstractDungeon.player.gainGold(targetGold - AbstractDungeon.player.gold);
        addToBot(new VFXAction(new RainingGoldEffect(targetGold - AbstractDungeon.player.gold)));
    }
}

