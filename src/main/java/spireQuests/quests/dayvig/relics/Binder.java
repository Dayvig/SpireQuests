package spireQuests.quests.dayvig.relics;

import spireQuests.abstracts.AbstractSQRelic;

import static spireQuests.Anniv8Mod.makeID;

public class Binder extends AbstractSQRelic {

    public static final String ID = makeID(Binder.class.getSimpleName());

    public Binder() {
        super(ID, "dayvig", RelicTier.SPECIAL, LandingSound.FLAT);
    }

}

