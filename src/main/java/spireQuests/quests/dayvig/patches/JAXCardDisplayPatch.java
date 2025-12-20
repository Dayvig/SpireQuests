package spireQuests.quests.dayvig.patches;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.evacipated.cardcrawl.modthespire.lib.SpireReturn;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.colorless.JAX;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import spireQuests.quests.dayvig.relics.MutagenBlood;

public class JAXCardDisplayPatch {
    @SpirePatch(clz = AbstractCard.class, method = "renderDescription", paramtypez = SpriteBatch.class)

    public static class JAXModifyDescription {
        public static void Prefix(AbstractCard __instance, SpriteBatch sb){
            if (__instance.cardID.equals(JAX.ID) && AbstractDungeon.player.hasRelic(MutagenBlood.ID)){
                for (Character a : __instance.rawDescription.getChars(0, __instance.rawDescription.length());){

                }
            }


        }
