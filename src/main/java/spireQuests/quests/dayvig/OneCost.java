package spireQuests.quests.dayvig;

import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import spireQuests.patches.QuestTriggers;
import spireQuests.quests.AbstractQuest;
import spireQuests.quests.QuestReward;
import spireQuests.quests.dayvig.relics.Binder;

public class OneCost extends AbstractQuest {
    public OneCost() {
        super(QuestType.LONG, QuestDifficulty.EASY);

        new TriggerTracker<>(QuestTriggers.ADD_CARD, 10)
                .triggerCondition(this::isOneCost)
                .add(this);

        addReward(new QuestReward.GoldReward(50));
    }

    public boolean isOneCost(AbstractCard card) {
        return card.cost == 1;
    }

    @Override
    public boolean canSpawn() {
        return AbstractDungeon.actNum < 3;
    }
}
